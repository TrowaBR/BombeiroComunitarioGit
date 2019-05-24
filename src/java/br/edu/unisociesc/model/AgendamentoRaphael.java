package br.edu.unisociesc.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Raphael
 */
public class AgendamentoRaphael {

    private long id;
    private Unidade unidade;
    private Usuario usuario;
    private EstadoAgendamento estado;
    private Date entrada;
    private Date saida;
    private long duracao;

    private long calculaDuracao() {
        return TimeUnit.MINUTES.convert(saida.getTime() - entrada.getTime(), TimeUnit.MILLISECONDS);
    }

    public AgendamentoRaphael(Integer id, Unidade unidade, Usuario usuario, EstadoAgendamento estado, Date entrada, Date saida) {
        this.id = id;
        this.unidade = unidade;
        this.usuario = usuario;
        this.estado = estado;
        this.entrada = entrada;
        this.saida = saida;
        this.duracao = calculaDuracao();
    }
    
    public AgendamentoRaphael() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        this.duracao = calculaDuracao();
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida   = saida;
        this.duracao = calculaDuracao();
    }

    public long getDuracao() {
        return duracao;
    }
}