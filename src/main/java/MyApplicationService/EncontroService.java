package MyApplicationService;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import Modelo.Encontro;
import Persistencia.EncontroDao;
/**
 *
 * @author Ana Gonçalo
 */
@Path("encontro")
public class EncontroService {
    // "http://localhost:8080/TesteWS/rest/encontro"
   @GET
   public String listarEncontros()
   {
       EncontroDao dao = new EncontroDao();
       List<Encontro> encontros = dao.listarTodos();
       
       Gson gson = new Gson();
       String json = "";
       json = gson.toJson(encontros);
       
       return json;
   } 
   
   // "http://localhost:8080/TesteWS/rest/encontro"
   @POST
   public String cadastrarEncontro(String json) {
       Gson gson = new Gson();
       Encontro a = gson.fromJson(json, Encontro.class);
       EncontroDao dao = new EncontroDao();
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/encontro"
   @PUT
   public String editarEncontro(String json) {
       Gson gson = new Gson();
       Encontro a = gson.fromJson(json, Encontro.class);
       
       EncontroDao dao = new EncontroDao();
       dao.alterar(a);
//       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/encontro/{idEncontro}"
   @DELETE
   public String excluirEncontro(String json) {
       Gson gson = new Gson();
       Encontro a = gson.fromJson(json, Encontro.class);
       EncontroDao dao = new EncontroDao();
       dao.excluir(a);
       
       return a.getId() + " excluido!";
   }
   
   // "http://localhost:8080/TesteWS/rest/encontro/{idUsuario}"
   @GET
   @Path("{idUsuario}")
   public String listarPorUsuario(@PathParam("idUsuario") int idUsuario){
       
       Gson gson = new Gson();
       String json = null;
       EncontroDao dao = new EncontroDao();
       json = gson.toJson(dao.pesquisarPorId(idUsuario));
       
       return json;
   }
}
