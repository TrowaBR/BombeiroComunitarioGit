package br.edu.unisociesc.dao;

// importação de classes de outros pacotes que vamos utilizar
import br.edu.unisociesc.model.AgendamentoRaphael;
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
    public void save(AgendamentoRaphael agendamento) {
        Session session = HibernateUtil.getSessionFactory().openSession(); //https://www.devmedia.com.br/entendendo-hibernate-session/29215
        Transaction t = session.beginTransaction(); // transação para acessar a base de dados
        session.save(agendamento); // salvando o objeto do tipo usuário na sessão
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
    public List<AgendamentoRaphael> listCalendario(Date dataInicio, Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Agendamento").list();
        t.commit();
        return lista;
    }

    @Override
    public List<AgendamentoRaphael> listSolicitacoes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = null;//session.createQuery("from Agendamento where status = " + EstadoAgendamento.Solicitado.getId()).list();
        t.commit();
        return lista;
    }

    @Override
    public List<AgendamentoRaphael> listConfirmacoes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = null;//session.createQuery("from Agendamento where status = " + EstadoAgendamento.Aprovado.getId() + " and termino <= " new Date()).list();
        t.commit();
        return lista;
    }
}
