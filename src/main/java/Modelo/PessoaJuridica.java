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
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author anne
 */
@Entity
public class PessoaJuridica extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    private String funcionamento;

    @OneToMany(mappedBy = "ong")
    private Set<Estoque> estoques;

    public PessoaJuridica() {
	super();
    }

    public PessoaJuridica(Long id, String cnpj, String funcionamento, Set<Estoque> estoques) {
	super();
	this.id = id;
	this.cnpj = cnpj;
	this.funcionamento = funcionamento;
	this.estoques = estoques;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCnpj() {
	return cnpj;
    }

    public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
    }

    public String getFuncionamento() {
	return funcionamento;
    }

    public void setFuncionamento(String funcionamento) {
	this.funcionamento = funcionamento;
    }

    public Set<Estoque> getEstoques() {
	return estoques;
    }

    public void setEstoques(Set<Estoque> estoques) {
	this.estoques = estoques;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
