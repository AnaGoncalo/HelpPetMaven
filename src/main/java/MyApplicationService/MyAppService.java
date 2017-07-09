/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import com.google.gson.Gson;

import Modelo.ModeloTeste;
import Modelo.Denuncia;
import Persistencia.DenunciaDao;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Ana Gonçalo
 */
// "http://localhost:8080/TesteWS/rest/myapp"
@Path("myapp")
public class MyAppService {
	
	private DenunciaDao dao = new DenunciaDao();
	
    @GET
    public String Testar() {
    	List<Denuncia> denuncias = dao.listarTodos();
    	Gson gson = new Gson();
    	String json = gson.toJson(denuncias);
        return json;
    }
    
    //http://localhost:8080/TesteWS/rest/myapp"
    @POST
    public String Testar2(String json) {
        Gson gson = new Gson();
        System.out.println(json);
        ModeloTeste mt = gson.fromJson(json, ModeloTeste.class);
//        System.out.println("Deu certo " + mt.getNomeTeste());
        //ModeloTesteDAO.salvar(mt);
        String jsonSaida = "";
//        json = gson.toJson(mt);
        return "ok";
        //return "Oi post";
    }
}
