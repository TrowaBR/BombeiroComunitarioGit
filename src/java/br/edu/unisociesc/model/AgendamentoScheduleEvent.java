package br.edu.unisociesc.model;

import java.util.Date;
import org.primefaces.model.DefaultScheduleEvent;

public class AgendamentoScheduleEvent extends DefaultScheduleEvent {

    private Agendamento agendamento;
    
    public AgendamentoScheduleEvent(Usuario usuario, Unidade unidade, Date start, Date end) {
        super(usuario.getNomeGuerra(), start, end);
        agendamento = new Agendamento(0, unidade, usuario, EstadoAgendamento.Solicitado, start, end);
    }

    public AgendamentoScheduleEvent() {
        super();
        agendamento = new Agendamento();
    }
    
    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    @Override
    public String getTitle() {
        return agendamento.getUsuario().getNomeGuerra();
    }

    @Override
    public void setStartDate(Date startDate) {
        super.setStartDate(startDate);
        agendamento.setEntrada(startDate);
    }

    @Override
    public void setEndDate(Date endDate) {
        super.setEndDate(endDate);
        agendamento.setSaida(endDate);
    }

}