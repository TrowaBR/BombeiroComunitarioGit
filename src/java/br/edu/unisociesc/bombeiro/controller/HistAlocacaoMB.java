package br.edu.unisociesc.bombeiro.controller;

import br.edu.unisociesc.bombeiro.model.Agendamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class HistAlocacaoMB implements Serializable {

    private Agendamento agendamento = new Agendamento();
    private List<Agendamento> agendamentoLista = new ArrayList<>();

    public HistAlocacaoMB() {
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    

    public List<Agendamento> getAgendamentoLista() {
        return agendamentoLista;
    }


 
}
