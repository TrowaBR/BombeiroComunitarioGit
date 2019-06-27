package br.edu.unisociesc.model;// referencia para o pacote

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity //Uma entity é um objeto leve de domínio persistente utilizado para representar uma tabela da base de dados, sendo que cada instância da entity corresponde a uma linha da tabela. 
public class Usuario implements Serializable { // criação da classe

    // declaração de atributos
    @Id  //A anotação I@Id é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária da respectiva tabela no banco de dados. Essa é uma anotação obrigatória e um erro será gerado em tempo de execução caso ela não esteja presente.
    @GeneratedValue(strategy = GenerationType.AUTO)  // ID que serão automaticamente criados
    private long id;
    private String nomeGuerra;
    private String nomeCompleto;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataNascimento;
    private String sexo;
    private TiposGraduacao graduacao;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataGraduacao;
    private String senha;
    private String endereco;
    private int numero;
    private String complemento;
    private String pontoReferencia;
    private String cep;
    private String cidade;
    private String uf;
    private String rg;
    private String cpf;
    private String email;
    private String telefone;
    private String cns;
    private String alergias;
    private String nomeEmergencia;
    private String foneEmergencia;
    private String planoSaude;
    private String seguroVidaProprio;
    private String status;
    // fim da declaracao de atributos

    // Construtor com Parametros
    public Usuario(long id, String nomeGuerra, String nomeCompleto, Date dataNascimento, String sexo, TiposGraduacao graduacao, Date dataGraduacao, String senha, String endereco, int numero, String complemento, String pontoReferencia, String cep, String uf, String rg, String cpf, String email, String telefone, String cns, String alergias, String nomeEmergencia, String foneEmergencia, String planoSaude, String seguroVidaProprio, String status) {
        this.id = id;
        this.nomeGuerra = nomeGuerra;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.graduacao = graduacao;
        this.dataGraduacao = dataGraduacao;
        this.senha = senha;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.pontoReferencia = pontoReferencia;
        this.cep = cep;
        this.uf = uf;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cns = cns;
        this.alergias = alergias;
        this.nomeEmergencia = nomeEmergencia;
        this.foneEmergencia = foneEmergencia;
        this.planoSaude = planoSaude;
        this.seguroVidaProprio = seguroVidaProprio;
        this.status = status;
    }    // fim do Construtor com Parametros

    // Construtor sem Parametros
    public Usuario() {
    }
    // fim do Construtor sem Parametros   

    // metodos get/set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public TiposGraduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(TiposGraduacao graduacao) {
        this.graduacao = graduacao;
    }

    public Date getDataGraduacao() {
        return dataGraduacao;
    }

    public void setDatagraduacao(Date dataGraduacao) {
        this.dataGraduacao = dataGraduacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getNomeEmergencia() {
        return nomeEmergencia;
    }

    public void setNomeEmergencia(String nomeEmergencia) {
        this.nomeEmergencia = nomeEmergencia;
    }

    public String getFoneEmergencia() {
        return foneEmergencia;
    }

    public void setFoneEmergencia(String foneEmergencia) {
        this.foneEmergencia = foneEmergencia;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public String getSeguroVidaProprio() {
        return seguroVidaProprio;
    }

    public void setSeguroVidaProprio(String seguroVidaProprio) {
        this.seguroVidaProprio = seguroVidaProprio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    // fim de metodos get/set
} // finalização da classe

