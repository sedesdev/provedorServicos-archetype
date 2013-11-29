#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.webservice.rest.recurso;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.enunciate.jaxrs.TypeHint;

import ${package}.__artifactId__.infra.persistencia.RepositorioAndamentoJDBC;
import ${package}.__artifactId__.util.RepositorioUtil;
import ${package}.__artifactId__.webservice.rest.info.AndamentoInfo;
import ${package}.__artifactId__.webservice.rest.info.PessoaInfo;

@Path("")
public class ConsultaProcessoWS {
	@GET
	@Path("/pessoas")
	@Consumes("application/json")
	@TypeHint(qualifiedName="${package}.__artifactId__.webservices.rest.info.PessoaInfo", value=PessoaInfo.class)
    public Response getPessoas() {
		RepositorioUtil repo = new RepositorioUtil();
		List<PessoaInfo> p = repo.criarFabricaRepositorio().construirRepositorioPessoa().listar();
		
        return Response.ok(p).status(200).build();
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

