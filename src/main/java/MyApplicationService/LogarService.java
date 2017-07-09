/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Modelo.Usuario;
import Persistencia.UsuarioDao;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Ana Gonçalo
 */
@Path("logar")
public class LogarService {
    
	UsuarioDao dao = new UsuarioDao();
	
    // "http://localhost:8080/TesteWS/rest/logar"
   @POST
   public String logarUsuario(String json){
       Gson gson = new Gson();
       Usuario user = gson.fromJson(json, Usuario.class);
       Usuario usuarioLogado = dao.Logar(user);
       String jsonSaida = gson.toJson(usuarioLogado);
       return jsonSaida;
   }
    
}
