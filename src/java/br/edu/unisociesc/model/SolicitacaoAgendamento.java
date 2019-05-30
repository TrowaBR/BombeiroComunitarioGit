package br.edu.unisociesc.model;

import java.util.Date;
import org.primefaces.model.DefaultScheduleEvent;

public class SolicitacaoAgendamento extends DefaultScheduleEvent {

    private Agendamento agendamento;
    
    public SolicitacaoAgendamento(Usuario usuario, Unidade unidade, Date start, Date end) {
        super(usuario.getNomeGuerra(), start, end);
        agendamento = new Agendamento(null, unidade, usuario, EstadoAgendamento.Solicitado, start, end);
    }

    public SolicitacaoAgendamento() {
        agendamento = new Agendamento();
    }
    
    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
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