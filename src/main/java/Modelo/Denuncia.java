package Modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author anne
 */

@Entity
public class Denuncia implements Serializable, Comparable<Denuncia> {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String titulo;

    @Column
    private String descricao;
    
    @Column
    private String tipo;
    
    @Column
    private String foto;
    
    @Column
    private String data;
    
    @Column
    private String localizacao;

    public Denuncia() {
    }

    public Denuncia(Long id, String titulo, String descricao, String tipo, String foto, String data, String localizacao) {
	this.id = id;
	this.titulo = titulo;
	this.descricao = descricao;
	this.tipo = tipo;
	this.foto = foto;
	this.data = data;
	this.localizacao = localizacao;
    }
    
    public String getTitulo(){
    	return titulo;
    }
    
    public void setTitulo(String titulo){
    	this.titulo = titulo;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }

    public String getFoto() {
	return foto;
    }

    public void setFoto(String foto) {
	this.foto = foto;
    }

    public String getData() {
	return data;
    }

    public void setData(String data) {
	this.data = data;
    }

    public String getLocalizacao() {
	return localizacao;
    }

    public void setLocalizacao(String localizacao) {
	this.localizacao = localizacao;
    }
    
    public boolean isEmpty(){
	return !(this.titulo != null && this.descricao != null && this.tipo != null && this.localizacao != null);
    }

    @Override
    public int compareTo(Denuncia o) {
	int result = 0;
	if(this.titulo != null && o.titulo != null){
	    result = this.titulo.compareTo(o.titulo);
	}
	else if(this.titulo == null && o.titulo == null){
	    result = 0;
	}
	else if(this.titulo == null){
	    result = -1;
	}
	else {
	    result = 1;
	}
	return result;
    }
    
}
