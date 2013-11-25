#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.infra.persistencia.fabrica;

import java.sql.Connection;

import ${package}.__artifactId__.infra.persistencia.RepositorioAndamentoJDBC;
import ${package}.__artifactId__.infra.persistencia.RepositorioPessoaJDBC;

public class FabricaRepositoriosJDBC{
	
	private Connection conexao;

	public FabricaRepositoriosJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	// TODO: Para cada Repositório: Fazer com que a fábrica construa
	public RepositorioPessoaJDBC construirRepositorioPessoa(){
		return new RepositorioPessoaJDBC(conexao);
	}
	
	public RepositorioAndamentoJDBC construirRepositorioAndamento(){
		return new RepositorioAndamentoJDBC(conexao);
	}
}
