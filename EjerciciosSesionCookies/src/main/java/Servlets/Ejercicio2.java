package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Ejercicio2
 */
@WebServlet("/Ejercicio2")
public class Ejercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String nombre;
    private ArrayList<String> personas = new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession sesion = request.getSession(true);
		if(sesion.getAttribute("listaPersonas") != null)
			personas = (ArrayList<String>) sesion.getAttribute("listaPersonas");
		else
			sesion.setAttribute("listaPersonas", personas);
		if(request.getParameter("nombre") != null){
			nombre = request.getParameter("nombre");
			personas.add(nombre);
		}
		response.getWriter().append("<html><body>")
							.append("<p>Hola " + nombre +"</p>")
							.append("<p>Bienvenido a mi primera página web!</p>")
							.append("<p>Contigo, hoy me han visitado</p>");
		for (String p : personas) {
			response.getWriter().append(p + "<br>");
		}
		response.getWriter().append("</body></html>");
	}

}
