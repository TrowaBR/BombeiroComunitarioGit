package br.edu.unisociesc.bombeiro.model;

/**
 *
 * @author Ricardo
 */
public class CadastroPerfil {
    
    private String nome;
    private String status;

    public CadastroPerfil(){
        
    }

    public CadastroPerfil(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}