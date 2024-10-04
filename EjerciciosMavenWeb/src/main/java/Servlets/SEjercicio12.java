package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio1_2
 */
@WebServlet("/SEjercicio12")
public class SEjercicio12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SEjercicio12() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		
		if(request.getParameter("saludo").toLowerCase().equals("español")) {
			response.getWriter().append("Hola mundo");
		}
		else if(request.getParameter("saludo").toLowerCase().equals("ingles")) {
			response.getWriter().append("Hello world");
		}
		else if(request.getParameter("saludo").toLowerCase().equals("frances")) {
			response.getWriter().append("Bonjour le monde");
		}
		else if(request.getParameter("saludo").toLowerCase().equals("aleman")) {
			response.getWriter().append("Hallo Welt");
		}
		else {
			response.getWriter().append("El idioma no está en nuestra base de datos");
		}
		
	}

}
