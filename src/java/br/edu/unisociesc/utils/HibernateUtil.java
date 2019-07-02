package br.edu.unisociesc.utils;

import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.Livro;
import br.edu.unisociesc.model.Unidade;
import br.edu.unisociesc.model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    // declare um objeto do tipo SessionFactory
    /* declare como static para que vc possa chamar esse método mesmo sem ter uma instância
     * da classe HibernateUtil, conceito básico de encapsulamento.
     */
    // ops não esqueça de importar do pacote correto: deve ser o pacote org.hibernate
    private static SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    /*vamos criar um método que retorne a nossa sessionFactory aberta
     *esse método tb deve ser static, pois um atributo static só pode ser visto
     * por um método tb static
     */
    public static SessionFactory getSessionFactory() {

        // verificar se nossa session é null, se for passar a configuração e abrir
        if (sessionFactory == null) {
            try {
                // instanciar o objeto para receber a configuração
                AnnotationConfiguration db = new AnnotationConfiguration();
                db.addAnnotatedClass(Livro.class);
                db.addAnnotatedClass(Usuario.class);
                db.addAnnotatedClass(Unidade.class);
                db.addAnnotatedClass(Agendamento.class);
                // vamos pedir para ler a configuração e abrir a sessão
                sessionFactory = db.configure().buildSessionFactory();

            } catch (HibernateException e) {
                /* qualquer excessão que ocorrer será tratada
                 */
                System.out.println("Erro ao criar conexão: " + e.getMessage());
            }
               // se td der certo retorna a sessao aberta
            return sessionFactory;
        } else {
            return sessionFactory;
        }

    }
    
}
