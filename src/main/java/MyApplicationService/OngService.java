/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApplicationService;

import com.google.gson.Gson;

import Persistencia.PessoaJuridicaDao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Ana Gonçalo
 */
@Path("ongs")
public class OngService {
    
	PessoaJuridicaDao dao = new PessoaJuridicaDao();
	
    // "http://localhost:8080/TesteWS/rest/ongs"
   @GET
   public String listarONGs(){
       
       Gson gson = new Gson();
       String json = null;
       json = gson.toJson(dao.listarOngs());
       
       return json;
   }
}
