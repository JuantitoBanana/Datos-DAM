package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    
    private Object lock = new Object();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
    	String numero = request.getParameter("numero");
        if (numero != null) {
            try {
                int number = Integer.parseInt(numero);
                synchronized (lock) {
                    getServletContext().setAttribute("numeroContexto", number);
                }
                Thread.sleep(10000);

                request.getRequestDispatcher("Ejercicio1b").forward(request, response);

            } catch (Exception e) {
                response.getWriter().append("Error: Número inválido o interrupción en la espera.");
            }
        } else {
            response.getWriter().append("Por favor, proporciona un número en la URL.");
        }
    }
}
