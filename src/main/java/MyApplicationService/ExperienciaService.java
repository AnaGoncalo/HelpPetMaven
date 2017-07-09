package MyApplicationService;

import Modelo.Experiencia;
import Persistencia.ExperienciaDao;

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

@Path("experiencia")
public class ExperienciaService {

	ExperienciaDao dao = new ExperienciaDao();
	
	// "http://localhost:8080/TesteWS/rest/experiencia"
   @GET
   public String listarExperiencias() throws SQLException
   {
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
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/experiencia"
   @PUT
   public String editarExperiencia(String json) throws SQLException{
       Gson gson = new Gson();
       Experiencia a = gson.fromJson(json, Experiencia.class);
       dao.alterar(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/experiencia/{idExperiencia}"
   @DELETE
   public String excluirExperiencia(String json) throws SQLException{
       Gson gson = new Gson();
       Experiencia a = gson.fromJson(json, Experiencia.class);
       dao.excluir(a);
       
       return "ok";
   }
   
   // "http://localhost:8080/TesteWS/rest/experiencia/{idExperiencia}"
   @GET
   @Path("{idExperiencia}")
   public String listarPorId(@PathParam("idUsuario") int idExperiencia){
       Gson gson = new Gson();
       String json = null;
       json = gson.toJson(dao.pesquisarPorId(idExperiencia));
       
       return json;
   }
}
