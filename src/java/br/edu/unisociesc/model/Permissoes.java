package br.edu.unisociesc.model;



public class Permissoes {
    
    private Perfil perfil;
    private boolean cadastrosConsultarmeuCadastro;
    private boolean perfilsConsultar;
    private boolean perfisEditar;
    private boolean perfisCadastrar;
    private boolean usuariosDefinirPermissoes;
    private boolean usuariosInativarUsuarios;
    private boolean usuariosConsultarUsuarios;
    private boolean usuariosEditarUsuarios;
    private boolean usuariosCadastrarUsuarios;
    private boolean unidadesConsultarUnidade;
    private boolean unidadesEditarUnidade;
    private boolean unidadesCadastrarUnidade;
    private boolean parametrosConsultarParametros;
    private boolean parametrosEditarParametros;
    private boolean parametrosCadastrarParametros;
    private boolean eventosConsultarEventos;
    private boolean eventosEditarEventos;
    private boolean eventosCadastrarEventos;
    private boolean repositorioExcluirDocumento;
    private boolean repositorioEditarDocumento;
    private boolean repositorioConsultarDocumento;
    private boolean repositorioIncluirDocumento;
    private boolean calendariodeAgendamentosConsultarAgendamentos;
    private boolean calendarioAgendamentosSolicitarAgendamentos;
    private boolean historicoAgendamentosConsultar;
    private boolean confirmacaoAgendamentosRegistrarAusencia;
    private boolean confirmacaoAgendamentosRegistrarPresenca;
    private boolean confirmacaoAgendamentosListarAgendamentosparaConfirmação;
    private boolean autorizacaoAgendamentosAprovarSolicitacao;
    private boolean autorizacaoAgendamentosRecusarSolicitacao;
    private boolean autorizacaoAgendamentosListarSolicitacao;
    private boolean relatoriosHistoricoAlocacao;
    private boolean relatoriosHorasServico;
    private boolean agendaConsultarDetalhes;
    private boolean agendaConsultarDisponibilidade;
    private boolean agendaConsultarAgenda;

    public Permissoes() {
    }

    public Permissoes(Perfil perfil, boolean cadastrosConsultarmeuCadastro, boolean perfilsConsultar, boolean perfisEditar, boolean perfisCadastrar, boolean usuariosDefinirPermissoes, boolean usuariosInativarUsuarios, boolean usuariosConsultarUsuarios, boolean usuariosEditarUsuarios, boolean usuariosCadastrarUsuarios, boolean unidadesConsultarUnidade, boolean unidadesEditarUnidade, boolean unidadesCadastrarUnidade, boolean parametrosConsultarParametros, boolean parametrosEditarParametros, boolean parametrosCadastrarParametros, boolean eventosConsultarEventos, boolean eventosEditarEventos, boolean eventosCadastrarEventos, boolean repositorioExcluirDocumento, boolean repositorioEditarDocumento, boolean repositorioConsultarDocumento, boolean repositorioIncluirDocumento, boolean calendariodeAgendamentosConsultarAgendamentos, boolean calendarioAgendamentosSolicitarAgendamentos, boolean historicoAgendamentosConsultar, boolean confirmacaoAgendamentosRegistrarAusencia, boolean confirmacaoAgendamentosRegistrarPresenca, boolean confirmacaoAgendamentosListarAgendamentosparaConfirmação, boolean autorizacaoAgendamentosAprovarSolicitacao, boolean autorizacaoAgendamentosRecusarSolicitacao, boolean autorizacaoAgendamentosListarSolicitacao, boolean relatoriosHistoricoAlocacao, boolean relatoriosHorasServico, boolean agendaConsultarDetalhes, boolean agendaConsultarDisponibilidade, boolean agendaConsultarAgenda) {
        this.perfil = perfil;
        this.cadastrosConsultarmeuCadastro = cadastrosConsultarmeuCadastro;
        this.perfilsConsultar = perfilsConsultar;
        this.perfisEditar = perfisEditar;
        this.perfisCadastrar = perfisCadastrar;
        this.usuariosDefinirPermissoes = usuariosDefinirPermissoes;
        this.usuariosInativarUsuarios = usuariosInativarUsuarios;
        this.usuariosConsultarUsuarios = usuariosConsultarUsuarios;
        this.usuariosEditarUsuarios = usuariosEditarUsuarios;
        this.usuariosCadastrarUsuarios = usuariosCadastrarUsuarios;
        this.unidadesConsultarUnidade = unidadesConsultarUnidade;
        this.unidadesEditarUnidade = unidadesEditarUnidade;
        this.unidadesCadastrarUnidade = unidadesCadastrarUnidade;
        this.parametrosConsultarParametros = parametrosConsultarParametros;
        this.parametrosEditarParametros = parametrosEditarParametros;
        this.parametrosCadastrarParametros = parametrosCadastrarParametros;
        this.eventosConsultarEventos = eventosConsultarEventos;
        this.eventosEditarEventos = eventosEditarEventos;
        this.eventosCadastrarEventos = eventosCadastrarEventos;
        this.repositorioExcluirDocumento = repositorioExcluirDocumento;
        this.repositorioEditarDocumento = repositorioEditarDocumento;
        this.repositorioConsultarDocumento = repositorioConsultarDocumento;
        this.repositorioIncluirDocumento = repositorioIncluirDocumento;
        this.calendariodeAgendamentosConsultarAgendamentos = calendariodeAgendamentosConsultarAgendamentos;
        this.calendarioAgendamentosSolicitarAgendamentos = calendarioAgendamentosSolicitarAgendamentos;
        this.historicoAgendamentosConsultar = historicoAgendamentosConsultar;
        this.confirmacaoAgendamentosRegistrarAusencia = confirmacaoAgendamentosRegistrarAusencia;
        this.confirmacaoAgendamentosRegistrarPresenca = confirmacaoAgendamentosRegistrarPresenca;
        this.confirmacaoAgendamentosListarAgendamentosparaConfirmação = confirmacaoAgendamentosListarAgendamentosparaConfirmação;
        this.autorizacaoAgendamentosAprovarSolicitacao = autorizacaoAgendamentosAprovarSolicitacao;
        this.autorizacaoAgendamentosRecusarSolicitacao = autorizacaoAgendamentosRecusarSolicitacao;
        this.autorizacaoAgendamentosListarSolicitacao = autorizacaoAgendamentosListarSolicitacao;
        this.relatoriosHistoricoAlocacao = relatoriosHistoricoAlocacao;
        this.relatoriosHorasServico = relatoriosHorasServico;
        this.agendaConsultarDetalhes = agendaConsultarDetalhes;
        this.agendaConsultarDisponibilidade = agendaConsultarDisponibilidade;
        this.agendaConsultarAgenda = agendaConsultarAgenda;
    }
    
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public boolean getCadastrosConsultarmeuCadastro() {
        return cadastrosConsultarmeuCadastro;
    }

    public void setCadastrosConsultarmeuCadastro(boolean cadastrosConsultarmeuCadastro) {
        this.cadastrosConsultarmeuCadastro = cadastrosConsultarmeuCadastro;
    }

    public boolean getPerfilsConsultar() {
        return perfilsConsultar;
    }

    public void setPerfilsConsultar(boolean perfilsConsultar) {
        this.perfilsConsultar = perfilsConsultar;
    }

    public boolean getPerfisEditar() {
        return perfisEditar;
    }

    public void setPerfisEditar(boolean perfisEditar) {
        this.perfisEditar = perfisEditar;
    }

    public boolean getPerfisCadastrar() {
        return perfisCadastrar;
    }

    public void setPerfisCadastrar(boolean perfisCadastrar) {
        this.perfisCadastrar = perfisCadastrar;
    }

    public boolean getUsuariosDefinirPermissoes() {
        return usuariosDefinirPermissoes;
    }

    public void setUsuariosDefinirPermissoes(boolean usuariosDefinirPermissoes) {
        this.usuariosDefinirPermissoes = usuariosDefinirPermissoes;
    }

    public boolean getUsuariosInativarUsuarios() {
        return usuariosInativarUsuarios;
    }

    public void setUsuariosInativarUsuarios(boolean usuariosInativarUsuarios) {
        this.usuariosInativarUsuarios = usuariosInativarUsuarios;
    }

    public boolean getUsuariosConsultarUsuarios() {
        return usuariosConsultarUsuarios;
    }

    public void setUsuariosConsultarUsuarios(boolean usuariosConsultarUsuarios) {
        this.usuariosConsultarUsuarios = usuariosConsultarUsuarios;
    }

    public boolean getUsuariosEditarUsuarios() {
        return usuariosEditarUsuarios;
    }

    public void setUsuariosEditarUsuarios(boolean usuariosEditarUsuarios) {
        this.usuariosEditarUsuarios = usuariosEditarUsuarios;
    }

    public boolean getUsuariosCadastrarUsuarios() {
        return usuariosCadastrarUsuarios;
    }

    public void setUsuariosCadastrarUsuarios(boolean usuariosCadastrarUsuarios) {
        this.usuariosCadastrarUsuarios = usuariosCadastrarUsuarios;
    }

    public boolean getUnidadesConsultarUnidade() {
        return unidadesConsultarUnidade;
    }

    public void setUnidadesConsultarUnidade(boolean unidadesConsultarUnidade) {
        this.unidadesConsultarUnidade = unidadesConsultarUnidade;
    }

    public boolean getUnidadesEditarUnidade() {
        return unidadesEditarUnidade;
    }

    public void setUnidadesEditarUnidade(boolean unidadesEditarUnidade) {
        this.unidadesEditarUnidade = unidadesEditarUnidade;
    }

    public boolean getUnidadesCadastrarUnidade() {
        return unidadesCadastrarUnidade;
    }

    public void setUnidadesCadastrarUnidade(boolean unidadesCadastrarUnidade) {
        this.unidadesCadastrarUnidade = unidadesCadastrarUnidade;
    }

    public boolean getParametrosConsultarParametros() {
        return parametrosConsultarParametros;
    }

    public void setParametrosConsultarParametros(boolean parametrosConsultarParametros) {
        this.parametrosConsultarParametros = parametrosConsultarParametros;
    }

    public boolean getParametrosEditarParametros() {
        return parametrosEditarParametros;
    }

    public void setParametrosEditarParametros(boolean parametrosEditarParametros) {
        this.parametrosEditarParametros = parametrosEditarParametros;
    }

    public boolean getParametrosCadastrarParametros() {
        return parametrosCadastrarParametros;
    }

    public void setParametrosCadastrarParametros(boolean parametrosCadastrarParametros) {
        this.parametrosCadastrarParametros = parametrosCadastrarParametros;
    }

    public boolean getEventosConsultarEventos() {
        return eventosConsultarEventos;
    }

    public void setEventosConsultarEventos(boolean eventosConsultarEventos) {
        this.eventosConsultarEventos = eventosConsultarEventos;
    }

    public boolean getEventosEditarEventos() {
        return eventosEditarEventos;
    }

    public void setEventosEditarEventos(boolean eventosEditarEventos) {
        this.eventosEditarEventos = eventosEditarEventos;
    }

    public boolean getEventosCadastrarEventos() {
        return eventosCadastrarEventos;
    }

    public void setEventosCadastrarEventos(boolean eventosCadastrarEventos) {
        this.eventosCadastrarEventos = eventosCadastrarEventos;
    }

    public boolean getRepositorioExcluirDocumento() {
        return repositorioExcluirDocumento;
    }

    public void setRepositorioExcluirDocumento(boolean repositorioExcluirDocumento) {
        this.repositorioExcluirDocumento = repositorioExcluirDocumento;
    }

    public boolean getRepositorioEditarDocumento() {
        return repositorioEditarDocumento;
    }

    public void setRepositorioEditarDocumento(boolean repositorioEditarDocumento) {
        this.repositorioEditarDocumento = repositorioEditarDocumento;
    }

    public boolean getRepositorioConsultarDocumento() {
        return repositorioConsultarDocumento;
    }

    public void setRepositorioConsultarDocumento(boolean repositorioConsultarDocumento) {
        this.repositorioConsultarDocumento = repositorioConsultarDocumento;
    }

    public boolean getRepositorioIncluirDocumento() {
        return repositorioIncluirDocumento;
    }

    public void setRepositorioIncluirDocumento(boolean repositorioIncluirDocumento) {
        this.repositorioIncluirDocumento = repositorioIncluirDocumento;
    }

    public boolean getCalendariodeAgendamentosConsultarAgendamentos() {
        return calendariodeAgendamentosConsultarAgendamentos;
    }

    public void setCalendariodeAgendamentosConsultarAgendamentos(boolean calendariodeAgendamentosConsultarAgendamentos) {
        this.calendariodeAgendamentosConsultarAgendamentos = calendariodeAgendamentosConsultarAgendamentos;
    }

    public boolean getCalendarioAgendamentosSolicitarAgendamentos() {
        return calendarioAgendamentosSolicitarAgendamentos;
    }

    public void setCalendarioAgendamentosSolicitarAgendamentos(boolean calendarioAgendamentosSolicitarAgendamentos) {
        this.calendarioAgendamentosSolicitarAgendamentos = calendarioAgendamentosSolicitarAgendamentos;
    }

    public boolean getHistoricoAgendamentosConsultar() {
        return historicoAgendamentosConsultar;
    }

    public void setHistoricoAgendamentosConsultar(boolean historicoAgendamentosConsultar) {
        this.historicoAgendamentosConsultar = historicoAgendamentosConsultar;
    }

    public boolean getConfirmacaoAgendamentosRegistrarAusencia() {
        return confirmacaoAgendamentosRegistrarAusencia;
    }

    public void setConfirmacaoAgendamentosRegistrarAusencia(boolean confirmacaoAgendamentosRegistrarAusencia) {
        this.confirmacaoAgendamentosRegistrarAusencia = confirmacaoAgendamentosRegistrarAusencia;
    }

    public boolean getConfirmacaoAgendamentosRegistrarPresenca() {
        return confirmacaoAgendamentosRegistrarPresenca;
    }

    public void setConfirmacaoAgendamentosRegistrarPresenca(boolean confirmacaoAgendamentosRegistrarPresenca) {
        this.confirmacaoAgendamentosRegistrarPresenca = confirmacaoAgendamentosRegistrarPresenca;
    }

    public boolean getConfirmacaoAgendamentosListarAgendamentosparaConfirmação() {
        return confirmacaoAgendamentosListarAgendamentosparaConfirmação;
    }

    public void setConfirmacaoAgendamentosListarAgendamentosparaConfirmação(boolean confirmacaoAgendamentosListarAgendamentosparaConfirmação) {
        this.confirmacaoAgendamentosListarAgendamentosparaConfirmação = confirmacaoAgendamentosListarAgendamentosparaConfirmação;
    }

    public boolean getAutorizacaoAgendamentosAprovarSolicitacao() {
        return autorizacaoAgendamentosAprovarSolicitacao;
    }

    public void setAutorizacaoAgendamentosAprovarSolicitacao(boolean autorizacaoAgendamentosAprovarSolicitacao) {
        this.autorizacaoAgendamentosAprovarSolicitacao = autorizacaoAgendamentosAprovarSolicitacao;
    }

    public boolean getAutorizacaoAgendamentosRecusarSolicitacao() {
        return autorizacaoAgendamentosRecusarSolicitacao;
    }

    public void setAutorizacaoAgendamentosRecusarSolicitacao(boolean autorizacaoAgendamentosRecusarSolicitacao) {
        this.autorizacaoAgendamentosRecusarSolicitacao = autorizacaoAgendamentosRecusarSolicitacao;
    }

    public boolean getAutorizacaoAgendamentosListarSolicitacao() {
        return autorizacaoAgendamentosListarSolicitacao;
    }

    public void setAutorizacaoAgendamentosListarSolicitacao(boolean autorizacaoAgendamentosListarSolicitacao) {
        this.autorizacaoAgendamentosListarSolicitacao = autorizacaoAgendamentosListarSolicitacao;
    }

    public boolean getRelatoriosHistoricoAlocacao() {
        return relatoriosHistoricoAlocacao;
    }

    public void setRelatoriosHistoricoAlocacao(boolean relatoriosHistoricoAlocacao) {
        this.relatoriosHistoricoAlocacao = relatoriosHistoricoAlocacao;
    }

    public boolean getRelatoriosHorasServico() {
        return relatoriosHorasServico;
    }

    public void setRelatoriosHorasServico(boolean relatoriosHorasServico) {
        this.relatoriosHorasServico = relatoriosHorasServico;
    }

    public boolean getAgendaConsultarDetalhes() {
        return agendaConsultarDetalhes;
    }

    public void setAgendaConsultarDetalhes(boolean agendaConsultarDetalhes) {
        this.agendaConsultarDetalhes = agendaConsultarDetalhes;
    }

    public boolean getAgendaConsultarDisponibilidade() {
        return agendaConsultarDisponibilidade;
    }

    public void setAgendaConsultarDisponibilidade(boolean agendaConsultarDisponibilidade) {
        this.agendaConsultarDisponibilidade = agendaConsultarDisponibilidade;
    }

    public boolean getAgendaConsultarAgenda() {
        return agendaConsultarAgenda;
    }

    public void setAgendaConsultarAgenda(boolean agendaConsultarAgenda) {
        this.agendaConsultarAgenda = agendaConsultarAgenda;
    }
}
