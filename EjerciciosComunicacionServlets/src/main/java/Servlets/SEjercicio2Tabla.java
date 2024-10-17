package Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SEjercicio2Tabla
 */
@WebServlet("/SEjercicio2Tabla")
public class SEjercicio2Tabla extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SEjercicio2Tabla() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<style>.celdas{background-color:" + request.getParameter("colores") +";}</style>");
		response.getWriter().append("<body><hr><h3>Tabla de multiplicar del " + request.getParameter("tabla") + "</h3><hr>")
							.append("<table border='1'>");
		for (int i = 1; i <= 10; i++) {
			response.getWriter().append("<tr><td class='celdas'>" + request.getParameter("tabla") + " x " + i + "</td><td class='celdas'>" + (Integer.parseInt(request.getParameter("tabla")) * i) +"</td></tr>");
		}
		response.getWriter().append("</table><hr><a href='Ejercicio2.html'>Volver</a></body>");
	}

}
