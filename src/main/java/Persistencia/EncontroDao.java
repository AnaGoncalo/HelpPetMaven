/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Encontro;
import java.util.List;

/**
 *
 * @author anne
 */
public class EncontroDao extends CrudDao<Encontro>{
    
    public EncontroDao() {
	super(Encontro.class);
    }
    
    public List<Encontro> listarPorUsuario(Long id) {
	List<Encontro> lista = listarTodos();
	for(Encontro a : lista){
	    if(a.getAnimal().getResponsavel().getId() != id || a.getAdotante().getId() != id){
		lista.remove(a);
	    }
	}
	return lista;
    }
    
}
