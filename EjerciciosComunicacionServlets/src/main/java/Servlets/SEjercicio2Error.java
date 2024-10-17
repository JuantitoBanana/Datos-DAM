package Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SEjercicio2Error
 */
@WebServlet("/SEjercicio2Error")
public class SEjercicio2Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SEjercicio2Error() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<h2>Mensaje del Servidor</h2><hr>")
							.append("<h3>No has elegido ninguna tabla. Elige una tabla por favor.</h3>")
							.append("<a href='Ejercicio2.html'>Volver</a>");
	}

}
