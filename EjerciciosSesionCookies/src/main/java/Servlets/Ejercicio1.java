package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Ejercicio1
 */
@WebServlet("/Ejercicio1")
public class Ejercicio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		int factura = 0;
		response.setContentType("text/html");
		
		
		HttpSession sesion = request.getSession(true);
		if(sesion.getAttribute("factura") != null) {
			factura = (int) sesion.getAttribute("factura");
		} else {
			sesion.setAttribute("factura", factura);
		}
		
		
		response.getWriter().append("<html><body><form method='get'>")
							.append("<input type='submit' value='A'>")
							.append("<input type='submit' value='B'>")
							.append("<input type='submit' value='C'>")
							.append("<input type='submit' value='D'>")
							.append("</form></html></body>");
	}

}
