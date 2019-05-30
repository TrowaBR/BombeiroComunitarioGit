package br.edu.unisociesc.dao;

import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.Usuario;
import java.util.Date;
import java.util.List;


/*Interface é um recurso da orientação a objeto utilizado em Java que define ações que devem ser obrigatoriamente executadas, mas que cada classe pode executar de forma diferente. Interfaces contém valores constantes ou assinaturas de métodos que devem ser implementados dentro de uma classe.*/
public interface CrudAgendamento {

    public void save(Agendamento agendamento);

    public Agendamento get(long id);
    
    public List<Agendamento> list();

    public List<Agendamento> listCalendario(Date dataInicio, Usuario usuario);

    public List<Agendamento> listSolicitacoes();

    public List<Agendamento> listConfirmacoes();

    public void remove(Agendamento agendamento);

    public void update(Agendamento agendamento);

}
