package br.edu.unisociesc.bombeiro.controller;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class MenuView {

    private MenuModel model;
    
    public void menuCadastros() {
        DefaultSubMenu cadastros = new DefaultSubMenu("Cadastros");
        DefaultMenuItem item;

        item = new DefaultMenuItem("Meu Cadastro");
        item.setOutcome("/interfaces/meuUsuario");
        cadastros.addElement(item);

        item = new DefaultMenuItem("Perfis");
        item.setDisabled(true);
        cadastros.addElement(item);

        item = new DefaultMenuItem("Usuários");
        item.setDisabled(true);
        cadastros.addElement(item);

        item = new DefaultMenuItem("Unidades");
        item.setDisabled(true);
        cadastros.addElement(item);

        item = new DefaultMenuItem("Parâmetros");
        item.setDisabled(true);
        cadastros.addElement(item);

        model.addElement(cadastros);
    }

    public void menuProcessos() {
        DefaultSubMenu processos = new DefaultSubMenu("Processos");
        DefaultMenuItem item;

        item = new DefaultMenuItem("Calendário");
        item.setOutcome("/interfaces/calendario");
        processos.addElement(item);

        DefaultSubMenu agendamentos = new DefaultSubMenu("Agendamentos");

        item = new DefaultMenuItem("Histórico");
        item.setDisabled(true);
        agendamentos.addElement(item);

        item = new DefaultMenuItem("Solicitações");
        item.setDisabled(true);
        agendamentos.addElement(item);

        processos.addElement(agendamentos);

        model.addElement(processos);
    }

    public void menuRelatorios() {
        DefaultSubMenu relatorios = new DefaultSubMenu("Relatórios");
        DefaultMenuItem item;

        item = new DefaultMenuItem("Agendamentos");
        item.setDisabled(true);
        relatorios.addElement(item);

        item = new DefaultMenuItem("Horas de serviço");
        item.setDisabled(true);
        relatorios.addElement(item);

        model.addElement(relatorios);
    }

    public void menuSair() {
        DefaultMenuItem item = new DefaultMenuItem("Sair");
        item.setOutcome("/index");
        model.addElement(item);
    }

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        
        menuCadastros();
        menuProcessos();
        menuRelatorios();
        menuSair();
    }

    public MenuModel getModel() {
        return model;
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}