package br.edu.unisociesc.controller;  // referencia para o pacote

import br.edu.unisociesc.dao.UsuarioDAO;
import br.edu.unisociesc.model.Usuario;
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
public class UsuarioController {   // criação da classe

    private Usuario usuario;
    private DataModel listaUsuarios;

    //DataModel é uma classe que disponibiliza-se com dados de uma tabela… 
    //no jsf por exemplo você constroi um DataModel a partir do banco e disponibiliza ao componente dataTable…
    public DataModel getListarUsuarios() {
        List<Usuario> lista = new UsuarioDAO().list();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String prepararAlterarUsuario() {
        usuario = (Usuario) (listaUsuarios.getRowData());
        return "cadastrarUsuario";
    }

    public String excluirUsuario() {
        Usuario usuario = (Usuario) (listaUsuarios.getRowData());
        UsuarioDAO dao = new UsuarioDAO();
        dao.remove(usuario);
        return "listarUsuarios";
    }

    public String adicionarUsuario() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.save(usuario);
        return "listarUsuarios";
    }

    public String alterarUsuario() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.update(usuario);
        return "listarUsuarios";
    }

    public void prepararAdicionarUsuario() {
        usuario = new Usuario();

    }
}