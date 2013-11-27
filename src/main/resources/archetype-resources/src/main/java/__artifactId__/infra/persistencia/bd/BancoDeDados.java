#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.infra.persistencia.bd;

import java.sql.Connection;

public interface BancoDeDados {

	public Connection getConnection();
}
