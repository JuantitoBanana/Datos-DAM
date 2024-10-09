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
    private int factura = 0; 
    private int resultado = 0;
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
		
		
		HttpSession sesion = request.getSession(true);
		if(sesion.getAttribute("factura") != null) {
			factura = (int) sesion.getAttribute("factura");
		} else {
			sesion.setAttribute("factura", factura);
		}
		
		if(request.getParameter("boton") != null) {
			switch (request.getParameter("boton")) {
			case "A": {
				factura += 3;
				resultado = 3;
				sesion.setAttribute("factura", factura);
				break;
			}
			case "B": {
				factura += 4;
				resultado = 4;
				sesion.setAttribute("factura", factura);
				break;
			}
			case "C": {
				factura += 5;
				resultado = 5;
				sesion.setAttribute("factura", factura);
				break;
			}
			case "D": {
				factura += 1;
				resultado = 1;
				sesion.setAttribute("factura", factura);
				break;
			}
			case "Ticket": {
				resultado = factura;
				break;
			}
			
		}
	}

		response.getWriter().append("<html><body>")
							.append("<h2>Tienda</h2>")
							.append("<label>" + resultado +"</label>")
							.append("<form method='get'>")
							.append("<input type='submit' name='boton' value='A'>")
							.append("<input type='submit' name='boton' value='B'>")
							.append("<input type='submit' name='boton' value='C'>")
							.append("<input type='submit' name='boton' value='D'><br>")
							.append("<input type='submit' name='boton' value='Ticket'>")
							.append("</form></body></html>");
	}
}
