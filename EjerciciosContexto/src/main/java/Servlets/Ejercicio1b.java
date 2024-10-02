package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio1b
 */
@WebServlet("/Ejercicio1b")
public class Ejercicio1b extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String paramColor = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio1b() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		paramColor = config.getServletContext().getInitParameter("color");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(getServletContext().getAttribute("color") != null) paramColor = getServletContext().getAttribute("color").toString();
		response.getWriter().append("El color es: " + paramColor);
	}

}
