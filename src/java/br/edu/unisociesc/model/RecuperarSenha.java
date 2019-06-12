package br.edu.unisociesc.model;


public class RecuperarSenha {

    private String rg;
    private String cpf;
    private String email;

    public RecuperarSenha() {
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RecuperarSenha(String rg, String cpf, String email) {
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
    }
}