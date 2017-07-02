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
import java.util.ArrayList;
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
    
//    private DenunciaDao dao = new DenunciaDao();
	
	List<Denuncia> lista = new ArrayList();
   // "http://localhost:8080/TesteWS/rest/denuncia"
   @GET
   public String listarDenuncias() throws SQLException
   {
//       DenunciaDAO dao = new DenunciaDAO();
//       List<Denuncia> denuncias = dao.ListarDenuncias();
//     
	   Denuncia d = new Denuncia();
	   d.setTitulo("titulo a");
//	   dao.inserir(d);
	   lista.add(d);
	   
       Gson gson = new Gson();
       String json = "";
       json = gson.toJson(lista);
//       json = gson.toJson(denuncias);
       
       return json;
   } 
   // "http://localhost:8080/TesteWS/rest/denuncia"
   @POST
   public String cadastrarDenuncia(String json) throws SQLException{
       Gson gson = new Gson();
       Denuncia a = gson.fromJson(json, Denuncia.class);
//       System.out.println("Deu certo " + a.getTituloDenuncia());
//       DenunciaDAO dao = new DenunciaDAO();
//       dao.CadastrarDenuncia(a);
//       
       lista.add(a);
//       String jsonSaida = gson.toJson(a);
       String jsonSaida = "Ok!";
       return jsonSaida;
       
   }
}
