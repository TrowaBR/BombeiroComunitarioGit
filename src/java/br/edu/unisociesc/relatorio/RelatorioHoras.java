package br.edu.unisociesc.relatorio;

public class RelatorioHoras {
    
    private int horasMes;
    private String nomeGuerra;
    private int horasSemestre;
    private String nome;


    public RelatorioHoras(){
        
    }
    public RelatorioHoras(String nome, String nomeGuerra,int horasMes, int horasSemestre) {
        this.nome = nome;
        this.nomeGuerra = nomeGuerra;
        this.horasMes = horasMes;
        this.horasSemestre = horasSemestre;

    }

    public int getHorasMes() {
        return horasMes;
    }

    public void setHorasMes(int horasMes) {
        this.horasMes = horasMes;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public int getHorasSemestre() {
        return horasSemestre;
    }

    public void setHorasSemestre(int horasSemestre) {
        this.horasSemestre = horasSemestre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}