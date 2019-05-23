package br.edu.unisociesc.model;

public class ConfirmacaoSolicitacao {
    
    private int aprovado;
    private AgendamentoRaphael agendamento;

    public ConfirmacaoSolicitacao(int aprovado, AgendamentoRaphael agendamento) {
        this.aprovado = aprovado;
        this.agendamento = agendamento;
    }

    public ConfirmacaoSolicitacao() {
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
