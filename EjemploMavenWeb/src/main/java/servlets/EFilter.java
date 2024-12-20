package servlets;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.Map;

/**
 * Servlet Filter implementation class EFilter
 */
//@WebFilter("/*")
//@WebFilter("/Ejemplo14")
@WebFilter(urlPatterns = {"/Ejemplo14" , "/Ejemplo14b"})
public class EFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		StringBuilder buffer = new StringBuilder();
		Map <String, String[]> params = request.getParameterMap();
		
		for (Map.Entry<String, String[]> entry : params.entrySet()) {
			String key = entry.getKey();
			buffer.append(key);
			String [] val = entry.getValue();
			for(String string : val) {
				buffer.append(string);
				buffer.append("|");
			}
		}
		System.out.println("Recibiendo la petición desde la Ip: " + request.getRemoteAddr());
		if(!buffer.toString().equals("")) {
			System.out.println("\n La petición tiene los siguientes parametros: " + buffer);
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
