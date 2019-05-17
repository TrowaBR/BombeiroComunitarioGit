package br.edu.unisociesc.bombeiro.model;

import br.edu.unisociesc.bombeiro.utils.EstadoAgendamento;
import java.util.Date;

public class Agendamento {

    private Integer id;
    private Unidade unidade;
    private Usuario usuario;
    private EstadoAgendamento estado;
    private Date entrada;
    private Date saida;
    private Date duracao;

    public Agendamento(Integer id, Unidade unidade, Usuario usuario, EstadoAgendamento estado, Date entrada, Date saida, Date duracao) {
        this.id = id;
        this.unidade = unidade;
        this.usuario = usuario;
        this.estado = estado;
        this.entrada = entrada;
        this.saida = saida;
        this.duracao = duracao;
    }

    public Agendamento() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoAgendamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAgendamento estado) {
        this.estado = estado;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }
}