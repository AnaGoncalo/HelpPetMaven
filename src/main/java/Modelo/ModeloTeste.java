package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ModeloTeste {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private String nome;
	
	@ManyToOne
    private User responsavel;
	
	public ModeloTeste() {
		super();
	}
	public ModeloTeste(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
}
