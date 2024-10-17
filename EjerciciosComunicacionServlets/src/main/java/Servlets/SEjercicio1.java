package Servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio1
 */
@WebServlet("/SEjercicio1")
public class SEjercicio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public SEjercicio1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clave = request.getParameter("clave");
        
        if (clave.equals("admin")) {
            request.getRequestDispatcher("SEjercicio1Bienvenida").forward(request, response);
        } else {
            request.getRequestDispatcher("SEjercicio1Error").forward(request, response);
        }
	}

}
