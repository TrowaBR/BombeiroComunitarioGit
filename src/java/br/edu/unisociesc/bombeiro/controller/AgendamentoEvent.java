/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unisociesc.bombeiro.controller;

import java.util.Date;
import org.primefaces.model.DefaultScheduleEvent;

public class AgendamentoEvent extends DefaultScheduleEvent {

    private String usuario;
    private String pelotao;
    private Date inicio;
    private Date termino;

    public AgendamentoEvent(String title, Date start, Date end) {
        super(title, start, end);
    }

    public AgendamentoEvent() {
        this("", null, null);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPelotao() {
        return pelotao;
    }

    public void setPelotao(String pelotao) {
        this.pelotao = pelotao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
}
