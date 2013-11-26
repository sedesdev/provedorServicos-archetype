#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.__artifactId__.util;

import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filtro de servlet utilizado para controlar a manutenção das respostas dos
 * webservices e atribuir determinados headers nas respostas.
 */
public class FiltroServletWebServiceCabecalhos implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	

	@Override
	public void doFilter(javax.servlet.ServletRequest servletRequest,
			javax.servlet.ServletResponse servletResponse,
			javax.servlet.FilterChain filterChain) throws java.io.IOException,
			javax.servlet.ServletException {

		HttpServletResponse resp = (HttpServletResponse) servletResponse;

		// Adição de cabeçalhos
		resp.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Content-Type", "application/json;charset=UTF-8");
		resp.setDateHeader("Last-Modified", 0);
		
		// Execução do servlet
		filterChain.doFilter(servletRequest, resp);
	}

	@SuppressWarnings("rawtypes")
	public String getParametros(HttpServletRequest req) {
		StringBuilder parametros = new StringBuilder();
		Enumeration parameterNames = req.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			parametros.append(parameterName).append("=")
					.append(req.getParameter(parameterName));
		}
		return parametros.toString();
	}


	@Override
	public void destroy() {

	}
}
