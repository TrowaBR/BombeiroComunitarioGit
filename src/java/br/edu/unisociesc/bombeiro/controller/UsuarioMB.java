package br.edu.unisociesc.bombeiro.controller;

import br.edu.unisociesc.bombeiro.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable {

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarioLista = new ArrayList<>();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioLista() {
        return usuarioLista;
    }

    public void setUsuarioLista(List<Usuario> usuarioLista) {
        this.usuarioLista = usuarioLista;
    }

    public void salvarUsuario() {
        usuarioLista.add(usuario);
        usuario = new Usuario();
    }
}
