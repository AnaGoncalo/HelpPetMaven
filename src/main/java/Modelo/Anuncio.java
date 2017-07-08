/*
 * Copyright 2017 HelpPet.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class Anuncio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String tipo;

    private String descricao;

    private String foto;

    @ManyToOne
    private Usuario responsavel;

    public Anuncio() {
	super();
    }

    public Anuncio(Long id, String titulo, String tipo, String descricao, String foto, Usuario responsavel) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.tipo = tipo;
	this.descricao = descricao;
	this.foto = foto;
	this.responsavel = responsavel;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
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

    public Usuario getResponsavel() {
	return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
	this.responsavel = responsavel;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
