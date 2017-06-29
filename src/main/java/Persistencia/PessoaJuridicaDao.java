/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.PessoaJuridica;

/**
 *
 * @author anne
 */
public class PessoaJuridicaDao extends CrudDao<PessoaJuridica>{
    
    public PessoaJuridicaDao() {
	super(PessoaJuridica.class);
    }
    
}
