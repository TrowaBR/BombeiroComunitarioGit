package br.edu.unisociesc.dao;

import br.edu.unisociesc.model.AgendamentoRaphael;
import br.edu.unisociesc.model.Usuario;
import java.util.Date;
import java.util.List;


/*Interface é um recurso da orientação a objeto utilizado em Java que define ações que devem ser obrigatoriamente executadas, mas que cada classe pode executar de forma diferente. Interfaces contém valores constantes ou assinaturas de métodos que devem ser implementados dentro de uma classe.*/
public interface CrudAgendamento {

    public void save(AgendamentoRaphael agendamento);

    public AgendamentoRaphael get(long id);
    
    public List<AgendamentoRaphael> list();

    public List<AgendamentoRaphael> listCalendario(Date dataInicio, Usuario usuario);

    public List<AgendamentoRaphael> listSolicitacoes();

    public List<AgendamentoRaphael> listConfirmacoes();

    public void remove(AgendamentoRaphael agendamento);

    public void update(AgendamentoRaphael agendamento);

}
