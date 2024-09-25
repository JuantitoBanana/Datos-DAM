package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Pojo.Persona;

/**
 * Servlet implementation class SEjercicio2
 */
@WebServlet("/SEjercicio2")
public class SEjercicio2 extends HttpServlet {
	
	private List<Persona> personas = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SEjercicio2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		int i = 1;
        while (request.getParameter("nombre" + i) != null) {
            String nombre = request.getParameter("nombre" + i);
            String apellidos = request.getParameter("apellidos" + i);
            int edad = Integer.parseInt(request.getParameter("edad" + i));
            String contacto = request.getParameter("contacto" + i);

            personas.add(new Persona(nombre, apellidos, edad, contacto));
            i++;
        }
        
        response.getWriter().append("<html><body>");
        response.getWriter().append("<table border='1'>");
        response.getWriter().append("<tr><th>Nombre</th><th>Apellidos</th><th>Edad</th><th>Contacto</th></tr>");

        for (Persona persona : personas) {
            response.getWriter().append("<tr>");
            response.getWriter().append("<td>" + persona.getNombre() + "</td>");
            response.getWriter().append("<td>" + persona.getApellidos() + "</td>");
            response.getWriter().append("<td>" + persona.getEdad() + "</td>");
            response.getWriter().append("<td>" + persona.getContacto() + "</td>");
            response.getWriter().append("</tr>");
        }

        response.getWriter().append("</table>");
        response.getWriter().append("</body></html>");
		
	}

}
