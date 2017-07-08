package Modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author anne
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String foto;

    private String nascimento;

    private String localizacao;

    private String telefone;

    private String cpf_cnpj;

    private String funcionamento;

    private String descricao;

    @ManyToOne
    private Permissao permissao;

    public Usuario() {
	super();
    }

    public Usuario(Long id, String nome, String email, String senha, String foto, String nascimento, String localizacao, String telefone, String cpf_cnpj, String funcionamento, String descricao, Permissao permissao) {
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.senha = senha;
	this.foto = foto;
	this.nascimento = nascimento;
	this.localizacao = localizacao;
	this.telefone = telefone;
	this.cpf_cnpj = cpf_cnpj;
	this.funcionamento = funcionamento;
	this.descricao = descricao;
	this.permissao = permissao;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getFoto() {
	return foto;
    }

    public void setFoto(String foto) {
	this.foto = foto;
    }

    public String getNascimento() {
	return nascimento;
    }

    public void setNascimento(String nascimento) {
	this.nascimento = nascimento;
    }

    public String getLocalizacao() {
	return localizacao;
    }

    public void setLocalizacao(String localizacao) {
	this.localizacao = localizacao;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public String getCpf_cnpj() {
	return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
	this.cpf_cnpj = cpf_cnpj;
    }

    public String getFuncionamento() {
	return funcionamento;
    }

    public void setFuncionamento(String funcionamento) {
	this.funcionamento = funcionamento;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Permissao getPermissao() {
	return permissao;
    }

    public void setPermissao(Permissao permissao) {
	this.permissao = permissao;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
