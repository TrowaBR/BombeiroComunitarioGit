package br.edu.unisociesc.model;

public class Parametros {

    private int id;
    private int tempoCancelamento;
    private int tempoReagendamento;
    private int mesesPeriodo;
    private int minHorasPeriodo;

    public Parametros() {
    }

    public Parametros(int id, int tempoCancelamento, int tempoReagendamento, int mesesPeriodo, int minHorasPeriodo) {
        this.id = id;
        this.tempoCancelamento = tempoCancelamento;
        this.tempoReagendamento = tempoReagendamento;
        this.mesesPeriodo = mesesPeriodo;
        this.minHorasPeriodo = minHorasPeriodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempoCancelamento() {
        return tempoCancelamento;
    }

    public void setTempoCancelamento(int tempoCancelamento) {
        this.tempoCancelamento = tempoCancelamento;
    }

    public int getTempoReagendamento() {
        return tempoReagendamento;
    }

    public void setTempoReagendamento(int tempoReagendamento) {
        this.tempoReagendamento = tempoReagendamento;
    }

    public int getMesesPeriodo() {
        return mesesPeriodo;
    }

    public void setMesesPeriodo(int mesesPeriodo) {
        this.mesesPeriodo = mesesPeriodo;
    }

    public int getMinHorasPeriodo() {
        return minHorasPeriodo;
    }

    public void setMinHorasPeriodo(int minHorasPeriodo) {
        this.minHorasPeriodo = minHorasPeriodo;
    }
}
