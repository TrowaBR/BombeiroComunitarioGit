package br.edu.unisociesc.model;

public class ConfirmacaoAgendamento {
    
    private int aprovado;
    private AgendamentoRaphael agendamento;

    public ConfirmacaoAgendamento(int aprovado, AgendamentoRaphael agendamento) {
        this.aprovado = aprovado;
        this.agendamento = agendamento;
    }

    public int getAprovado() {
        return aprovado;
    }

    public void setAprovado(int aprovado) {
        this.aprovado = aprovado;
    }

    public AgendamentoRaphael getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(AgendamentoRaphael agendamento) {
        this.agendamento = agendamento;
    }

    
    
}
