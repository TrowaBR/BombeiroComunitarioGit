package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.dao.UnidadeDAO;
import br.edu.unisociesc.dao.UsuarioDAO;
import br.edu.unisociesc.model.AgendamentoScheduleEvent;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.model.TiposGraduacao;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    private Unidade unidade_fixa;

    private static final double HORAS_PERIODO = 120;
    private static final int NUM_PERIODOS = 6;

    private ScheduleModel eventModel;
    private AgendamentoScheduleEvent event;

    private int horasPeriodo;
    private int horasMes;
    
    private AgendamentoScheduleEvent novoAgendamento() {
        return novoAgendamento(new Date(), new Date());
    }

    private AgendamentoScheduleEvent novoAgendamento(Date start, Date end) {
        return novoAgendamento(usuario_fixo, unidade_fixa, start, end);
    }

    private AgendamentoScheduleEvent novoAgendamento(Usuario usuario, Unidade unidade, Date start, Date end) {
        return new AgendamentoScheduleEvent(usuario, unidade, start, end);
    }

    private AgendamentoScheduleEvent novoAgendamento(Agendamento agendamento) {
        return new AgendamentoScheduleEvent(agendamento.getUsuario(), agendamento.getUnidade(), agendamento.getEntrada(), agendamento.getSaida());
    }

    @PostConstruct
    public void init() {
        usuario_fixo = new Usuario(1, "BC Hening", "Hening", new Date(), "M", TiposGraduacao.BC, new Date(), "123", "", 0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
        unidade_fixa = new Unidade(1, "Centro", new Date(), new Date(), 0, 0, new Date(), new Date(), new Date(), new Date(), true, "", "", 0, "");

        event = novoAgendamento();
        horasPeriodo = 35;
        horasMes = 18;
    }

    public ScheduleModel getEventModel() {
        if (eventModel == null) {
            eventModel = new DefaultScheduleModel();
            AgendamentoDAO dao = new AgendamentoDAO();
            Calendar c = GregorianCalendar.getInstance();
            c.setTime(new Date());
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c.set(Calendar.DAY_OF_MONTH, 1);
            List<Agendamento> lista = dao.list(EstadoAgendamento.Aprovado, c.getTime());
            
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
        return horasPeriodo;
    }

    public int getPercPeriodo() {
        return (int) (100.0 * horasPeriodo / HORAS_PERIODO);
    }

    public int getHorasMes() {
        return horasMes;
    }
    
    public int getPercMes() {
        return (int) (100.0 * horasMes / (HORAS_PERIODO / NUM_PERIODOS));
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
