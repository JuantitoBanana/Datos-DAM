package Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SEjercicio3
 */
@WebServlet("/SEjercicio3")
public class SEjercicio3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SEjercicio3() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html><body>");
		String texto = request.getParameter("texto");
		if(!texto.equals("")) {
			request.getRequestDispatcher("Ejercicio3Encabezado.html").include(request, response);
			response.getWriter().append("<h3>Has tecleado " + texto +"</h3>")
								.append("<h5>Has delegado el procesamiento de la petición al servlet " + getServletName() + "</h5>");
			request.getRequestDispatcher("Ejercicio3Pie.html").include(request, response);
			response.getWriter().append("</body></html>");
			response.getWriter().close();
		} else {
			request.getRequestDispatcher("SEjercicio3Error").forward(request, response);
		}

		
	}

}
