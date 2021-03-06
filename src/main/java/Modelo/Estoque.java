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
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produto;

    private String tipo;

    private double qtdAtual;

    private double qtdIdeal;

    @ManyToOne
    private Usuario ong;

    public Estoque() {
	super();
    }

    public Estoque(Long id, String produto, String tipo, double qtdAtual, double qtdIdeal, Usuario ong) {
	this.id = id;
	this.produto = produto;
	this.tipo = tipo;
	this.qtdAtual = qtdAtual;
	this.qtdIdeal = qtdIdeal;
	this.ong = ong;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getProduto() {
	return produto;
    }

    public void setProduto(String produto) {
	this.produto = produto;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }

    public double getQtdAtual() {
	return qtdAtual;
    }

    public void setQtdAtual(double qtdAtual) {
	this.qtdAtual = qtdAtual;
    }

    public double getQtdIdeal() {
	return qtdIdeal;
    }

    public void setQtdIdeal(double qtdIdeal) {
	this.qtdIdeal = qtdIdeal;
    }

    public Usuario getOng() {
	return ong;
    }

    public void setOng(Usuario ong) {
	this.ong = ong;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
