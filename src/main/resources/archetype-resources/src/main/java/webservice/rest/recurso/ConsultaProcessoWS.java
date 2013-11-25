#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservice.rest.recurso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ${package}.infra.persistencia.RepositorioAndamentoJDBC;
import ${package}.util.RepositorioUtil;
import ${package}.webservice.rest.info.AndamentoInfo;

@Path("")
public class ConsultaProcessoWS {
	@GET
	@Path("/processos")
    public String pojo() {
        return "pojo ok @ " + new Date().toString();
	}
	
	
	@GET
	@Path("/v1/andamentos/{id}")
	@Produces("application/json")
	public Response getAndamentos(@PathParam(value="id") String id) {
		List<AndamentoInfo> andamentos = new ArrayList<AndamentoInfo>();
		RepositorioUtil repoUtil = new RepositorioUtil();
		
		try{
			RepositorioAndamentoJDBC repo = repoUtil.criarFabricaRepositorio().construirRepositorioAndamento();
			//repoUtil.beginTransaction();
			andamentos = repo.recuperarAndamentosPor("");
			//repoUtil.commitTransaction();
		}catch (Exception e){
			//repoUtil.rollbackTransaction();
			e.printStackTrace();
		}finally{
			repoUtil.close();
		}
		
		return Response.ok(andamentos).build();
	}
	
}

