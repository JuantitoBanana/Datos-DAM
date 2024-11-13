package ArchivosJava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		
		if (nombre == null || nombre.isEmpty() || contrasena == null || contrasena.isEmpty()) {
        	getServletContext().setAttribute("error", "(*)El nombre de usuario y la contraseña no pueden estar vacios");
            request.getRequestDispatcher("Registro.jsp").forward(request, response);
        }else {
        	
        }
		
	}

}
