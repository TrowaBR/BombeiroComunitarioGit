package br.edu.unisociesc.bombeiro.model;

import java.util.ArrayList;

/**
 *
 * @author bnutec
 */
public class Evento {

    String DescEvento;
    String DataEvento;
    ArrayList<Usuario> bombeiros = new ArrayList<>();

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

    public ArrayList<Usuario> getBombeiros() {
        return bombeiros;
    }

    public void setBombeiros(ArrayList<Usuario> bombeiros) {
        this.bombeiros = bombeiros;
    }

    public Evento(String DescEvento, String DataEvento) {
        this.DescEvento = DescEvento;
        this.DataEvento = DataEvento;
    }
}