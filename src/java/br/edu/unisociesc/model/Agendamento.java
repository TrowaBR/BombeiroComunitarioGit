package br.edu.unisociesc.model;

public class Agendamento {

    private String nome;
    private String sobrenome;
    private String nomeGuerra;
 

    public Agendamento(String nome, String sobrenome, String nomeGuerra) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nomeGuerra = nomeGuerra;
    }

    public Agendamento() {
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

}
