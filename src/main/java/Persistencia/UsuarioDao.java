/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.PessoaFisica;
import Modelo.PessoaJuridica;
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
    
    public boolean AddUsuario(Usuario usuario){
    	PessoaFisicaDao pfdao = new PessoaFisicaDao();
    	PessoaJuridicaDao pjdao = new PessoaJuridicaDao();
    	if(usuario.getPermissao().getNome().equals("Helper"))
    		return pfdao.inserir((PessoaFisica) usuario);
    	else
    		return pjdao.inserir((PessoaJuridica) usuario);
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
