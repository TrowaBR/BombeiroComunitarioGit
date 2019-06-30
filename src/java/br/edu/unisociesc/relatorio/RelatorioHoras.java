package br.edu.unisociesc.relatorio;

import br.edu.unisociesc.model.Usuario;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class RelatorioHoras implements Serializable{
    @GeneratedValue
    @Id
    private long id;
    private long horasMes;
    private long horasSemestre;

    @OneToOne
    private Usuario usuario;


    public RelatorioHoras(){
        
    }
    public RelatorioHoras(long id,int horasMes, int horasSemestre, Usuario usuario) {
        this.id = id;
        this.horasMes = horasMes;
        this.horasSemestre = horasSemestre;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    

    public long getHorasMes() {
        return horasMes;
    }

    public void setHorasMes(long horasMes) {
        this.horasMes = horasMes;
    }

    public long getHorasSemestre() {
        return horasSemestre;
    }

    public void setHorasSemestre(long horasSemestre) {
        this.horasSemestre = horasSemestre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}