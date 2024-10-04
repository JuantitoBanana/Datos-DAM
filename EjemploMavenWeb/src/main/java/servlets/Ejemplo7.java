package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionIdListener;
import java.util.Date;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo7
 */
@WebServlet("/Ejemplo7")
public class Ejemplo7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cont = 1;
		response.setContentType("text/plain");
		//Crear la sesión
		HttpSession sesion = request.getSession(true);
		if(sesion.getAttribute("cont") == null) {
			response.getWriter().append("Hola Dam\n");
		} else {
			response.getWriter().append("Hola de nuevo Dam\n");
			cont = (int) sesion.getAttribute("cont");
		}
		//Para que funcione, hay que eliminar las cookies
		//response.sendRedirect(response.encodeRedirectURL("Ejemplo7"));
		//incremento el atributo contador de la sesión
		sesion.setAttribute("cont", ++cont);
		response.getWriter().append("Accesos de sesión: " + cont +"\n")
							.append("La sesión fue creada: " + new Date(sesion.getCreationTime()) +"\n")
							.append("La sesión se identifica: " + sesion.getId() +"\n")
							.append("Ultimo acceso: " + new Date(sesion.getLastAccessedTime()) +"\n")
							.append("La sesión permanece inactiva por: " + sesion.getMaxInactiveInterval());
	}

}
