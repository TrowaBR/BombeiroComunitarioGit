package br.edu.unisociesc.dao;

// importação de classes de outros pacotes que vamos utilizar
import br.edu.unisociesc.model.Usuario;
import br.edu.unisociesc.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

// Classe que implementa a interface....Todos os métodos da interface a classe deve possuir
public class UsuarioDAO implements CrudUsuario {

    @Override
    public void save(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession(); //https://www.devmedia.com.br/entendendo-hibernate-session/29215
        Transaction t = session.beginTransaction(); // transação para acessar a base de dados
        session.save(usuario); // salvando o objeto do tipo usuário na sessão
        t.commit(); // comitando o objeto na base de dados

    }

    @Override
    public Usuario getUsuario(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Usuario) session.load(Usuario.class, id);
    }

    @Override
    public List<Usuario> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Usuario").list();  // estou colocando um select simples pra trazer todos os registros
        t.commit();
        return lista; // vai retornar um objeto do tipo lista de usuário, nessa lista somente tem usuários
    }

    @Override
    public void remove(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(usuario);
        t.commit();
    }

    @Override
    public void update(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(usuario);
        t.commit();
    }
}
