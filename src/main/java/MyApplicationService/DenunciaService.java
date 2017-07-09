/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Modelo.Denuncia;
import Persistencia.DenunciaDao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Ana Gonçalo
 */
@Path("denuncia")
public class DenunciaService {
    
    private DenunciaDao dao = new DenunciaDao();
	
	
   // "http://localhost:8080/HelpPetMaven/rest/denuncia"
   @GET
   public String listarDenuncias() throws SQLException
   {   
       Gson gson = new Gson();
       List<Denuncia> denuncias = dao.listarTodos();
       String json = gson.toJson(denuncias);
       
       return json;
   } 
   
   // "http://localhost:8080/HelpPetMaven/rest/denuncia"
   @POST
   public String cadastrarDenuncia(String json) throws SQLException{
       Gson gson = new Gson();
       Denuncia a = gson.fromJson(json, Denuncia.class);

       dao.inserir(a);
       String jsonSaida = gson.toJson(a);
       return jsonSaida;
   }
}
