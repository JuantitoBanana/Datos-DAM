package Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SEjercicio1Bienvenida
 */
@WebServlet("/SEjercicio1Bienvenida")
public class SEjercicio1Bienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SEjercicio1Bienvenida() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        response.getWriter().println("<h2>Bienvenido al MiniCurso Java sr@ " + request.getParameter("usuario") + "</h2>");
        response.getWriter().println("<a href='Ejercicio1.html'>Volver</a>");
	}

}
