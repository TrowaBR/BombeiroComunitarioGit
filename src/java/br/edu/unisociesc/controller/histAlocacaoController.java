/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.model.Agendamento;
import java.util.List;


/**
 *
 * @author rinal
 */
public class histAlocacaoController {
    
    
     private Agendamento agendamento = new Agendamento();
     private List<Agendamento> agendamentoLista;

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public List<Agendamento> getAgendamentoLista() {
        if (agendamentoLista == null) {
            agendamentoLista = new AgendamentoDAO().list();
        }
        
       
       
        return agendamentoLista;
    }

    public void setAgendamentoLista(List<Agendamento> agendamentoLista) {
        this.agendamentoLista = agendamentoLista;
    }
     
     
     
}
