package br.edu.unisociesc.dao;

import br.edu.unisociesc.model.Unidade;
import java.util.List;


/*Interface é um recurso da orientação a objeto utilizado em Java que define ações que devem ser obrigatoriamente executadas, mas que cada classe pode executar de forma diferente. Interfaces contém valores constantes ou assinaturas de métodos que devem ser implementados dentro de uma classe.*/
public interface CrudUnidade {

    public void save(Unidade unidade);

    public Unidade getUnidade(long id);

    public List<Unidade> list();

    public void remove(Unidade livro);

    public void update(Unidade livro);

}
