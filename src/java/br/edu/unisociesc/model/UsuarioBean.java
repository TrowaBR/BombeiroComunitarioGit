package br.edu.unisociesc.model;

import br.edu.unisociesc.relatorio.RelatorioHoras;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name="usuarioBean")
public class UsuarioBean{
    
    private List<RelatorioHoras> relatorio;
    
    public UsuarioBean(){
        relatorio = new ArrayList<RelatorioHoras>();
        relatorio.add(new RelatorioHoras("Joao", "BC joao", 10, 110));
        relatorio.add(new RelatorioHoras("Lucas", "BC lucas", 11, 100));
        relatorio.add(new RelatorioHoras("Marcos", "BC marcos", 12, 120));
        relatorio.add(new RelatorioHoras("Pedro", "BC pedro", 13, 190));
        relatorio.add(new RelatorioHoras("Luan", "BC luan", 14, 180));
        relatorio.add(new RelatorioHoras("Andre", "BC andre", 15, 170));
        relatorio.add(new RelatorioHoras("Ricardo", "BC ricardo", 16, 160));
        relatorio.add(new RelatorioHoras("Mario", "BC mario", 17, 150));
        relatorio.add(new RelatorioHoras("Rafael", "BC rafael", 18, 140));
        relatorio.add(new RelatorioHoras("Paulo", "BC paulo", 19, 130));
        relatorio.add(new RelatorioHoras("Joao", "BC joao", 10, 110));
        relatorio.add(new RelatorioHoras("Lucas", "BC lucas", 11, 100));
        relatorio.add(new RelatorioHoras("Marcos", "BC marcos", 12, 120));
        relatorio.add(new RelatorioHoras("Pedro", "BC pedro", 13, 190));
        relatorio.add(new RelatorioHoras("Luan", "BC luan", 14, 180));
        relatorio.add(new RelatorioHoras("Andre", "BC andre", 15, 170));
        relatorio.add(new RelatorioHoras("Ricardo", "BC ricardo", 16, 160));
        relatorio.add(new RelatorioHoras("Mario", "BC mario", 17, 150));
        relatorio.add(new RelatorioHoras("Rafael", "BC rafael", 18, 140));
        relatorio.add(new RelatorioHoras("Paulo", "BC paulo", 19, 130));
        relatorio.add(new RelatorioHoras("Joao", "BC joao", 10, 110));
        relatorio.add(new RelatorioHoras("Lucas", "BC lucas", 11, 100));
        relatorio.add(new RelatorioHoras("Marcos", "BC marcos", 12, 120));
        relatorio.add(new RelatorioHoras("Pedro", "BC pedro", 13, 190));
        relatorio.add(new RelatorioHoras("Luan", "BC luan", 14, 180));
        relatorio.add(new RelatorioHoras("Andre", "BC andre", 15, 170));
        relatorio.add(new RelatorioHoras("Ricardo", "BC ricardo", 16, 160));
        relatorio.add(new RelatorioHoras("Mario", "BC mario", 17, 150));
        relatorio.add(new RelatorioHoras("Rafael", "BC rafael", 18, 140));
        relatorio.add(new RelatorioHoras("Paulo", "BC paulo", 19, 130));
    }
    
    public List<RelatorioHoras> getRelatorioHoras(){
        return relatorio;
    }
    public void setCar(List<RelatorioHoras> relatorio){
        this.relatorio = relatorio;
    }     
}
