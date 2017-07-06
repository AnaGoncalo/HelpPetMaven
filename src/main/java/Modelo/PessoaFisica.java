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

/**
 *
 * @author anne
 */
@Entity
public class PessoaFisica extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    @OneToMany(mappedBy = "adotante")
    private Set<Encontro> encontros;

    public PessoaFisica() {
	super();
    }

    public PessoaFisica(Long id, String cpf, Set<Encontro> encontros) {
	super();
	this.id = id;
	this.cpf = cpf;
	this.encontros = encontros;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public Set<Encontro> getEncontros() {
	return encontros;
    }

    public void setEncontros(Set<Encontro> encontros) {
	this.encontros = encontros;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

}
