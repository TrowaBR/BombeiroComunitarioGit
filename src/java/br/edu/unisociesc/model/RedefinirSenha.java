package br.edu.unisociesc.model;

public class RedefinirSenha {

    private String senha;
    private String confirmarSenha;

    public RedefinirSenha(String senha, String confirmarSenha) {
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;

    }

    public RedefinirSenha() {
    }

    public String getsenha() {
        return senha;
    }

    public String getconfirmarSenha() {
        return confirmarSenha;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }

    public void setconfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

}
