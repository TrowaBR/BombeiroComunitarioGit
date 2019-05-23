package br.edu.unisociesc.model;

import java.util.Date;

public class RegistroEstado {
    
    private Integer id;
    private Usuario usuario;
    private AgendamentoRaphael agendamento;
    private EstadoAgendamento estado;
    private Date dataEntrada;
    private String informacoes;

    public RegistroEstado(Integer id, Usuario usuario, AgendamentoRaphael agendamento, EstadoAgendamento estado, Date dataEntrada, String informacoes) {
        this.id = id;
        this.usuario = usuario;
        this.agendamento = agendamento;
        this.estado = estado;
        this.dataEntrada = dataEntrada;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AgendamentoRaphael getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(AgendamentoRaphael agendamento) {
        this.agendamento = agendamento;
    }

    public EstadoAgendamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAgendamento estado) {
        this.estado = estado;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
}