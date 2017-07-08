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
@Path("clinicas")
public class ClinicaService {

    // "http://localhost:8080/TesteWS/rest/clinicas"
    @GET
    public String listarPJs() {

	Gson gson = new Gson();
	String json = null;
	UsuarioDao dao = new UsuarioDao();
	json = gson.toJson(dao.GetClinicasPetshops());

	return json;
    }
}
