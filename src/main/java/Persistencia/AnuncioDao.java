/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Anuncio;

/**
 *
 * @author anne
 */
public class AnuncioDao extends CrudDao<Anuncio>{
    
    public AnuncioDao() {
	super(Anuncio.class);
    }
    
}
