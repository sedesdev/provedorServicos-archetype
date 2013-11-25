#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.infra.persistencia;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import ${package}.__artifactId__.webservice.rest.info.AndamentoInfo;
import oracle.jdbc.OracleTypes;

public class RepositorioAndamentoJDBC {
	private Connection conexao;
	
	public RepositorioAndamentoJDBC(Connection conexao) {
		this.conexao = conexao;
	}
	
	// TODO: Adicionar metodos de consulta
	public List<AndamentoInfo> recuperarAndamentosPor(String numeroProtocolo){
		System.out.println(conexao + " " + OracleTypes.ARRAY);
		return new ArrayList<AndamentoInfo>();
	}
}
