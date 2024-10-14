package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio6
 */
@WebServlet("/Ejercicio6")
public class Ejercicio6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<h1>Ñam Ñam Galletas</h1>")
							.append("<form method='post'><fieldset>")
							.append("<label>Qué galleta quieres?</label> <input type='text' name='nombreGalleta'><br>")
							.append("<input type='radio' name='cookies' value='mostrar'><label>Mostrar galletas</label>")
							.append("<input type='radio' name='cookies' value='cocinar'><label>Cocinar galletas</label>")
							.append("<input type='radio' name='cookies' value='comer'><label>Comer galletas</label><br>")
							.append("<input type='submit' value='Oído Cocina'>")
							.append("</fieldset></form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Cookie [] listaCookies = request.getCookies();
		response.getWriter().append("<h1>Ñam Ñam Galletas</h1>");
		if(request.getParameter("cookies").equals("mostrar")) {
			if(listaCookies != null) {
				for (int i = 0; i < listaCookies.length; i++) {
					response.getWriter().append(listaCookies[i].getName() + "<br>");
				}
			}
		} else if(request.getParameter("cookies").equals("cocinar")) {
			Cookie c = new Cookie(request.getParameter("nombreGalleta"),"");
			response.addCookie(c);
			response.getWriter().append("La galleta " + request.getParameter("nombreGalleta") + " se ha cocinado.");
		} else if(request.getParameter("cookies").equals("comer")) {
			boolean flag = false;
			for (int i = 0; i < listaCookies.length && !flag; i++) {
				if(listaCookies[i].getName().equals(request.getParameter("nombreGalleta"))) {
					listaCookies[i].setMaxAge(0);
					response.addCookie(listaCookies[i]);
					response.getWriter().append("La galleta " + request.getParameter("nombreGalleta") + " ha sido comida.");
					flag = true;
				}
			}
		}
		response.getWriter().append("<br><a href='Ejercicio6'>Volver</a>");
	}

}
