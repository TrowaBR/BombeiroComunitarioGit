package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.LivroDAO;
import br.edu.unisociesc.model.Livro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class LivroController {

    private Livro livro;
    private DataModel listaLivros;

    public DataModel getListarLivros() {
        List<Livro> lista = new LivroDAO().list();
        listaLivros = new ListDataModel(lista);
        return listaLivros;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String prepararAdicionarLivro() {
        livro = new Livro();
        return "cadastrarLivro";
    }

    public String prepararAlterarLivro() {
        livro = (Livro) (listaLivros.getRowData());
        return "cadastrarLivro";
    }

    public String excluirLivro() {
        Livro livro = (Livro) (listaLivros.getRowData());
        LivroDAO dao = new LivroDAO();
        dao.remove(livro);
        return "listarLivros";
    }

    public String excluirLivroRefatorado() {
        Livro livroTempRef = (Livro) (listaLivros.getRowData());
        LivroDAO dao = new LivroDAO();
        dao.remove(livroTempRef);
        return "listarLivrosRefatorado";
    }

    public String adicionarLivro() {
        LivroDAO dao = new LivroDAO();
        dao.save(livro);
        return "listarLivrosRefatorado";
    }

    public String alterarLivro() {
        LivroDAO dao = new LivroDAO();
        dao.update(livro);
        return "listarLivrosRefatorado";
    }

    public String alterarLivroRefatorado() {
        LivroDAO dao = new LivroDAO();
        dao.update(livro);
        return "listarLivrosRefatorado";
    }

    public void prepararAdicionarLivro2() {
        livro = new Livro();

    }
}
