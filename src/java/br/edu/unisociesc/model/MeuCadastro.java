package br.edu.unisociesc.model;

public class MeuCadastro {

    private String senha;
    private String endereco;
    private String numero;
    private String complemento;
    private String pontoreferencia;
    private String cep;
    private String cidade;
    private String uf;
    private String email;
    private String telefone;
    private String cns;
    private String alergias;
    private String nomeemergencia;
    private String telefoneemergencia;
    private String planosaude;
    private String foto;
    private String segurovida;

    public MeuCadastro(String senha, String endereco, String numero, String complemento, String pontoreferencia, String cep, String cidade, String uf, String email, String telefome, String cns, String alergias, String nomeemergencia, String telefoneemergencia, String planosaude, String foto, String segurovida, String telefone) {
        this.senha = senha;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.pontoreferencia = pontoreferencia;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.email = email;
        this.telefone = telefone;
        this.cns = cns;
        this.alergias = alergias;
        this.nomeemergencia = nomeemergencia;
        this.telefoneemergencia = telefoneemergencia;
        this.planosaude = planosaude;
        this.foto = foto;
        this.segurovida = segurovida;
    }

    public MeuCadastro() {
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTelefoneemergencia(String telefoneemergencia) {
        this.telefoneemergencia = telefoneemergencia;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setPontoreferencia(String pontoreferencia) {
        this.pontoreferencia = pontoreferencia;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public void setNomeemergencia(String nomeemergencia) {
        this.nomeemergencia = nomeemergencia;
    }

    public void setPlanosaude(String planosaude) {
        this.planosaude = planosaude;
    }

    public void setSegurovida(String segurovida) {
        this.segurovida = segurovida;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getPontoreferencia() {
        return pontoreferencia;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCns() {
        return cns;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getNomeemergencia() {
        return nomeemergencia;
    }

    public String getTelefoneemergencia() {
        return telefoneemergencia;
    }

    public String getPlanosaude() {
        return planosaude;
    }

    public String getSegurovida() {
        return segurovida;
    }

    public String getSenha() {
        return senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndreco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
