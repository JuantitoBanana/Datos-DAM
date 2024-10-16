package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio9
 */
@WebServlet("/Ejemplo9")
public class Ejemplo9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletContext sc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sc = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<form action='Ejemplo9' method='post'>")
							.append("<h1>PROBANDO DESPACHADOR</h1>")
							.append("<input type='submit' name='metodo' value='include'>")
							.append("<input type='submit' name='metodo' value='forward'>")
							.append("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html><body style='background-color:#AAFF9F'>")
							.append("<h3>Ejemplo de RequestDispatcher</h3>")
							.append("<p>Este servlet usa un despachador que nos lleva a un servlet</p>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Ejemplo9b");
		if(dispatcher != null) {
			if(request.getParameter("metodo").equalsIgnoreCase("include")) {
				dispatcher.include(request, response);
			} else {
				dispatcher.forward(request, response);
			}
			response.getWriter().append("<p>Vuelta del servlet despachador</p>");
		} else {
			response.getWriter().append("<p>No se encontro el despachador</p>");
		}
		response.getWriter().append("</body></html>");
	}

}
