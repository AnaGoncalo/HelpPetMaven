/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Experiencia;
import java.util.List;

/**
 *
 * @author anne
 */
public class ExperienciaDao extends CrudDao<Experiencia>{
    
    public ExperienciaDao() {
	super(Experiencia.class);
    }
    
    public List<Experiencia> listarPorUsuario(Long id) {
	List<Experiencia> lista = listarTodos();
	for(Experiencia a : lista){
	    if(a.getUsuario().getId() != id){
		lista.remove(a);
	    }
	}
	return lista;
    }
    
}
