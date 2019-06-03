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
        return list(null);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado) {
        return list(estado, null);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio) {
        return list(estado, dataInicio, null);
    }

    @Override
    public List<Agendamento> list(EstadoAgendamento estado, Date dataInicio, Usuario usuario) {
        String sql = "from Agendamento";
        String aux = " where ";
        
        if (estado != null) {
            sql += aux + "(usuario = " + estado.ordinal() + ")";
            aux = " and ";
        }

        if (dataInicio != null) {
            sql += aux + "(usuario = " + dataInicio.toString() + ")";
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

    @Override
    public List<Agendamento> listCalendario(Date dataInicio, Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Agendamento").list();
        t.commit();
        return lista;
    }

    @Override
    public List<Agendamento> listSolicitacoes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = null;//session.createQuery("from Agendamento where status = " + EstadoAgendamento.Solicitado.getId()).list();
        t.commit();
        return lista;
    }

    @Override
    public List<Agendamento> listConfirmacoes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = null;//session.createQuery("from Agendamento where status = " + EstadoAgendamento.Aprovado.getId() + " and termino <= " new Date()).list();
        t.commit();
        return lista;
    }
    
    
    public List<Agendamento> listAprovado() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Agendamento").list();  // Incluir where para buscar apenas agendamentos 'PRESENTES'
        t.commit();
        return lista; // vai retornar um objeto do tipo lista de usuário, nessa lista somente tem usuários
    }
    

    
}
