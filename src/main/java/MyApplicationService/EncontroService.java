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
/**
 *
 * @author Ana Gonçalo
 */
@Path("encontro")
public class EncontroService {
    // "http://localhost:8080/TesteWS/rest/encontro"
   @GET
   public String listarEncontros() throws SQLException
   {
//       EncontroDAO dao = new EncontroDAO();
//       List<Encontro> encontros = dao.ListarEncontros();
       
       Gson gson = new Gson();
       String json = "";
//       json = gson.toJson(encontros);
       
       return json;
   } 
   
   // "http://localhost:8080/TesteWS/rest/encontro"
   @POST
   public String cadastrarEncontro(String json) throws SQLException{
       Gson gson = new Gson();
       Encontro a = gson.fromJson(json, Encontro.class);
       //a.setIdUsuario(1);
//       System.out.println("Ainda não deu certo" + a.getAdotante().getIdUsuario());
//       //System.out.println("Deu certo " + a.getIdAnimal());
//       EncontroDAO dao = new EncontroDAO();
//       dao.CadastrarEncontro(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/encontro"
   @PUT
   public String editarEncontro(String json) throws SQLException{
       Gson gson = new Gson();
       Encontro a = gson.fromJson(json, Encontro.class);
       
//       EncontroDAO dao = new EncontroDAO();
//       dao.EditarEncontro(a);
//       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/encontro/{idEncontro}"
   @DELETE
   @Path("{idEncontro}")
   public String excluirEncontro(@PathParam("idEncontro") int idEncontro) throws SQLException{
       Gson gson = new Gson();
       //Encontro a = gson.fromJson(json, Encontro.class);
       System.out.println("EncontroService excluir" + idEncontro);
       
//       EncontroDAO dao = new EncontroDAO();
//       dao.ExcluirEncontro(idEncontro);
       
       String jsonSaida = gson.toJson(idEncontro);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/encontro/{idUsuario}"
   @GET
   @Path("{idUsuario}")
   public String listarPorUsuario(@PathParam("idUsuario") int idUsuario){
       
       Gson gson = new Gson();
       String json = null;
//       try {
//           EncontroDAO dao = new EncontroDAO();
//           json = gson.toJson(dao.ListarPorUsuario(idUsuario));
//       } catch (SQLException ex) {
//           Logger.getLogger(EncontroService.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       
       return json;
   }
}
