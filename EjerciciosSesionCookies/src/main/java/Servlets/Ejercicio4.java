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
		response.getWriter().append("<form action='Ejercicio4' method='post'>")
							.append("<input type='submit' name='boton' value='Acceso'><input type='submit' name='boton' value='Nueva Sesion'")
							.append("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		if(request.getParameter("boton").equals("Acceso")) {
			Integer cont = (int) sesion.getAttribute("numEntradas");
			if(cont == null) {
				cont = 1;
			}
			else {
				cont++;
			}
			sesion.setAttribute("numEntradas", cont);
		}
		else if(request.getParameter("boton").equals("Nueva Sesion")){
			sesion = request.getSession(true);
			sesion.setAttribute("numEntradas", 1);
			
		}
		response.setContentType("text/html");
		response.getWriter().append("<form action='Ejercicio4' method='post'>")
							.append("<input type='submit' name='acceso' value='Acceso'> <input type='submit' name='nuevaSesion' value='Nueva Sesión'")
							.append("</form>");
		String respuesta = ( (int) sesion.getAttribute("numEntradas") == 1)? "Es la primera vez que accede a la web" : "Desde la última vez ha accedido " + (int) sesion.getAttribute("numEntradas") +  " veces";
		response.getWriter().append("<h2>" + respuesta + "</h2>");
	}

}
