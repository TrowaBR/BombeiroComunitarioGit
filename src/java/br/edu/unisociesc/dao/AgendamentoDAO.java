package br.edu.unisociesc.dao;

// importação de classes de outros pacotes que vamos utilizar
import br.edu.unisociesc.model.AgendamentoRaphael;
import br.edu.unisociesc.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

// Classe que implementa a interface....Todos os métodos da interface a classe deve possuir
public class AgendamentoDAO implements CrudAgendamento {

    @Override
    public void save(AgendamentoRaphael usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession(); //https://www.devmedia.com.br/entendendo-hibernate-session/29215
        Transaction t = session.beginTransaction(); // transação para acessar a base de dados
        session.save(usuario); // salvando o objeto do tipo usuário na sessão
        t.commit(); // comitando o objeto na base de dados

    }

    @Override
    public AgendamentoRaphael get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (AgendamentoRaphael) session.load(AgendamentoRaphael.class, id);
    }

    @Override
    public List<AgendamentoRaphael> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Agendamento").list();  // estou colocando um select simples pra trazer todos os registros
        t.commit();
        return lista; // vai retornar um objeto do tipo lista de usuário, nessa lista somente tem usuários
    }

    @Override
    public void remove(AgendamentoRaphael usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(usuario);
        t.commit();
    }

    @Override
    public void update(AgendamentoRaphael agendamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(agendamento);
        t.commit();
    }

    @Override
    public List<AgendamentoRaphael> listCalendario(AgendamentoRaphael agendamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AgendamentoRaphael> listSolicitacoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AgendamentoRaphael> listConfirmacoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
