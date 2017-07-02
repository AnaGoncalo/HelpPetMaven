/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Modelo.Denuncia;
import Persistencia.DenunciaDao;
import com.google.gson.Gson;

import java.sql.Date;
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
	   d.setId(new Long(1));
	   d.setTitulo("Animal abandonado");
	   d.setDescricao("Animal abandonado sem agua e sem comida!");
	   d.setData("02/07/2017");
	   d.setLocalizacao("Natal, RN");
	   d.setTipo("Abandono");
	   d.setFoto("imagens//denuncia1.jpg");
	   lista.add(d);
	   
	   Denuncia d2 = new Denuncia();
	   d2.setId(new Long(2));
	   d2.setTitulo("Cachorros brigando");
	   d2.setDescricao("Cacchorros bringando no meio da noite!");
	   d2.setData("02/07/2017");
	   d2.setLocalizacao("Serra Caiada, RN");
	   d2.setTipo("Outro");
	   d2.setFoto("imagens//denuncia2.jpg");
	   lista.add(d2);
	   
	   Denuncia d3 = new Denuncia();
	   d3.setId(new Long(3));
	   d3.setTitulo("Homem batendo em animais");
	   d3.setDescricao("Meu vizinho usa um chicote para assustar os gatos que andam de noite");
	   d3.setData("02/07/2017");
	   d3.setLocalizacao("Serra Caiada, RN");
	   d3.setTipo("Maus Tratos");
	   d3.setFoto("imagens//denuncia3.jpg");
//	   dao.inserir(d);
	   lista.add(d3);
	   
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
