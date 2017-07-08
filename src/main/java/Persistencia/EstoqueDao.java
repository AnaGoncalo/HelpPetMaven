/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Estoque;
import java.util.List;

/**
 *
 * @author anne
 */
public class EstoqueDao extends CrudDao<Estoque>{
    
    public EstoqueDao() {
	super(Estoque.class);
    }
    
    public List<Estoque> listarPorUsuario(Long id) {
	List<Estoque> lista = listarTodos();
	for(Estoque a : lista){
	    if(a.getOng().getId() != id){
		lista.remove(a);
	    }
	}
	return lista;
    }
}
