/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Persistencia.UsuarioDao;
import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Ana Gonçalo
 */
@Path("ongs")
public class OngService {

    UsuarioDao dao = new UsuarioDao();

    // "http://localhost:8080/TesteWS/rest/ongs"
    @GET
    public String listarONGs() {

	Gson gson = new Gson();
	String json = null;
	json = gson.toJson(dao.GetOngs());

	return json;
    }
}
