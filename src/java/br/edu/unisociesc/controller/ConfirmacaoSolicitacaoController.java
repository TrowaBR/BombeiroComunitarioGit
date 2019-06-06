package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.AgendamentoRaphael;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class ConfirmacaoSolicitacaoController {
    private Agendamento agendamento; //puxando da Classe CONFIRMACAOAGENDAMENTO
    private DataModel listaConfirmacaoAgendamento;
    private AgendamentoRaphael AgendamentoRaphael;

    public DataModel getListaAgendamento() {
        List<AgendamentoRaphael> lista = new AgendamentoDAO().list();
        listaConfirmacaoAgendamento = new ListDataModel(lista);
        return listaConfirmacaoAgendamento;
    }
    
    public String alterarConfirmacaoSolicitacao() {
        AgendamentoDAO dao = new AgendamentoDAO();
        dao.update(AgendamentoRaphael);
        return "listarLivrosRefatorado";
    }
    
    
    
    
   
}
