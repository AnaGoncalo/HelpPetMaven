/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Estoque;

/**
 *
 * @author anne
 */
public class EstoqueDao extends CrudDao<Estoque>{
    
    public EstoqueDao() {
	super(Estoque.class);
    }
    
}
