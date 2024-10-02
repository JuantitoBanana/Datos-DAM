package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio3
 */
@WebServlet("/Ejercicio3")
public class Ejercicio3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int contador = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		if(getServletContext().getAttribute("contador") == null) {
			getServletContext().setAttribute("contador", 0);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		contador = (int) getServletContext().getAttribute("contador");
		contador++;
		getServletContext().setAttribute("contador", contador);
		
		
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Total de visitas: " + contador + "</h1>");
        response.getWriter().println("</body></html>");
	}

}
