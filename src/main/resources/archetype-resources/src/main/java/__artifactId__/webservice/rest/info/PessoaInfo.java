#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.webservice.rest.info;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PessoaInfo {

	private String nome;
	
	public PessoaInfo() {
		// TODO Auto-generated constructor stub
	}

	public PessoaInfo(String nome){
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
