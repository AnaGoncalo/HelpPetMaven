package MyApplicationService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import Modelo.ModeloTeste;
import Persistencia.ModeloTesteDao;

@Path("teste")
public class ModeloTesteService {

	@GET
	public String listar(){
		Gson gson = new Gson();
		ModeloTesteDao dao = new ModeloTesteDao();
		
		String json = "";
		json = gson.toJson(dao.listarTodos());
		
		return json;
	}
	
	@POST
	public String add(String json){
		Gson gson = new Gson();
		ModeloTeste m = gson.fromJson(json, ModeloTeste.class);
		ModeloTesteDao dao = new ModeloTesteDao();
		
		dao.inserir(m);
		
		return "ok";
	}
}
