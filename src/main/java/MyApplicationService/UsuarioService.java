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
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Ana Gonçalo
 */
@Path("usuario")
public class UsuarioService {

    UsuarioDao dao = new UsuarioDao();

    // "http://localhost:8080/TesteWS/rest/usuario"
    @POST
    public String cadastrarUsuario(String json) throws SQLException {
	Gson gson = new Gson();
	Usuario u = gson.fromJson(json, Usuario.class);

	dao.inserir(u);

	String jsonSaida = gson.toJson(u);
	return jsonSaida;
    }

    // "http://localhost:8080/TesteWS/rest/usuario"
    @PUT
    public String editarUsuario(String json) throws SQLException {
	Gson gson = new Gson();
	Usuario u = gson.fromJson(json, Usuario.class);

	dao.alterar(u);

	String jsonSaida = gson.toJson(u);
	return jsonSaida;
    }

    // "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}"
    @DELETE
    public String excluirUsuario(String json) throws SQLException {
	Gson gson = new Gson();
	Usuario u = gson.fromJson(json, Usuario.class);

//       System.out.println("Deu certo " + idUsuario);
//       UsuarioDAO dao = new UsuarioDAO();
//       dao.excluir(idUsuario);
	String jsonSaida = u.getNome() + " excluido";
	return jsonSaida;
    }

    // "http://localhost:8080/TesteWS/rest/usuario/{idUsuario}"
    @GET
    @Path("{idUsuario}")
    public String listarPorUsuario(@PathParam("idUsuario") int idUsuario) {

	Gson gson = new Gson();
	String json = null;
//       try {
//           UsuarioDAO dao = new UsuarioDAO();
//           json = gson.toJson(dao.buscarById(idUsuario));
////           Usuario u = gson.fromJson(json, Usuario.class);
////           if(u.getIdPermissao() == 1)
////               json = gson.toJson(PessoaFisicaDAO.byId(u.getIdUsuario()));
//       } catch (SQLException ex) {
//           Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
//       }

	return json;
    }
}
