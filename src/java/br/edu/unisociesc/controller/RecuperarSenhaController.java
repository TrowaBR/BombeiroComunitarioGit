package br.edu.unisociesc.controller;  // referencia para o pacote

import br.edu.unisociesc.dao.UsuarioDAO;
import br.edu.unisociesc.dao.RecuperarSenhaDAO;
import br.edu.unisociesc.model.Usuario;
import br.edu.unisociesc.model.RecuperarSenha;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/*@ManagedBean
 * Anotação que reflete o nome que usaremos para chamar essa classe através da nossa View.
 */
@ManagedBean
@SessionScoped
public class RecuperarSenhaController {   // criação da classe

    private RecuperarSenha dados = new RecuperarSenha();
    private DataModel listaUsuarios;

    //DataModel é uma classe que disponibiliza-se com dados de uma tabela… 
    //no jsf por exemplo você constroi um DataModel a partir do banco e disponibiliza ao componente dataTable…
    public DataModel getListarUsuarios() {
        List<Usuario> lista = new UsuarioDAO().list();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;
    }

    public String recuperarSenha() {
        RecuperarSenhaDAO dao = new RecuperarSenhaDAO();
        List<Usuario> lista = dao.list(dados.getRg(), dados.getCpf(), dados.getEmail());
        if (lista.isEmpty()) {
            
        } else {
            return "cadastrarUsuario";
        }
        return null;
    }

    public RecuperarSenha getDados() {
        return dados;
    }

    public void setDados(RecuperarSenha dados) {
        this.dados = dados;
    }

}
