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
	
	PessoaFisicaDao pfdao = new PessoaFisicaDao();
	PessoaJuridicaDao pjdao = new PessoaJuridicaDao();

    public UsuarioDao() {
	super(Usuario.class);
    }
    
    public boolean AddUsuario(Usuario usuario){
    	if(usuario.getPermissao().getNome().equals("Helper")){
    		PessoaFisica pf = new PessoaFisica();
    		pf.setEmail(usuario.getEmail());
    		pf.setFoto(usuario.getFoto());
    		pf.setLocalizacao(usuario.getLocalizacao());
    		pf.setNascimento(usuario.getNascimento());
    		pf.setNome(usuario.getNome());
    		pf.setSenha(usuario.getSenha());
    		pf.setTelefone(usuario.getTelefone());
    		pf.setPermissao(usuario.getPermissao());
    		pf.setCpf(null);
//    		pf.setAnimais(null);
//    		pf.setAnuncios(null);
//    		pf.setEncontros(null);
//    		pf.setEventos(null);
//    		pf.setExperiencias(null);
    		return pfdao.inserir(pf);
    	}
    	else{
    		PessoaJuridica pj = new PessoaJuridica();
    		pj.setEmail(usuario.getEmail());
    		pj.setFoto(usuario.getFoto());
    		pj.setLocalizacao(usuario.getLocalizacao());
    		pj.setNascimento(usuario.getNascimento());
    		pj.setNome(usuario.getNome());
    		pj.setSenha(usuario.getSenha());
    		pj.setTelefone(usuario.getTelefone());
    		pj.setPermissao(usuario.getPermissao());
    		pj.setCnpj(null);
    		pj.setFuncionamento(null);
//    		pj.setEstoques(null);
//    		pj.setAnimais(null);
//    		pj.setAnuncios(null);
//    		pj.setEventos(null);
//    		pj.setExperiencias(null);
    		return pjdao.inserir(pj);
    	}
    }
    
    public boolean RemUsuario(Usuario usuario){
    	if(usuario.getPermissao().getNome().equals("Helper"))
    		return pfdao.excluir((PessoaFisica) usuario);
    	else
    		return pjdao.excluir((PessoaJuridica) usuario);

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
