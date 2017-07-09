/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Modelo.Evento;
import Persistencia.EventoDao;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Ana Gonçalo
 */
@Path("evento")
public class EventoService {
	
	EventoDao dao = new EventoDao();
	
    // "http://localhost:8080/TesteWS/rest/evento"
   @GET
   public String listarEvento() throws SQLException
   {
       List<Evento> eventos = dao.listarTodos();
       Gson gson = new Gson();
       String json = "";
       json = gson.toJson(eventos);
       
       return json;
   } 
   
   // "http://localhost:8080/TesteWS/rest/evento"
   @POST
   public String cadastrarEvento(String json) throws SQLException{
       Gson gson = new Gson();
       Evento a = gson.fromJson(json, Evento.class);
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/evento"
   @PUT
   public String editarEvento(String json) throws SQLException{
       Gson gson = new Gson();
       Evento a = gson.fromJson(json, Evento.class);
       dao.alterar(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/evento/{idEvento}"
   @DELETE
   public String excluirEvento(String json) throws SQLException{
       Gson gson = new Gson();
       Evento a = gson.fromJson(json, Evento.class);
       dao.excluir(a);
       
       return "ok";
   }
   
   // "http://localhost:8080/TesteWS/rest/evento/{idUsuario}"
   @GET
   @Path("{idUsuario}")
   public String listarPorUsuario(@PathParam("idUsuario") int idUsuario){
       
       Gson gson = new Gson();
       String json = null;
       json = gson.toJson(dao.pesquisarPorId(idUsuario));
       
       return json;
   }
}
