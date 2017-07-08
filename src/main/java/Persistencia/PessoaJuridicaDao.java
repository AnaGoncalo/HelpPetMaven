/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import Modelo.PessoaJuridica;
import util.JpaUtil;

/**
 *
 * @author anne
 */
public class PessoaJuridicaDao extends CrudDao<PessoaJuridica>{
    
    public PessoaJuridicaDao() {
    	super(PessoaJuridica.class);
    }
    
    public List<PessoaJuridica> listarOngs() {
//        List<PessoaJuridica> lista = listarTodos();
//        for(PessoaJuridica pj: lista){
//        	if(pj.getPermissao().getNome().equals("ONG")){
//        		lista.remove(pj);
//        	}
//        }
//        return lista;
    	return listarTodos();
    }
}
