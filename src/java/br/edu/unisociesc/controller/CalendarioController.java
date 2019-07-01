package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.dao.UnidadeDAO;
import br.edu.unisociesc.dao.UsuarioDAO;
import br.edu.unisociesc.model.AgendamentoScheduleEvent;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
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

    private Calendar inicioMes;

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

    private AgendamentoScheduleEvent novoAgendamento(Agendamento agendamento) {
        return new AgendamentoScheduleEvent(agendamento);
    }
    
    @PostConstruct
    public void init() {
        agendamentoDAO = new AgendamentoDAO();
        usuarioDAO = new UsuarioDAO();
        unidadeDAO = new UnidadeDAO();
        unidadeId = "";

        inicioMes = Calendar.getInstance();
        inicioMes.setTime(new Date());
        inicioMes.set(Calendar.HOUR_OF_DAY, 0);
        inicioMes.set(Calendar.MINUTE, 0);
        inicioMes.set(Calendar.SECOND, 0);
        inicioMes.set(Calendar.MILLISECOND, 0);
        inicioMes.set(Calendar.DAY_OF_MONTH, 1);
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
        horasPeriodo = 0;
        horasMes = 0;

        if (unidadeId.length() > 0) {
            unidade = getUnidadeById(Long.parseLong(unidadeId));

            List<Agendamento> lista = agendamentoDAO.listPeriodo(EstadoAgendamento.Aprovado, new Date(), unidade);
            double horas;
            for (Agendamento item : lista) {
                horas = item.getDuracao() / 60;
                if (inicioMes.before(item.getSaida())) {
                    horasMes += horas;
                    getEventModel().addEvent(novoAgendamento(item));
                }
                horasPeriodo += horas;
            }

            lista = agendamentoDAO.list(EstadoAgendamento.Solicitado, new Date(), null, getUsuario());
            
            for (Agendamento item : lista) {
                getEventModel().addEvent(novoAgendamento(item));
            }
        } else {
            unidade = null;
        }
    }

    public void addEvent() {
        AgendamentoDAO dao = new AgendamentoDAO();
        event.getAgendamento().setUnidade(unidade);
        dao.save(event.getAgendamento());
        event.setEditable(false);
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

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