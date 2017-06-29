/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Animal;

/**
 *
 * @author anne
 */
public class AnimalDao extends CrudDao<Animal>{
    
    public AnimalDao() {
	super(Animal.class);
    }
    
}
