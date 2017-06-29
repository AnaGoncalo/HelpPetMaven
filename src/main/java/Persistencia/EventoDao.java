/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Evento;

/**
 *
 * @author anne
 */
public class EventoDao extends CrudDao<Evento>{
    
    public EventoDao() {
	super(Evento.class);
    }
    
}
