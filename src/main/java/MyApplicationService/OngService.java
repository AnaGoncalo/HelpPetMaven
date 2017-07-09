/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import Persistencia.UsuarioDao;
import com.google.gson.Gson;

import Modelo.Usuario;

import java.util.List;

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

    List<Usuario> usuarios = null;
    usuarios = dao.listarOngs();
    
	Gson gson = new Gson();
	String json = gson.toJson(usuarios);

	return json;
    }
}
