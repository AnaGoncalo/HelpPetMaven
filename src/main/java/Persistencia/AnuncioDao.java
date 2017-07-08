/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Anuncio;
import java.util.List;

/**
 *
 * @author anne
 */
public class AnuncioDao extends CrudDao<Anuncio>{
    
    public AnuncioDao() {
	super(Anuncio.class);
    }
    
    public List<Anuncio> listarPorUsuario(Long id) {
	List<Anuncio> lista = listarTodos();
	for(Anuncio a : lista){
	    if(a.getResponsavel().getId() != id){
		lista.remove(a);
	    }
	}
	return lista;
    }
    
}
