package Servlets;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SEjercicio2
 */
@WebServlet("/SEjercicio2")
public class SEjercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SEjercicio2() {
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		config.getServletContext().setAttribute("Error", "<h3>No has elegido ninguna tabla. Elige una tabla por favor.</h3>");
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tabla = request.getParameter("tabla");
        
        if (tabla.equals("Elije una tabla")) {
            request.getRequestDispatcher("SEjercicio2Error").forward(request, response);
        } else {
            request.getRequestDispatcher("SEjercicio2Tabla").forward(request, response);
        }
	}

}
