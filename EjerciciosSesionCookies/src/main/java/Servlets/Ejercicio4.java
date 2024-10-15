package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Ejercicio4
 */
@WebServlet("/Ejercicio4")
public class Ejercicio4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	HttpSession sesion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		sesion = request.getSession(true);
		sesion.setAttribute("numEntradas", 1);
		response.getWriter().append("<form method='post'>")
							.append("<input type='submit' name='boton' value='Acceso'><input type='submit' name='boton' value='Nueva Sesion'>")
							.append("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(request.getParameter("boton").equals("Acceso")) {
			int cont = (int) sesion.getAttribute("numEntradas");
			sesion.setAttribute("numEntradas", cont + 1);
		} else if(request.getParameter("boton").equals("Nueva Sesion")) {
			sesion.invalidate();
			sesion = request.getSession(true);
			sesion.setAttribute("numEntradas", 1);
		}
		String mensaje = ((int)sesion.getAttribute("numEntradas") != 1)?"Desde la última vez ha accedido " + sesion.getAttribute("numEntradas") + " veces":"Es la primera vez que accede a la web";
		response.getWriter().append("<form method='post'>")
		.append("<input type='submit' name='boton' value='Acceso'><input type='submit' name='boton' value='Nueva Sesion'>")
		.append("</form>")
		.append(mensaje);
	}

}
