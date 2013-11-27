#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.infra.persistencia.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Classe que representa a conexão com o banco de dados JNDI
 * @author rodrigo
 *
 */
public class BancoDeDadosLocal implements BancoDeDados 
{
	private static final String USER_NAME = "system";
	private static final String PASSWORD  = "12345678";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	@Override
	public Connection getConnection() {
		try{

		    Connection conn = null;
		    Properties connectionProps = new Properties();
		    connectionProps.put("user", USER_NAME);
		    connectionProps.put("password", PASSWORD);
		    conn = DriverManager.getConnection(URL, connectionProps);
		    return conn;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
