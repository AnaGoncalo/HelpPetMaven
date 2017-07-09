
package MyApplicationService;

/**
 *
 * @author Ana Gonçalo
 */

import Modelo.Estoque;
import Persistencia.EstoqueDao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("estoque")
public class EstoqueService {

	EstoqueDao dao = new EstoqueDao();
	
	// "http://localhost:8080/TesteWS/rest/estoque"
   @GET
   public String listarEstoque() throws SQLException
   {
       List<Estoque> estoques = dao.listarTodos();
       Gson gson = new Gson();
       String json = "";
       json = gson.toJson(estoques);
       
       return json;
   } 
   
   // "http://localhost:8080/TesteWS/rest/estoque"
   @POST
   public String cadastrarEstoque(String json) throws SQLException{
       Gson gson = new Gson();
       Estoque a = gson.fromJson(json, Estoque.class);
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/estoque"
   @PUT
   public String editarEstoque(String json) throws SQLException{
       Gson gson = new Gson();
       Estoque a = gson.fromJson(json, Estoque.class);
       dao.alterar(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/estoque/{idEstoque}"
   @DELETE
   public String excluirEstoque(String json) throws SQLException{
       Gson gson = new Gson();
       Estoque a = gson.fromJson(json, Estoque.class);
       dao.excluir(a);
       
       return a.getProduto() + " excluido!";
   }
   
   // "http://localhost:8080/TesteWS/rest/estoque/{idEstoque}"
   @GET
   @Path("{idEstoque}")
   public String listarPorId(@PathParam("idEstoque") int idEstoque){
       
       Gson gson = new Gson();
       String json = null;
       json = gson.toJson(dao.pesquisarPorId(idEstoque));
       
       return json;
   }
}
