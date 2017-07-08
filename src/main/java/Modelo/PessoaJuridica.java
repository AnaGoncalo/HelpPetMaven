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
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author anne
 */
@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class PessoaJuridica extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cnpj;

    private String funcionamento;

    public PessoaJuridica() {
    	super();
    }    
    
    public PessoaJuridica(String cnpj, String funcionamento) {
		super();
		this.cnpj = cnpj;
		this.funcionamento = funcionamento;
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

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
