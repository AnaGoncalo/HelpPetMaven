/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author anne
 */
public class UsuarioDao extends CrudDao<Usuario> {

    public UsuarioDao() {
	super(Usuario.class);
    }

    public Usuario Logar(Usuario usuario) {
	List<Usuario> lista = listarTodos();
	for (Usuario a : lista) {
	    if (a.getEmail().equals(usuario.getEmail()) && a.getSenha().equals(usuario.getSenha())) {
		return a;
	    }
	}
	return null;
    }
}
