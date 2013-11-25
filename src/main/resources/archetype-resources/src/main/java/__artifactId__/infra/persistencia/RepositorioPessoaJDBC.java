#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.infra.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ${package}.__artifactId__.webservice.rest.info.PessoaInfo;

public class RepositorioPessoaJDBC {
	
	private Connection conexao;
	
	public RepositorioPessoaJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	public void adicionar(PessoaInfo pessoa){
		// VEM SQL DE ADICAO
	}
	
	public List<PessoaInfo> listar(){
		List<PessoaInfo> pessoas = new ArrayList<PessoaInfo>();
		
		String sql = "select NM_AGREGADOR from ADMGESTOC.AGREGADOR ";
		
		Statement stmt;
		ResultSet rows;
		try {
			stmt = conexao.createStatement();
			rows = stmt.executeQuery(sql);
			
			while (rows.next()) {
				pessoas.add(new PessoaInfo(rows.getString("NM_AGREGADOR")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pessoas;
	}
}
