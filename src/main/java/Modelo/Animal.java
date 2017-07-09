package Modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


/**
 *
 * @author anne
 */
@Entity
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    private String tipo;
    
    private String especie;
    
    private String raca;
    
    private String idade;
    
    private String sexo;
    
    private String descricao;
    
    private String foto;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cadastro;
    
    private boolean status;
    
    private String localizacao;
    
    @ManyToOne
    private Usuario responsavel;
    
    public Animal() {
		super();
	}

	public Animal(Long id, String nome, String tipo, String especie, String raca, String idade, String sexo,
			String descricao, String foto, Date cadastro, boolean status, String localizacao, Usuario responsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.sexo = sexo;
		this.descricao = descricao;
		this.foto = foto;
		this.cadastro = cadastro;
		this.status = status;
		this.localizacao = localizacao;
		this.responsavel = responsavel;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	
	public boolean isEmpty(){
	return !(this.nome != null && this.tipo != null && this.especie != null && this.raca != null && this.idade != null && this.sexo != null && this.localizacao != null);
    }
    
}
