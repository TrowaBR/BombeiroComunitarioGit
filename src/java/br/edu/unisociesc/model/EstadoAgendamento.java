package br.edu.unisociesc.model;

/**
 *
 * @author Raphael
 */
public enum EstadoAgendamento {
    Solicitado(0),
    Reprovado(1),
    Aprovado(2),
    Presente(3),
    Ausente(4);
    
    private int id;

    private EstadoAgendamento(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}