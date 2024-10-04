package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import Clases.Persona;

/**
 * Servlet implementation class Ejercicio2
 */
@WebServlet("/Ejercicio2")
public class Ejercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Persona> personas = new ArrayList<Persona>();
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    // Ejemplo a introducir: ?nombre=Juan&edad=20&telefono=123456789
		if(request.getParameter("nombre") != null && request.getParameter("edad") != null && request.getParameter("telefono") != null) {
			Persona persona = new Persona(request.getParameter("nombre"), Integer.parseInt(request.getParameter("edad")), request.getParameter("telefono"));
			personas.add(persona);
			getServletContext().setAttribute("listaPersonas", personas);
		}
		response.getWriter().append("<html><body><table border='1'>")
		 					.append("<tr><td>Nombre</td><td>Edad</td><td>Teléfono</td></tr>");
		for (Persona p : personas) {
			response.getWriter().append("<tr><td>" + p.getNombre() + "\t</td><td>" + p.getEdad() + "\t</td><td>" + p.getTelefono() + "\t</td></tr>");
		}
		response.getWriter().append("</table><br><form action='Ejercicio2b' method='get'><input type='submit' value='Enviar'></form></body></html>");
	}

}
