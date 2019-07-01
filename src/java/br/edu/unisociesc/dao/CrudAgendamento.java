package br.edu.unisociesc.dao;

import br.edu.unisociesc.model.FiltroAgendamento;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
import java.util.Date;
import java.util.List;


/*Interface é um recurso da orientação a objeto utilizado em Java que define ações que devem ser obrigatoriamente executadas, mas que cada classe pode executar de forma diferente. Interfaces contém valores constantes ou assinaturas de métodos que devem ser implementados dentro de uma classe.*/
public interface CrudAgendamento {
    
    public void save(Agendamento agendamento);

    public Agendamento get(long id);
    
    public List<Agendamento> list();

    public List<Agendamento> list(EstadoAgendamento estado);

    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio);

    public List<Agendamento> listTermino(EstadoAgendamento estado, Date dataTermino);

    public List<Agendamento> listPeriodo(EstadoAgendamento estado, Date dataInicio, Unidade unidade);

    public List<Agendamento> listMes(EstadoAgendamento estado, Date dataInicio);

    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio, Date dataTermino, Usuario usuario);

    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio, Date dataTermino, Usuario usuario, Unidade unidade, FiltroAgendamento filtro);

    public void remove(Agendamento agendamento);

    public void update(Agendamento agendamento);

}
