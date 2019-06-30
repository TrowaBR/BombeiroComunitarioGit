/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unisociesc.controller;

import br.edu.unisociesc.dao.AgendamentoDAO;
import br.edu.unisociesc.model.Agendamento;
import br.edu.unisociesc.model.EstadoAgendamento;
import br.edu.unisociesc.relatorio.RelatorioHoras;
import br.edu.unisociesc.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


 @ManagedBean
public class RelatorioHorasController implements Serializable{

    private Agendamento agendamento = new Agendamento();
    private List<RelatorioHoras> agendamentoLista;
    
    private RelatorioHoras getItemPorUsuario(Usuario usuario) {
        for (RelatorioHoras item : agendamentoLista) {
            if (item.getUsuario().getId() == usuario.getId()) {
                return item;
            }
        }
        
        RelatorioHoras retorno = new RelatorioHoras(usuario.getId(), 0, 0, usuario);
        agendamentoLista.add(retorno);
        
        return retorno;
    }

    public List<RelatorioHoras> list() {
        AgendamentoDAO dao = new AgendamentoDAO();
        RelatorioHoras resultado;
        
        agendamentoLista = new ArrayList<>();
        List<Agendamento> agendamentos = dao.list(EstadoAgendamento.Presente);
        Calendar ini = GregorianCalendar.getInstance();
        ini.setTime(new Date());
        ini.set(Calendar.HOUR_OF_DAY, 0);
        ini.set(Calendar.MINUTE, 0);
        ini.set(Calendar.SECOND, 0);
        ini.set(Calendar.MILLISECOND, 0);
        ini.set(Calendar.DAY_OF_MONTH, 1);

        Calendar fim = GregorianCalendar.getInstance();
        fim.setTime(new Date());
        fim.set(Calendar.HOUR_OF_DAY, 0);
        fim.set(Calendar.MINUTE, 0);
        fim.set(Calendar.SECOND, 0);
        fim.set(Calendar.MILLISECOND, 0);
        fim.set(Calendar.DAY_OF_MONTH, 30);

        for (Agendamento agendamento : agendamentos) {
            resultado = getItemPorUsuario(agendamento.getUsuario());

            if (agendamento.getSaida().compareTo(ini.getTime()) >= 0 &&
                    agendamento.getEntrada().compareTo(fim.getTime()) <= 0) {
                resultado.setHorasMes(resultado.getHorasMes() + agendamento.getDuracao());
            }

            resultado.setHorasSemestre(resultado.getHorasSemestre() + agendamento.getDuracao());
            //agendamento.getUsuario().getId()
        }
        return agendamentoLista;
    }

//    public List<RelatorioHoras> getAgendamentoLista() {
//        AgendamentoDAO dao = new AgendamentoDAO();
//        System.out.println("teste");
//        RelatorioHoras resultado;
//        
//        agendamentoLista = new ArrayList<>();
//        List<Agendamento> agendamentos = dao.list(EstadoAgendamento.Aprovado);
//        
//        for (Agendamento agendamento : agendamentos) {
//            resultado = getItemPorUsuario(agendamento.getUsuario());
//           
//            //agendamento.getUsuario().getId()
//        }
//        return agendamentoLista;
//    }

    public void setAgendamentoLista(List<RelatorioHoras> agendamentoLista) {
        this.agendamentoLista = agendamentoLista;
    }
     
    
}


