/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;


import Modelo.Animal;
import Persistencia.AnimalDao;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
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
@Path("animal")
public class AnimalService {
	
	AnimalDao dao = new AnimalDao();
	
   // "http://localhost:8080/TesteWS/rest/animal"
   @GET
   public String listar()
   {
       List<Animal> animais = null;
       animais = dao.listarTodos();
       
       Gson gson = new Gson();
       String json = gson.toJson(animais);
       
       return json;
   }
   
   // "http://localhost:8080/TesteWS/rest/animal/{idUsuario}"
   @GET
   @Path("{idUsuario}")
   public String listarPorUsuario(@PathParam("idUsuario") int idUsuario){
       
       Gson gson = new Gson();
       String json = null;
       json = gson.toJson(dao.pesquisarPorId(idUsuario));
       
       return json;
   }
   
   // "http://localhost:8080/TesteWS/rest/animal"
   @POST
   public String cadastrarAnimal(String json) 
   {
       Gson gson = new Gson();
       Animal a = gson.fromJson(json, Animal.class);
       
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
       
   }
   
   // "http://localhost:8080/TesteWS/rest/animal"
   @PUT
   public String editarAnimal(String json) 
   {
       Gson gson = new Gson();
       Animal a = gson.fromJson(json, Animal.class);
       
       dao.alterar(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
       
   }
   
   // "http://localhost:8080/TesteWS/rest/animal"
   @DELETE
   public String excluirAnimal(String json) 
   {
       Gson gson = new Gson();
       Animal a = gson.fromJson(json, Animal.class);
       
       AnimalDao dao = new AnimalDao();
           dao.excluir(a);
       
       return a.getNome() + " excluido!";
       
   }
}
