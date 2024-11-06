package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Servlet implementation class Ejercicio1
 */
@WebServlet("/Ejercicio1")
public class Ejercicio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map <String, String> notificaciones = new HashMap<String, String>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html><body><form method='get'>")
							.append("<label>Tarea: </label><input type='text' name='idTarea'><br>")
							.append("<label>Descripción: </label><input type='text' name='descripcion'><br>")
							.append("<input type='submit' value='Enviar'>")
							.append("</form></body></html>");
		 
		notificaciones.put(request.getParameter("idTarea"), request.getParameter("descripcion"));
		getServletContext().setAttribute("notificaciones", notificaciones);
		if(getServletContext().getAttribute("notificaciones") != null) {
			notificaciones = (Map) getServletContext().getAttribute("notificaciones");
			StringBuilder datos = new StringBuilder();
			for(Entry<String, String> entry : notificaciones.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				datos.append(key);
				datos.append("|");
				datos.append(val);
				datos.append("<br>");
			}
			response.getWriter().append(datos);
		}
		
		
		}

}
