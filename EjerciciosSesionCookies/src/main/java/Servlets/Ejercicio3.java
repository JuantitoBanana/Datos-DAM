package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Ejercicio3
 */
@WebServlet("/Ejercicio3")
public class Ejercicio3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> libros = new HashMap<String, String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		libros.put("C", "56.00");
		libros.put("C++", "63.00");
		libros.put("VB", "52.00");
		libros.put("Python", "46.00");
		libros.put("Java", "67.00");
		config.getServletContext().setAttribute("listaLibros", libros);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.getWriter().append("<h2>Bienvenido a Web Librería. Seleccione el libro</h2>")
							.append("<h4>Listado de libros:</h4>")
							.append("<form method='post'>")
							.append("<select name='libroSeleccionado'");
							libros.forEach((k,v) -> {
								try {
									response.getWriter().append("<option value='" + k + "'>" + k + "</option>");
								} catch (Exception e) {}
							});
		response.getWriter().append("</select>")
							.append("<h4>Unidades:</h4>")
							.append("<input type='text' name='ud'> <input type='submit' value='Enviar'>")
							.append("</form>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		if(!request.getParameter("ud").equals("") && !request.getParameter("ud").equals("0")) {
			//Crear Cookie con las unidades seleccionadas
			Cookie c = new Cookie(request.getParameter("libroSeleccionado"), request.getParameter("ud"));
			response.addCookie(c);
			response.getWriter().append("<h2>Bienvenido a Web Librería. Usted seleccionó " + request.getParameter("libroSeleccionado") + "</h2>");
		} else response.getWriter().append("<h2>No ha seleccionado ningún libro.</h2>");
		
		response.getWriter().append("<a href='Ejercicio3'>Sigue Comprando</a> <a href='Ejercicio3b'>Ver carrito");
		
	}

	

	
}
