/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Modelo.Anuncio;
import Persistencia.AnuncioDao;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Ana Gonçalo
 */
@Path("anuncio")
public class AnuncioService {
	
	AnuncioDao dao = new AnuncioDao();
	
    // "http://localhost:8080/TesteWS/rest/anuncio"
   @GET
   public String listarAnuncio()
   {
       List<Anuncio> anuncios = dao.listarTodos();
       
       Gson gson = new Gson();
       String json = "ok";
       for(Anuncio a: anuncios){
    	   System.out.println("Anuncios " + a.getId() + " " + a.getTitulo() + " " + a.getResponsavel().getNome());
       }
       json = gson.toJson(anuncios);
       
       return json;
   } 
   
   // "http://localhost:8080/TesteWS/rest/anuncio"
   @POST
   public String cadastrarAnuncio(String json) {
       Gson gson = new Gson();
       Anuncio a = gson.fromJson(json, Anuncio.class);
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/anuncio"
   @PUT
   public String editarAnuncio(String json) {
       Gson gson = new Gson();
       Anuncio a = gson.fromJson(json, Anuncio.class);       
       dao.alterar(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/anuncio/{idAnuncio}"
   @DELETE
   public String excluirAnuncio(String json) {
       Gson gson = new Gson();
       Anuncio a = gson.fromJson(json, Anuncio.class); 
       dao.excluir(a);
       
       return a.getTitulo() + " excluido!";
   }
   
   // "http://localhost:8080/TesteWS/rest/anuncio/{idAnuncio}"
   @GET
   @Path("{idAnuncio}")
   public String listarPorId(@PathParam("idUsuario") int idAnuncio){
       
       Gson gson = new Gson();
       String json = null;
       AnuncioDao dao = new AnuncioDao();
       json = gson.toJson(dao.pesquisarPorId(idAnuncio));
       
       return json;
   }
}
