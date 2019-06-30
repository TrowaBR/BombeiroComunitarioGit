package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.dao.UnidadeDAO;
import br.edu.unisociesc.dao.UsuarioDAO;
import br.edu.unisociesc.model.AgendamentoScheduleEvent;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class CalendarioController implements Serializable {

    private Usuario usuario_fixo;

    private ScheduleModel eventModel;
    private AgendamentoScheduleEvent event;
    
    private AgendamentoDAO agendamentoDAO;

    private List<Unidade> unidades;
    private long unidadeId;

    private double horasPeriodo = -1;
    private double horasMes = -1;
    
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

    private AgendamentoScheduleEvent novoAgendamento(Date start, Date end) {
        if (usuario_fixo == null) {
            usuario_fixo = new UsuarioDAO().getUsuario(1);
        }
        return novoAgendamento(usuario_fixo, getUnidadeById(unidadeId), start, end);
    }

    private AgendamentoScheduleEvent novoAgendamento(Usuario usuario, Unidade unidade, Date start, Date end) {
        return new AgendamentoScheduleEvent(usuario, unidade, start, end);
    }

    private AgendamentoScheduleEvent novoAgendamento(Agendamento agendamento) {
        return new AgendamentoScheduleEvent(agendamento);
    }

    @PostConstruct
    public void init() {
        agendamentoDAO = new AgendamentoDAO();
        event = novoAgendamento();
        horasPeriodo = 0;
        horasMes = 0;
    }

    public ScheduleModel getEventModel() {
        if (eventModel == null) {
            eventModel = new DefaultScheduleModel();
            Calendar calMes = Calendar.getInstance();
            calMes.setTime(new Date());
            calMes.set(Calendar.HOUR_OF_DAY, 0);
            calMes.set(Calendar.MINUTE, 0);
            calMes.set(Calendar.SECOND, 0);
            calMes.set(Calendar.MILLISECOND, 0);
            calMes.set(Calendar.DAY_OF_MONTH, 1);

            List<Agendamento> lista = agendamentoDAO.listPeriodo(EstadoAgendamento.Aprovado, new Date());
            double horas;
            for (Agendamento item : lista) {
                horas = item.getDuracao() / 60;
                if (calMes.after(item.getSaida())) {
                    horasMes += horas;
                }
                horasPeriodo += horas;

                eventModel.addEvent(novoAgendamento(item));
            }

            lista = agendamentoDAO.list(EstadoAgendamento.Solicitado, new Date(), null, usuario_fixo);
            
            for (Agendamento item : lista) {
                eventModel.addEvent(novoAgendamento(item));
            }
        }
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
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
            unidades = new UnidadeDAO().list();
        }
        return unidades;
    }
    public long getUnidadeId() {
        return unidadeId;
    }
    
    public void setUnidadeId(long unidadeId) {
        this.unidadeId = unidadeId;
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

        event = novoAgendamento();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (AgendamentoScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        Date start = (Date) selectEvent.getObject();
        Date end   = (Date) selectEvent.getObject();

        event = novoAgendamento(start, end);
    }
}