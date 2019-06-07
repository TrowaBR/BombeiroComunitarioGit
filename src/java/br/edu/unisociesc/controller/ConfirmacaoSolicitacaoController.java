package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class ConfirmacaoSolicitacaoController {

    private DataModel listaSolicitacaoAgendamento;
    List<Agendamento> lista;

    private void atualizaLista() {
        lista = new AgendamentoDAO().list(EstadoAgendamento.Solicitado);
        listaSolicitacaoAgendamento = new ListDataModel(lista);
    }

    public DataModel getLista() {
        if (listaSolicitacaoAgendamento == null) {
            atualizaLista();
        }
        return listaSolicitacaoAgendamento;
    }
         
    public void aprovar(){
        Agendamento agendamento = (Agendamento) listaSolicitacaoAgendamento.getRowData();
        agendamento.setEstado(EstadoAgendamento.Aprovado);
        new AgendamentoDAO().update(agendamento);
        atualizaLista();
    }
    
    public void reprovar(){
        Agendamento agendamento = (Agendamento) listaSolicitacaoAgendamento.getRowData();
        agendamento.setEstado(EstadoAgendamento.Reprovado);
        new AgendamentoDAO().update(agendamento);
        atualizaLista();
    }
   
}
