package br.edu.unisociesc.dao;

 

import br.edu.unisociesc.model.Livro;
import java.util.List;
 
public interface CrudLivro {
 
public void save(Livro livro);
public Livro getLivro(long id);
public List<Livro> list();
public void remove(Livro livro);
public void update(Livro livro);
 
}
