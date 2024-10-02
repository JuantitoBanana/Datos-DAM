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
 * Servlet implementation class Ejercicio2b
 */
@WebServlet("/Ejercicio2b")
public class Ejercicio2b extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> personas = new ArrayList<Persona>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2b() {
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
		personas = (ArrayList<Persona>) getServletContext().getAttribute("listaPersonas");
		
		response.getWriter().append("<html><body><table border='1'>")
							.append("<tr><td>Nombre</td><td>Edad</td><td>Teléfono</td></tr>");
		for (Persona p : personas) {
			response.getWriter().append("<tr><td>" + p.getNombre() + "\t</td><td>" + p.getEdad() + "\t</td><td>" + p.getTelefono() + "\t</td></tr>");
		}
		response.getWriter().append("</table></body></html>");
	}

}
