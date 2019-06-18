package br.edu.unisociesc.dao;

import br.edu.unisociesc.model.Usuario;
import java.util.List;


/*Interface é um recurso da orientação a objeto utilizado em Java que define ações que devem ser obrigatoriamente executadas, mas que cada classe pode executar de forma diferente. Interfaces contém valores constantes ou assinaturas de métodos que devem ser implementados dentro de uma classe.*/
public interface CrudRecuperarSenha {

    public Usuario getUsuario(long id);

    public List<Usuario> list(String rg, String cpf, String email);

    public void update(Usuario usuario);

}
