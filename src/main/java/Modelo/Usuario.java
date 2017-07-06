package Modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author anne
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
    
    @ManyToOne
    private Permissao permissao;
    
    @OneToMany(mappedBy = "responsavel")
    private Set<Animal> animais;
    
    @OneToMany(mappedBy = "responsavel")
    private Set<Evento> eventos;
    
    @OneToMany(mappedBy = "responsavel")
    private Set<Anuncio> anuncios;
    
    @OneToMany(mappedBy = "usuario")
    private Set<Experiencia> experiencias;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String email, String senha, String foto, String nascimento, String localizacao,
			String telefone, Permissao permissao, Set<Animal> animais, Set<Evento> eventos, Set<Anuncio> anuncios,
			Set<Experiencia> experiencias) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.nascimento = nascimento;
		this.localizacao = localizacao;
		this.telefone = telefone;
		this.permissao = permissao;
		this.animais = animais;
		this.eventos = eventos;
		this.anuncios = anuncios;
		this.experiencias = experiencias;
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

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Set<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(Set<Animal> animais) {
		this.animais = animais;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	public Set<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(Set<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public Set<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(Set<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
