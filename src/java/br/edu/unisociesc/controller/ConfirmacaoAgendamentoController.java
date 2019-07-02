package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
public class ConfirmacaoAgendamentoController {
    
    private DataModel listaConfirmacaoAgendamento;
    List<Agendamento> lista;

    private void atualizaLista() {
        lista = new AgendamentoDAO().list(EstadoAgendamento.Aprovado, null, new Date(), null, null);
        listaConfirmacaoAgendamento = new ListDataModel(lista);
    }

    public DataModel getLista() {
        if (listaConfirmacaoAgendamento == null) {
            atualizaLista();
        }
        return listaConfirmacaoAgendamento;
    }
         
    public void presenca(){
        Agendamento agendamento = (Agendamento) listaConfirmacaoAgendamento.getRowData();
        agendamento.setEstado(EstadoAgendamento.Presente);
        new AgendamentoDAO().update(agendamento);
        atualizaLista();
    }
    
    public void ausencia(){
        Agendamento agendamento = (Agendamento) listaConfirmacaoAgendamento.getRowData();
        agendamento.setEstado(EstadoAgendamento.Ausente);
        new AgendamentoDAO().update(agendamento);
        atualizaLista();
    }
    
}
