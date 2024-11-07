package ArchivosJava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class ServletPersonas
 */
@WebServlet("/ServletPersonas")
public class ServletPersonas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        Persona persona = new Persona();
        persona.setDni(dni);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setDireccion(direccion);
        persona.setTelefono(telefono);
        persona.setCorreo(correo);

        request.setAttribute("persona", persona);

        request.getRequestDispatcher("MostrarPersonas.jsp").forward(request, response);

	}

}
