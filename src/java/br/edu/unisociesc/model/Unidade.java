package br.edu.unisociesc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Unidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horasMinimas;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horasMaximas;
    private int leitosMasculinos;
    private int leitosFemininos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaInicioMasculino;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaInicioFeminino;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaTerminoMasculino;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaTerminoFeminino;
    private boolean ativo;
    private String endereco;
    private String pontoReferencia;
    private int cep;
    private String cidade;

    public Unidade(long id, String descricao, Date horasMinimas, Date horasMaximas, int leitosMasculinos, int leitosFemininos, Date horaInicioMasculino, Date horaInicioFeminino, Date horaTerminoMasculino, Date horaTerminoFeminino, boolean ativo, String endereco, String pontoReferencia, int cep, String cidade) {
        this.id = id;
        this.descricao = descricao;
        this.horasMinimas = horasMinimas;
        this.horasMaximas = horasMaximas;
        this.leitosMasculinos = leitosMasculinos;
        this.leitosFemininos = leitosFemininos;
        this.horaInicioMasculino = horaInicioMasculino;
        this.horaInicioFeminino = horaInicioFeminino;
        this.horaTerminoMasculino = horaTerminoMasculino;
        this.horaTerminoFeminino = horaTerminoFeminino;
        this.ativo = ativo;
        this.endereco = endereco;
        this.pontoReferencia = pontoReferencia;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Unidade() {
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getHorasMinimas() {
        return horasMinimas;
    }

    public Date getHorasMaximas() {
        return horasMaximas;
    }

    public int getLeitosMasculinos() {
        return leitosMasculinos;
    }

    public int getLeitosFemininos() {
        return leitosFemininos;
    }

    public Date getHoraInicioMasculino() {
        return horaInicioMasculino;
    }

    public Date getHoraInicioFeminino() {
        return horaInicioFeminino;
    }

    public Date getHoraTerminoMasculino() {
        return horaTerminoMasculino;
    }

    public Date getHoraTerminoFeminino() {
        return horaTerminoFeminino;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public int getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setHorasMinimas(Date horasMinimas) {
        this.horasMinimas = horasMinimas;
    }

    public void setHorasMaximas(Date horasMaximas) {
        this.horasMaximas = horasMaximas;
    }

    public void setLeitosMasculinos(int leitosMasculinos) {
        this.leitosMasculinos = leitosMasculinos;
    }

    public void setLeitosFemininos(int leitosFemininos) {
        this.leitosFemininos = leitosFemininos;
    }

    public void setHoraInicioMasculino(Date horaInicioMasculino) {
        this.horaInicioMasculino = horaInicioMasculino;
    }

    public void setHoraInicioFeminino(Date horaInicioFeminino) {
        this.horaInicioFeminino = horaInicioFeminino;
    }

    public void setHoraTerminoMasculino(Date horaTerminoMasculino) {
        this.horaTerminoMasculino = horaTerminoMasculino;
    }

    public void setHoraTerminoFeminino(Date horaTerminoFeminino) {
        this.horaTerminoFeminino = horaTerminoFeminino;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
