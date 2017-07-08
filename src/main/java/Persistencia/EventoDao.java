/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Evento;
import java.util.List;

/**
 *
 * @author anne
 */
public class EventoDao extends CrudDao<Evento>{
    
    public EventoDao() {
	super(Evento.class);
    }
    
    public List<Evento> listarPorUsuario(Long id) {
	List<Evento> lista = listarTodos();
	for(Evento a : lista){
	    if(a.getResponsavel().getId() != id){
		lista.remove(a);
	    }
	}
	return lista;
    }
}
