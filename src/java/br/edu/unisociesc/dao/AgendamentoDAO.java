package br.edu.unisociesc.dao;

// importação de classes de outros pacotes que vamos utilizar
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.model.Usuario;
import br.edu.unisociesc.utils.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

// Classe que implementa a interface....Todos os métodos da interface a classe deve possuir
public class AgendamentoDAO implements CrudAgendamento {

    @Override
    public void save(Agendamento agendamento) {
        Session session = HibernateUtil.getSessionFactory().openSession(); //https://www.devmedia.com.br/entendendo-hibernate-session/29215
        Transaction t = session.beginTransaction(); // transação para acessar a base de dados
        session.save(agendamento); // salvando o objeto do tipo usuário na sessão
        t.commit(); // comitando o objeto na base de dados

    }

    @Override
    public Agendamento get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Agendamento) session.load(Agendamento.class, id);
    }

    @Override
    public List<Agendamento> list() {
        return list(null, null, null, null);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado) {
        return list(estado, null, null, null);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio) {
        return list(estado, dataInicio, null, null);
    }
    
    @Override
    public List<Agendamento> listTermino(EstadoAgendamento estado, Date dataTermino) {
        return list(estado, null, dataTermino, null);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio, Date dataTermino, Usuario usuario) {
        String sql = "from Agendamento";
        String aux = " where ";
        
        if (estado != null) {
            sql += aux + "(estado = " + estado.ordinal() + ")";
            aux = " and ";
        }

        if (dataInicio != null) {
            sql += aux + "(inicio >= '" + HibernateUtil.datePostgre(dataInicio) + "')";
            aux = " and ";
        }
        
        if (dataTermino != null) {
            sql += aux + "(termino <= '" + HibernateUtil.datePostgre(dataTermino) + "')";
            aux = " and ";
        }

        if (usuario != null) {
            sql += aux + "(usuario = " + usuario.getId() + ")";
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
