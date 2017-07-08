package Modelo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserTeste implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    @OneToMany(mappedBy = "responsavel")
    private Set<ModeloTeste> lista;

    public UserTeste() {
	super();
    }

    public UserTeste(Long id, String nome) {
	super();
	this.id = id;
	this.nome = nome;
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

    public Set<ModeloTeste> getLista() {
	return lista;
    }

    public void setLista(Set<ModeloTeste> lista) {
	this.lista = lista;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
