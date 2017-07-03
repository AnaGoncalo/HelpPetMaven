/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Modelo.Experiencia;
import Persistencia.ExperienciaDao;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("experiencia")
public class ExperienciaService {
    // "http://localhost:8080/TesteWS/rest/experiencia"
   @GET
   public String listarExperiencias() throws SQLException
   {
       ExperienciaDao dao = new ExperienciaDao();
       List<Experiencia> experiencias = dao.listarTodos();
       
       Gson gson = new Gson();
       String json = "";
       json = gson.toJson(experiencias);
       
       return json;
   } 
   
   // "http://localhost:8080/TesteWS/rest/experiencia"
   @POST
   public String cadastrarExperiencia(String json) throws SQLException{
       Gson gson = new Gson();
       Experiencia a = gson.fromJson(json, Experiencia.class);
       ExperienciaDao dao = new ExperienciaDao();
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
       
   }
   
   // "http://localhost:8080/TesteWS/rest/experiencia"
   @PUT
   public String editarExperiencia(String json) throws SQLException{
       Gson gson = new Gson();
       Experiencia a = gson.fromJson(json, Experiencia.class);
       
       ExperienciaDao dao = new ExperienciaDao();
       dao.alterar(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/experiencia/{idExperiencia}"
   @DELETE
   public String excluirExperiencia(String json) throws SQLException{
       Gson gson = new Gson();
       Experiencia a = gson.fromJson(json, Experiencia.class);
       ExperienciaDao dao = new ExperienciaDao();
       dao.excluir(a);
       
       return "ok";
   }
   
   // "http://localhost:8080/TesteWS/rest/experiencia/{idUsuario}"
   @GET
   @Path("{idUsuario}")
   public String listarPorUsuario(@PathParam("idUsuario") int idUsuario){
       
       Gson gson = new Gson();
       String json = null;
       ExperienciaDao dao = new ExperienciaDao();
       json = gson.toJson(dao.pesquisarPorId(idUsuario));
       
       return json;
   }
}
