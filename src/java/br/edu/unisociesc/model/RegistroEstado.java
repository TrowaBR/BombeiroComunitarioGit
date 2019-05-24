package br.edu.unisociesc.model;

import java.util.Date;

public class RegistroEstado {
    
    private Integer id;
    private AgendamentoRaphael agendamento;
    private Usuario usuarioRegistro;
    private Date dataRegistro;
    private EstadoAgendamento estado;
    private String informacoes;

    public RegistroEstado(Integer id, AgendamentoRaphael agendamento, Usuario usuarioRegistro, Date dataRegistro, EstadoAgendamento estado, String informacoes) {
        this.id = id;
        this.agendamento = agendamento;
        this.usuarioRegistro = usuarioRegistro;
        this.dataRegistro = dataRegistro;
        this.estado = estado;
        this.informacoes = informacoes;
    }

    public RegistroEstado() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AgendamentoRaphael getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(AgendamentoRaphael agendamento) {
        this.agendamento = agendamento;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public EstadoAgendamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAgendamento estado) {
        this.estado = estado;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
}