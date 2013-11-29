#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.infra.persistencia.bd;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.enunciate.jaxrs.TypeHint;

import ${package}.__artifactId__.infra.persistencia.RepositorioPessoaJDBC;
import ${package}.__artifactId__.util.RepositorioUtil;
import ${package}.__artifactId__.webservice.rest.info.PessoaInfo;

@Path("")
public class ConsultaPessoaWS {


	@GET
	@Path("/pessoas")
	@Produces("application/json")
	@TypeHint(qualifiedName="${package}.__artifactId__.webservice.rest.info.PessoaInfo", value=PessoaInfo.class)
	public Response pojo() {
		RepositorioUtil repoUtil = new RepositorioUtil();
		RepositorioPessoaJDBC repoPessoa = repoUtil.criarFabricaRepositorio().construirRepositorioPessoa();
		List<PessoaInfo> pessoas = repoPessoa.listar();
		
		repoUtil.close();
		
        return Response.ok(pessoas).status(200).build();
    }
}

