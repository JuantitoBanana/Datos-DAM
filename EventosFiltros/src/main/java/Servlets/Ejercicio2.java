package Servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Servlet implementation class Ejercicio2
 */
@WebServlet("/Ejercicio2")
public class Ejercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Integer> ContadorVisitas = (Map<String, Integer>) getServletContext().getAttribute("ContadorVisitas");

        response.setContentType("text/html");

        response.getWriter().append("<html><body>");
        response.getWriter().append("<h1>Estadísticas de visitas</h1>");

        if (ContadorVisitas != null) {
            for (Map.Entry<String, Integer> entry : ContadorVisitas.entrySet()) {
            	response.getWriter().append("<p>" + entry.getKey() + " ha sido visitada " + entry.getValue() + " veces</p>");
            }
        } else {
        	response.getWriter().append("<p>No hay estadísticas disponibles.</p>");
        }

        response.getWriter().append("</body></html>");
    }

}
