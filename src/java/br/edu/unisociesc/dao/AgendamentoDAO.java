package br.edu.unisociesc.dao;

import br.edu.unisociesc.model.FiltroAgendamento;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
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
    public List<Agendamento> list() {
        return list(null, null, null, null, null, null);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado) {
        return list(estado, null, null, null, null, null);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio) {
        return list(estado, dataInicio, null, null, null, null);
    }
    
    @Override
    public List<Agendamento> listTermino(EstadoAgendamento estado, Date dataTermino) {
        return list(estado, null, dataTermino, null, null, null);
    }

    @Override
    public List<Agendamento> listPeriodo(EstadoAgendamento estado, Date dataInicio, Unidade unidade) {
        return list(estado, null, dataInicio, null, unidade, FiltroAgendamento.Periodo);
    }
    
    @Override
    public List<Agendamento> listMes(EstadoAgendamento estado, Date dataInicio) {
        return list(estado, null, dataInicio, null, null, FiltroAgendamento.Mes);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio, Date dataTermino, Usuario usuario) {
        return list(estado, dataInicio, dataTermino, usuario, null, null);
    }
    
    private int peiodo(Calendar calendar) {
        return (calendar.get(Calendar.MONTH)-1) / NUM_PERIODOS;
    }
    
    private Date inicioDia(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    private Date terminoDia(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.HOUR_OF_DAY, c.getActualMaximum(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c.getActualMaximum(Calendar.MINUTE));
        c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, c.getActualMaximum(Calendar.MILLISECOND));
        return c.getTime();
    }

    private Date inicioMes(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    private Date terminoMes(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    private Date inicioPeriodo(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.MONTH, (peiodo(c) * NUM_PERIODOS) + 1);
        return c.getTime();
    }

    private Date terminoPeriodo(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.MONTH, (peiodo(c) * NUM_PERIODOS) + NUM_PERIODOS);
        return c.getTime();
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio, Date dataTermino, Usuario usuario, Unidade unidade, FiltroAgendamento filtro) {
        String sql = "from Agendamento";
        String aux = " where ";
        Date data;
        
        if (estado != null) {
            sql += aux + "(estado = " + estado.ordinal() + ")";
            aux = " and ";
        }

        if (dataInicio != null) {
            if (filtro == null) {
                data = inicioDia(dataInicio);
            } else {
                switch (filtro) {
                    case Periodo: data = inicioPeriodo(dataInicio); break;
                    case Mes: data = inicioMes(dataInicio); break;
                    default: data = inicioDia(dataInicio);
                }
            }
            sql += aux + "(saida >= " + HibernateUtil.datePostgre(data) + ")";
            aux = " and ";
        }
        
        if (dataTermino != null) {
            if (filtro == null) {
                data = inicioDia(dataTermino);
            } else {
                switch (filtro) {
                    case Periodo: data = terminoPeriodo(dataTermino); break;
                    case Mes: data = terminoMes(dataTermino); break;
                    default: data = terminoDia(dataTermino);
                }
            }
            sql += aux + "(entrada <= " + HibernateUtil.datePostgre(data) + ")";
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
