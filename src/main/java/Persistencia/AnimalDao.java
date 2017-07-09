/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import Modelo.Animal;

/**
 *
 * @author anne
 */
public class AnimalDao extends CrudDao<Animal> {

    public AnimalDao() {
	super(Animal.class);
    }

    public List<Animal> listarNaoAdotados() {
	List<Animal> lista = listarTodos();
	for (Animal a : lista) {
	    if (a.isStatus()) {
		lista.remove(a);
	    }
	}
	return lista;
    }

    public List<Animal> listarPorUsuario(Long idUsuario) {
	List<Animal> lista = listarTodos();
	for (Animal a : lista) {
	    if (a.getResponsavel().getId() != idUsuario) {
		lista.remove(a);
	    }
	}
	return lista;
    }

}
