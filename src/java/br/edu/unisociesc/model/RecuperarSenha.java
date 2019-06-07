package br.edu.unisociesc.model;


public class RecuperarSenha {

    private int rg;
    private int cpf;
    private String email;

    public RecuperarSenha() {
    }

    public int getRg() {
        return rg;
    }

    public int getCpf() {
        return cpf;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setRg(int rg) {
        this.rg = rg;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RecuperarSenha(int rg, int cpf, String email) {
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
    }
}