package Servlets;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio1b() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/plain");
    	synchronized (getServletContext()) {
            Integer numero = (int) getServletContext().getAttribute("numeroContexto");  
            String mensaje = (numero != null)?"El número almacenado es: " + numero : "No hay número almacenado.";
            response.getWriter().append(mensaje);
        }
    }
}
