#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ${package}.__artifactId__.infra.persistencia.bd.BancoDeDados;
import ${package}.__artifactId__.infra.persistencia.bd.BancoDeDadosLocal;
import ${package}.__artifactId__.util.RepositorioUtil;
import ${package}.__artifactId__.webservice.rest.info.PessoaInfo;
 

public class ClasseTest{

	@Test
 	public void testApp() {
		BancoDeDados bd = new BancoDeDadosLocal();
		RepositorioUtil repositorioUtil = new RepositorioUtil(bd);
		
		List<PessoaInfo> p = repositorioUtil.criarFabricaRepositorio().construirRepositorioPessoa().listar();
		
		
		Assert.assertTrue(p.size() == 4);
	}
}