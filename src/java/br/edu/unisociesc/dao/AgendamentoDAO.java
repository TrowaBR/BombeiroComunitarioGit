package br.edu.unisociesc.dao;

import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
import br.edu.unisociesc.utils.DateUtil;
import br.edu.unisociesc.utils.HibernateUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AgendamentoDAO implements CrudAgendamento {
    
    public static final double HORAS_PERIODO = 120;
    public static final int NUM_PERIODOS = 6;

    @Override
    public void save(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(agendamento);
        t.commit();
    }

    @Override
    public Agendamento get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Agendamento) session.load(Agendamento.class, id);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio, Date dataTermino, Usuario usuario, Unidade unidade) {
        String sql = "from Agendamento";
        String aux = " where ";
        
        if (estado != null) {
            sql += aux + "(estado = " + estado.ordinal() + ")";
            aux = " and ";
        }

        if (dataInicio != null) {
            sql += aux + "(saida >= " + DateUtil.datePostgre(dataInicio) + ")";
            aux = " and ";
        }
        
        if (dataTermino != null) {
            sql += aux + "(entrada <= " + DateUtil.datePostgre(dataTermino) + ")";
            aux = " and ";
        }

        if (unidade != null) {
            sql += aux + "(unidade_id = " + unidade.getId() + ")";
        }

        if (usuario != null) {
            sql += aux + "(usuario_id = " + usuario.getId() + ")";
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery(sql).list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Agendamento usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(usuario);
        t.commit();
    }

    @Override
    public void update(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(agendamento);
        t.commit();
    }

}
