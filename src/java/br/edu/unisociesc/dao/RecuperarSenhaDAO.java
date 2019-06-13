package br.edu.unisociesc.dao;

// importação de classes de outros pacotes que vamos utilizar
import br.edu.unisociesc.model.Usuario;
import br.edu.unisociesc.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

// Classe que implementa a interface....Todos os métodos da interface a classe deve possuir
public class RecuperarSenhaDAO implements CrudRecuperarSenha {

    public Usuario getUsuario(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Usuario) session.load(Usuario.class, id);
    }

    public List<Usuario> list(String rg, String cpf, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Usuario where (rg = '" + rg + "') and (cpf = '" + cpf + "') and (email = '" + email + "')").list();  // estou colocando um select simples pra trazer todos os registros
        t.commit();
        return lista; // vai retornar um objeto do tipo lista de usuário, nessa lista somente tem usuários
    }

    public void update(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(usuario);
        t.commit();
    }
}
