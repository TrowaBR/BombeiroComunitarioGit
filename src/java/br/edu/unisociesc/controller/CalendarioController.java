package br.edu.unisociesc.controller;

import br.edu.unisociesc.model.SolicitacaoAgendamento;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class CalendarioController implements Serializable {

    private static final double HORAS_PERIODO = 120;
    private static final int NUM_PERIODOS = 6;

    private ScheduleModel eventModel;
    private DefaultScheduleEvent event = new SolicitacaoAgendamento();

    private int horasPeriodo;
    private int horasMes;

    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
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
        this.event = (SolicitacaoAgendamento) event;
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
        event.setEditable(false);
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (DefaultScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        Date start = (Date) selectEvent.getObject();
        Date end   = (Date) selectEvent.getObject();

        event = new DefaultScheduleEvent("BC Hening", start, end);
    }
}
