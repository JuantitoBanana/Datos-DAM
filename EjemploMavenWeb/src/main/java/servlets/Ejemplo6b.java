package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo7b
 */
@WebServlet("/Ejemplo7b")
public class Ejemplo6b extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String paramContex = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo6b() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		paramContex = config.getServletContext().getInitParameter("prueba");
		config.getServletContext().setAttribute("attribContext", "Atributo de Dam");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.getWriter().append("Parámetro de inicialización de contexto: " + paramContex);
		response.getWriter().append("\nAtributo del contexto: " + getServletContext().getAttribute("attribContext"));
		
	}

}
