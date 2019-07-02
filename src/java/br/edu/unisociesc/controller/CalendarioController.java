package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.dao.UnidadeDAO;
import br.edu.unisociesc.dao.UsuarioDAO;
import br.edu.unisociesc.model.AgendamentoScheduleEvent;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
import br.edu.unisociesc.utils.DateUtil;
import br.edu.unisociesc.utils.Testes;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.ObjectNotFoundException;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@SessionScoped
public class CalendarioController implements Serializable {

    private Usuario usuario;

    private ScheduleModel eventModel;
    private AgendamentoScheduleEvent event;
    
    private AgendamentoDAO agendamentoDAO;
    private UsuarioDAO usuarioDAO;
    private UnidadeDAO unidadeDAO;

    private List<Unidade> unidades;
    private Unidade unidade;
    private String unidadeId;

    private Calendar inicioSchedule;

    private double horasPeriodo;
    private double horasMes;
    
    private Unidade getUnidadeById(long id) {
        for (Unidade u : getUnidades()) {
            if (u.getId() == id) {
                return u;
            }
        }
        return getUnidades().get(0);
    }
    
    private Usuario getUsuario() {
        if (usuario == null) {
            usuario = usuarioDAO.getUsuario(1);
            try {
                usuario.getId();
            } catch (ObjectNotFoundException e) {
                usuario = Testes.novoUsuario01();
                usuarioDAO.save(usuario);
                usuario = usuarioDAO.getUsuario(usuario.getId());
            }
        }
        return usuario;
    }

    private AgendamentoScheduleEvent novoAgendamento() {
        return novoAgendamento(new Date(), new Date());
    }

    private AgendamentoScheduleEvent novoAgendamento(Date start, Date end) {
        return new AgendamentoScheduleEvent(getUsuario(), unidade, start, end);
    }

    @PostConstruct
    public void init() {
        agendamentoDAO = new AgendamentoDAO();
        usuarioDAO = new UsuarioDAO();
        unidadeDAO = new UnidadeDAO();
        unidadeId = "";

        inicioSchedule = Calendar.getInstance();
        inicioSchedule.setTime(new Date());
        inicioSchedule.set(Calendar.DAY_OF_MONTH, 0);
        inicioSchedule = DateUtil.inicioDia(inicioSchedule);
    }
    
    public List<Unidade> getUnidades() {
        if (unidades == null) {
            unidades = unidadeDAO.list();

            if (unidades.isEmpty()) {
                unidadeDAO.save(Testes.novaUnidade01());
                unidadeDAO.save(Testes.novaUnidade02());
                unidades = unidadeDAO.list();
            }
        }
        return unidades;
    }

    public void atualizaUnidade() {
        getEventModel().clear();
        AgendamentoScheduleEvent eventoTabela;
        horasPeriodo = 0;
        horasMes = 0;

        if (unidadeId.length() > 0) {
            unidade = getUnidadeById(Long.parseLong(unidadeId));

            List<Agendamento> lista = agendamentoDAO.list(EstadoAgendamento.Aprovado, DateUtil.inicioPeriodo(new Date()), DateUtil.terminoPeriodo(new Date()), null, null);
            double horas;
            for (Agendamento item : lista) {
                horas = item.getDuracao() / 60;
                if (inicioSchedule.getTime().before(item.getSaida())) {
                    horasMes += horas;

                    if (unidade.getId() == item.getId()) {
                        eventoTabela = new AgendamentoScheduleEvent(item);
                        eventoTabela.setEditable(false);
                        getEventModel().addEvent(eventoTabela);
                    }
                }
                horasPeriodo += horas;
            }

            lista = agendamentoDAO.list(EstadoAgendamento.Solicitado, inicioSchedule.getTime(), null, getUsuario(), unidade);
            
            for (Agendamento item : lista) {
                eventoTabela = new AgendamentoScheduleEvent(item);
                eventoTabela.setEditable(false);
                getEventModel().addEvent(eventoTabela);
            }
        } else {
            unidade = null;
        }
    }

    private void addAgendamento(AgendamentoScheduleEvent evento) {
        evento.setEditable(false);
        if (evento.getId() == null) {
            eventModel.addEvent(evento);
        } else {
            eventModel.updateEvent(evento);
        }
    }

    public void addEvent() {
        AgendamentoDAO dao = new AgendamentoDAO();
        event.getAgendamento().setUnidade(unidade);
        dao.save(event.getAgendamento());
        addAgendamento(event);
        setEvent(novoAgendamento());
    }

    public void onEventSelect(SelectEvent selectEvent) {
        setEvent((AgendamentoScheduleEvent) selectEvent.getObject());
    }

    public void onDateSelect(SelectEvent selectEvent) {
        Date start = (Date) selectEvent.getObject();
        Date end   = (Date) selectEvent.getObject();

        setEvent(novoAgendamento(start, end));
    }

    public ScheduleModel getEventModel() {
        if (eventModel == null) {
            eventModel = new DefaultScheduleModel();
        }
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public String getUnidadeId() {
        return unidadeId;
    }
    
    public void setUnidadeId(String unidadeId) {
        this.unidadeId = unidadeId;
    }
    
    public void setEvent(ScheduleEvent event) {
        this.event = (AgendamentoScheduleEvent) event;
    }

    public int getHorasPeriodo() {
        return (int) horasPeriodo;
    }

    public int getPercPeriodo() {
        return (int) Math.min(100.0 * horasPeriodo / AgendamentoDAO.HORAS_PERIODO, 100);
    }

    public int getHorasMes() {
        return (int) horasMes;
    }
    
    public int getPercMes() {
        return (int) Math.min(100.0 * horasMes / (AgendamentoDAO.HORAS_PERIODO / AgendamentoDAO.NUM_PERIODOS), 100);
    }
}