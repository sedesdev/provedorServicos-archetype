#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import java.sql.Connection;

import ${package}.infra.persistencia.fabrica.FabricaRepositoriosJDBC;

/**
 * 
 * @author rodrigo
 *
 */
public class RepositorioUtil {

	private Connection conexao;
	private FabricaRepositoriosJDBC fabrica; 

	public RepositorioUtil() {
		this.conexao = new BancoDeDadosJNDI().getConnection();
		fabrica = new FabricaRepositoriosJDBC(conexao);
	}
	
    /**
     * Retorna a Fabrica de Repositorios
     * @return
     */
	public FabricaRepositoriosJDBC criarFabricaRepositorio(){
		return fabrica; 
	}

    /**
     * Recupera o EntityManager definido pelo n�mero dado como
     * par�metro
     * @return
     */
	public Connection getConexao(){
		return this.conexao;
	}
	
	public void beginTransaction() {
		try{
			getConexao().setAutoCommit(false);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void commitTransaction() {
		try {
			getConexao().commit();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void rollbackTransaction() {
		try {
			getConexao().rollback();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			getConexao().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
