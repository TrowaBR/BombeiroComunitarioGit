package br.edu.unisociesc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Raphael
 */
@Entity
public class Agendamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @JoinColumn(name = "unidade_id", referencedColumnName = "id", /*nullable=false,*/ insertable=false, updatable=false)
    private Unidade unidade;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id", /*nullable=false,*/ insertable=false, updatable=false)
    private Usuario usuario;

    @Enumerated(EnumType.ORDINAL)
    private EstadoAgendamento estado;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entrada;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date saida;

    private long duracao;

    private long calculaDuracao() {
        return TimeUnit.MINUTES.convert(saida.getTime() - entrada.getTime(), TimeUnit.MILLISECONDS);
    }

    public Agendamento(Integer id, Unidade unidade, Usuario usuario, EstadoAgendamento estado, Date entrada, Date saida) {
        this.id = id;
        this.unidade = unidade;
        this.usuario = usuario;
        this.estado = estado;
        this.entrada = entrada;
        this.saida = saida;
        this.duracao = calculaDuracao();
    }
    
    public Agendamento() {
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