#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistencia.fabrica;

import java.sql.Connection;

import ${package}.infra.persistencia.RepositorioAndamentoJDBC;
import ${package}.infra.persistencia.RepositorioPessoaJDBC;

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
