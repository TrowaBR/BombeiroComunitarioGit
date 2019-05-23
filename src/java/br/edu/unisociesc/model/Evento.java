package br.edu.unisociesc.model;

import java.util.ArrayList;

public class Evento {

    String DescEvento;
    String DataEvento;
    ArrayList<String> bombeiros = new ArrayList<>();

    public String getDescEvento() {
        return DescEvento;
    }

    public void setDescEvento(String DescEvento) {
        this.DescEvento = DescEvento;
    }

    public String getDataEvento() {
        return DataEvento;
    }

    public void setDataEvento(String DataEvento) {
        this.DataEvento = DataEvento;
    }

    public ArrayList<String> getBombeiros() {
        return bombeiros;
    }

    public void setBombeiros(ArrayList<String> bombeiros) {
        this.bombeiros = bombeiros;
    }

    public Evento(String DescEvento, String DataEvento) {
        this.DescEvento = DescEvento;
        this.DataEvento = DataEvento;
    }
}
