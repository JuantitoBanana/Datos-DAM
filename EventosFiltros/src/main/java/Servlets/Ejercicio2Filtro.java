package Servlets;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet Filter implementation class Ejercicio2Filtro
 */
@WebFilter("/Ejercicio2")
public class Ejercicio2Filtro extends HttpFilter implements Filter {
       
	private Map<String, Integer> ContadorVisitas;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public Ejercicio2Filtro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
		String url = request.getRequestId();
        synchronized (ContadorVisitas) {
        	ContadorVisitas.put(url, ContadorVisitas.getOrDefault(url, 0) + 1);
        }

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	        ContadorVisitas = (Map<String, Integer>) getServletContext().getAttribute("ContadorVisitas");
	        
	        if (ContadorVisitas == null) {
	            ContadorVisitas = new HashMap<>();
	            getServletContext().setAttribute("ContadorVisitas", ContadorVisitas);
	        }
	}

}
