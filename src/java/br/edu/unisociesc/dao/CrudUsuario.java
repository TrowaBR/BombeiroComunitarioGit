package br.edu.unisociesc.dao;

import br.edu.unisociesc.model.Usuario;
import java.util.List;


/*Interface é um recurso da orientação a objeto utilizado em Java que define ações que devem ser obrigatoriamente executadas, mas que cada classe pode executar de forma diferente. Interfaces contém valores constantes ou assinaturas de métodos que devem ser implementados dentro de uma classe.*/
public interface CrudUsuario {

    public void save(Usuario usuario);

    public Usuario getUsuario(long id);

    public List<Usuario> list();

    public void remove(Usuario livro);

    public void update(Usuario livro);

}
