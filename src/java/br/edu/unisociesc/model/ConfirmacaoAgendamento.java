package br.edu.unisociesc.model;

public class ConfirmacaoAgendamento {
    
    private int aprovado;
    private Agendamento agendamento;

    public ConfirmacaoAgendamento(int aprovado, Agendamento agendamento) {
        this.aprovado = aprovado;
        this.agendamento = agendamento;
    }

    public int getAprovado() {
        return aprovado;
    }

    public void setAprovado(int aprovado) {
        this.aprovado = aprovado;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    
    
}
