package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.model.AgendamentoScheduleEvent;
import br.edu.unisociesc.model.TiposGraduacao;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
import java.io.Serializable;
import java.util.Date;
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

    private static final Usuario USUARIO_FIXO = new Usuario(1, "BC Hening", "Hening", new Date(), "M", TiposGraduacao.BC, new Date(), "123", "", 0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    private static final Unidade UNIDADE_FIXA = new Unidade("Centro", new Date(), new Date(), 0, 0, new Date(), new Date(), new Date(), new Date(), true, "", "", 0, "");

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
        //return new AgendamentoScheduleEvent(USUARIO_FIXO, UNIDADE_FIXA, start, end);
        return new AgendamentoScheduleEvent(null, null, null, null);
    }

    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        event = new AgendamentoScheduleEvent(); //novoAgendamento();
        horasPeriodo = 35;
        horasMes = 18;
    }

    public ScheduleModel getEventModel() {
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
