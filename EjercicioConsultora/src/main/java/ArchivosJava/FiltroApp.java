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
@WebFilter("/Registro.jsp")
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
	
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		ServletContext context = request.getServletContext();
		Integer numAccesos = context.getAttribute("numAccesos") != null? (Integer) context.getAttribute("numAccesos"): 0;
		context.setAttribute("numAccesos", numAccesos + 1);

        
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	

}
