package br.edu.unisociesc.relatorio;

import br.edu.unisociesc.model.Agendamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class RelatorioHistoricoAlocacao implements Serializable {

    private Agendamento agendamento = new Agendamento();
    private List<Agendamento> agendamentoLista = new ArrayList<>();

    public RelatorioHistoricoAlocacao() {
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    

    public List<Agendamento> getAgendamentoLista() {
        return agendamentoLista;
    }


 
}
