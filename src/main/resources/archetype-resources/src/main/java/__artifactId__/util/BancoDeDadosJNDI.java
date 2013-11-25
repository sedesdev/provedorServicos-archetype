#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

/**
 * Classe que representa a conexão com o banco de dados JNDI
 * @author rodrigo
 *
 */
public class BancoDeDadosJNDI 
{
	private static final String JNDI_PATH = "java:jboss/datasources/__artifactId__DS"; 
	
	public Connection getConnection() {
		try{
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) PortableRemoteObject.narrow(ctx.lookup(JNDI_PATH), DataSource.class);
	        return ds.getConnection();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
