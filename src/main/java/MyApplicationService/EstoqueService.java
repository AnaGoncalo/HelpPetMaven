/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("estoque")
public class EstoqueService {
    // "http://localhost:8080/TesteWS/rest/estoque"
   @GET
   public String listarEstoque() throws SQLException
   {
       EstoqueDao dao = new EstoqueDao();
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
       EstoqueDao dao = new EstoqueDao();
       dao.inserir(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/estoque"
   @PUT
   public String editarEstoque(String json) throws SQLException{
       Gson gson = new Gson();
       Estoque a = gson.fromJson(json, Estoque.class);
       
       EstoqueDao dao = new EstoqueDao();
       dao.alterar(a);
       
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
   
   // "http://localhost:8080/TesteWS/rest/estoque/{idEstoque}"
   @DELETE
   public String excluirEstoque(String json) throws SQLException{
       Gson gson = new Gson();
       Estoque a = gson.fromJson(json, Estoque.class);
       
       EstoqueDao dao = new EstoqueDao();
       dao.excluir(a);
       
       return a.getProduto() + " excluido!";
   }
   
   // "http://localhost:8080/TesteWS/rest/estoque/{idUsuario}"
   @GET
   @Path("{idUsuario}")
   public String listarPorUsuario(@PathParam("idUsuario") int idUsuario){
       
       Gson gson = new Gson();
       String json = null;
       EstoqueDao dao = new EstoqueDao();
       json = gson.toJson(dao.pesquisarPorId(idUsuario));
       
       return json;
   }
}
