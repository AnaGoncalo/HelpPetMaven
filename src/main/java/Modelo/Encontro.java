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
public class Encontro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHorario;

    private String localizacao;

    private boolean editado;

    private boolean status;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private Usuario adotante;

    public Encontro() {
	super();
    }

    public Encontro(Long id, Date dataHorario, String localizacao, boolean editado, boolean status, Animal animal, Usuario adotante) {
	this.id = id;
	this.dataHorario = dataHorario;
	this.localizacao = localizacao;
	this.editado = editado;
	this.status = status;
	this.animal = animal;
	this.adotante = adotante;
    }

    public boolean isEmpty() {
	return !(this.animal != null && this.adotante != null && this.localizacao != null && this.dataHorario != null);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Date getDataHorario() {
	return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
	this.dataHorario = dataHorario;
    }

    public String getLocalizacao() {
	return localizacao;
    }

    public void setLocalizacao(String localizacao) {
	this.localizacao = localizacao;
    }

    public boolean isEditado() {
	return editado;
    }

    public void setEditado(boolean editado) {
	this.editado = editado;
    }

    public boolean isStatus() {
	return status;
    }

    public void setStatus(boolean status) {
	this.status = status;
    }

    public Animal getAnimal() {
	return animal;
    }

    public void setAnimal(Animal animal) {
	this.animal = animal;
    }

    public Usuario getAdotante() {
	return adotante;
    }

    public void setAdotante(Usuario adotante) {
	this.adotante = adotante;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
