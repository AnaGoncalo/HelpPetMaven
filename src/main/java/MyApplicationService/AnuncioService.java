/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Modelo.Anuncio;
import Persistencia.AnuncioDao;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    // "http://localhost:8080/TesteWS/rest/anuncio"
   @GET
   public String listarAnuncio()
   {
       AnuncioDao dao = new AnuncioDao();
       List<Anuncio> anuncios = dao.listarTodos();
       
       Gson gson = new Gson();
       String json = "";
       json = gson.toJson(anuncios);
       
       return json;
   } 
   
   // "http://localhost:8080/TesteWS/rest/anuncio"
   @POST
   public String cadastrarAnuncio(String json) {
       Gson gson = new Gson();
       Anuncio a = gson.fromJson(json, Anuncio.class);
       AnuncioDao dao = new AnuncioDao();
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/anuncio"
   @PUT
   public String editarAnuncio(String json) {
       Gson gson = new Gson();
       Anuncio a = gson.fromJson(json, Anuncio.class);
       
       AnuncioDao dao = new AnuncioDao();
       dao.alterar(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/anuncio/{idAnuncio}"
   @DELETE
   public String excluirAnuncio(String json) {
       Gson gson = new Gson();
       Anuncio a = gson.fromJson(json, Anuncio.class); 
       AnuncioDao dao = new AnuncioDao();
       dao.excluir(a);
       
       return a.getTitulo() + " excluido!";
   }
   
   // "http://localhost:8080/TesteWS/rest/anuncio/{idUsuario}"
   @GET
   @Path("{idUsuario}")
   public String listarPorUsuario(@PathParam("idUsuario") int idUsuario){
       
       Gson gson = new Gson();
       String json = null;
       AnuncioDao dao = new AnuncioDao();
       json = gson.toJson(dao.pesquisarPorId(idUsuario));
       
       return json;
   }
}
