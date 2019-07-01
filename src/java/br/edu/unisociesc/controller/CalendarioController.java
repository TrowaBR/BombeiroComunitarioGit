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
import javax.faces.bean.ViewScoped;
import org.hibernate.ObjectNotFoundException;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class CalendarioController implements Serializable {

    private Usuario usuario;

    private ScheduleModel eventModel;
    private AgendamentoScheduleEvent event;
    
    private AgendamentoDAO agendamentoDAO;

    private List<Unidade> unidades;
    private Unidade unidade;
    private String unidadeId;

    private Calendar inicioMes;

    private double horasPeriodo;
    private double horasMes;
    
    private AgendamentoScheduleEvent novoAgendamento() {
        return novoAgendamento(new Date(), new Date());
    }

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
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            usuario = usuarioDAO.getUsuario(1);

            try {
                usuario.getId();
            } catch (ObjectNotFoundException e) {
                usuario = Testes.novoUsuario();
                usuarioDAO.save(usuario);
            }
        }
        return usuario;
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
        unidadeId = "";

        inicioMes = Calendar.getInstance();
        inicioMes.setTime(new Date());
        inicioMes.set(Calendar.HOUR_OF_DAY, 0);
        inicioMes.set(Calendar.MINUTE, 0);
        inicioMes.set(Calendar.SECOND, 0);
        inicioMes.set(Calendar.MILLISECOND, 0);
        inicioMes.set(Calendar.DAY_OF_MONTH, 1);
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
    
    public List<Unidade> getUnidades() {
        if (unidades == null) {
            UnidadeDAO unidadeDAO = new UnidadeDAO();
            unidades = unidadeDAO.list();

            if (unidades.isEmpty()) {
                Unidade u = Testes.novaUnidade();
                unidades.add(u);
                unidadeDAO.save(u);
            }
        }
        return unidades;
    }

    public void atualizaUnidade() {
        getEventModel().clear();
        horasPeriodo = 0;
        horasMes = 0;

        if (unidadeId.length() > 0) {
            unidade = getUnidadeById(Integer.parseInt(unidadeId));

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
}