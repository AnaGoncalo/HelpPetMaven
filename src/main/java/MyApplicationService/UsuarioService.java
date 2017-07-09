/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Modelo.Animal;
import Modelo.Anuncio;
import Modelo.Usuario;
import Modelo.Evento;
import Modelo.Estoque;
import Modelo.Experiencia;
import Modelo.Encontro;
import Persistencia.AnimalDao;
import Persistencia.AnuncioDao;
import Persistencia.EncontroDao;
import Persistencia.EstoqueDao;
import Persistencia.EventoDao;
import Persistencia.ExperienciaDao;
import Persistencia.UsuarioDao;
import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Ana Gonçalo
 */
@Path("usuario")
public class UsuarioService {

    UsuarioDao dao = new UsuarioDao();
    AnimalDao daoA = new AnimalDao();
    AnuncioDao daoAn = new AnuncioDao();
    EstoqueDao daoEs = new EstoqueDao();
    EventoDao daoEv = new EventoDao();
    EncontroDao daoEn = new EncontroDao();
    ExperienciaDao daoEx = new ExperienciaDao();

    @GET
    public String listarUsuarios(){
    	Gson gson = new Gson();
    	return gson.toJson(dao.listarTodos());
    }
    
    // "http://localhost:8080/TesteWS/rest/usuario"
    @POST
    public String cadastrarUsuario(String json) throws SQLException {
	Gson gson = new Gson();
	Usuario u = gson.fromJson(json, Usuario.class);

	dao.inserir(u);

	String jsonSaida = gson.toJson(u);
	return jsonSaida;
    }

    // "http://localhost:8080/TesteWS/rest/usuario"
    @PUT
    public String editarUsuario(String json) throws SQLException {
	Gson gson = new Gson();
	Usuario u = gson.fromJson(json, Usuario.class);

	dao.alterar(u);

	String jsonSaida = gson.toJson(u);
	return jsonSaida;
    }

    // "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}"
    @DELETE
    public String excluirUsuario(String json) throws SQLException {
	Gson gson = new Gson();
	Usuario u = gson.fromJson(json, Usuario.class);

//       System.out.println("Deu certo " + idUsuario);
//       UsuarioDAO dao = new UsuarioDAO();
//       dao.excluir(idUsuario);
	String jsonSaida = u.getNome() + " excluido";
	return jsonSaida;
    }
    
    /*
     * "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}"
     */
    @GET
    @Path("{idUsuario}")
    public String buscarUsuarioPorId(@PathParam("idUsuario") int idUsuario) {
    	Gson gson = new Gson();
    	String json = null;
    	
    	json = gson.toJson(dao.pesquisarPorId((long) idUsuario));
    	return json;
    }

    /*
     * "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}/animal"
     */
    @GET
    @Path("{idUsuario}/animal")
    public String listarAnimaisPorUsuario(@PathParam("idUsuario") int idUsuario) {
    	Gson gson = new Gson();
    	String json = null;
    	for(Animal a : daoA.listarPorUsuario((long) idUsuario)){
    		System.out.println("Animal " + a.getNome());
    	}
    	json = gson.toJson(daoA.listarPorUsuario((long) idUsuario));
    	return json;
    }
    
    /*
     * "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}/anuncio"
     */
    @GET
    @Path("{idUsuario}/anuncio")
    public String listarAnunciosPorUsuario(@PathParam("idUsuario") int idUsuario) {
    	Gson gson = new Gson();
    	String json = null;
    	for(Anuncio a : daoAn.listarPorUsuario((long) idUsuario)){
    		System.out.println("Anuncio " + a.getTitulo());
    	}
    	json = gson.toJson(daoAn.listarPorUsuario((long) idUsuario));
    	return json;
    }
    
    /*
     * "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}/evento"
     */
    @GET
    @Path("{idUsuario}/evento")
    public String listarEventosPorUsuario(@PathParam("idUsuario") int idUsuario) {
    	Gson gson = new Gson();
    	String json = null;
    	for(Evento a : daoEv.listarPorUsuario((long) idUsuario)){
    		System.out.println("Evento " + a.getNome());
    	}
    	json = gson.toJson(daoEv.listarPorUsuario((long) idUsuario));
    	return json;
    }
    
    /*
     * "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}/estoque"
     */
    @GET
    @Path("{idUsuario}/estoque")
    public String listarEstoquesPorUsuario(@PathParam("idUsuario") int idUsuario) {
    	Gson gson = new Gson();
    	String json = null;
    	for(Estoque a : daoEs.listarPorUsuario((long) idUsuario)){
    		System.out.println("Estoque " + a.getProduto());
    	}
    	json = gson.toJson(daoEs.listarPorUsuario((long) idUsuario));
    	return json;
    }
    
    /*
     * "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}/experiencia"
     */
    @GET
    @Path("{idUsuario}/experiencia")
    public String listarExperienciasPorUsuario(@PathParam("idUsuario") int idUsuario) {
    	Gson gson = new Gson();
    	String json = null;
    	for(Experiencia a : daoEx.listarPorUsuario((long) idUsuario)){
    		System.out.println("Experiencia " + a.getTitulo());
    	}
    	json = gson.toJson(daoEx.listarPorUsuario((long) idUsuario));
    	return json;
    }
    
    /*
     * "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}/encontro"
     */
    @GET
    @Path("{idUsuario}/encontro")
    public String listarEncontroPorUsuario(@PathParam("idUsuario") int idUsuario) {
    	Gson gson = new Gson();
    	String json = null;
    	for(Encontro a : daoEn.listarPorUsuario((long) idUsuario)){
    		System.out.println("Encontro " + a.getAnimal().getNome());
    	}
    	json = gson.toJson(daoEn.listarPorUsuario((long) idUsuario));
    	return json;
    }
}
