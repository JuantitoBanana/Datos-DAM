package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class Ejercicio3b
 */
@WebServlet("/Ejercicio3b")
public class Ejercicio3b extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio3b() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HashMap<String, String> libros = getServletContext().getAttribute("listaLibros")!=null?(HashMap<String, String>) getServletContext().getAttribute("listaLibros"): new HashMap<String, String>();
		//Vector de cookies
		Cookie cs[] = request.getCookies();
		Double suma = 0.0;
		if(cs != null) {
			response.getWriter().append("<h1>Compra total</h1><table border='1'>")
								.append("<tr><td>Título de libros</td><td>Unidades</td><td>Precio</td></tr>");
							for (Cookie cookie : cs) {
								response.getWriter().append("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td><td>" + libros.get(cookie.getName()) + "</td></tr>");
								suma += (Double.parseDouble(cookie.getValue())) * Double.parseDouble(libros.get(cookie.getName()));
								cookie.setMaxAge(0);
								response.addCookie(cookie);
							}
			response.getWriter().append("</table>");
			response.getWriter().append("<h2>Total: " + suma + "</h2>");
		}
		else {
			response.getWriter().append("<h2>No seleccionó ningun libro.</h2>");
		}
		
	}
	

}
