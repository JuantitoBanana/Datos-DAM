package ArchivosJava;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class FiltroApp
 */
@WebFilter("/Aplicacion.jsp")
public class FiltroApp extends HttpFilter implements Filter {
	private ServletContext context;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroApp() {
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
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
        this.context.setAttribute("contadorAccesos", 0);
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
        synchronized (this.context) {
            Integer contadorAccesos = (Integer) this.context.getAttribute("contadorAccesos");
            this.context.setAttribute("contadorAccesos", contadorAccesos + 1);
        }
        
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	

}
