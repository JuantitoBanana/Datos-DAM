package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SEjercicio14
 */
@WebServlet("/SEjercicio14")
public class SEjercicio14 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SEjercicio14() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain");
		
		String saludo = request.getParameter("mensaje");
        String firma = request.getParameter("firma");
        
        if(saludo == null || firma == null)
        	response.getWriter().append("No has introducido los datos correctamente");
        else {
        	response.getWriter().append("Mensaje: " + saludo + "\n")
        	.append("Firma: " + firma);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		
		String saludo = request.getParameter("mensaje");
        String firma = request.getParameter("firma");
        
        response.getWriter().append("Mensaje: " + saludo + "\n");
        response.getWriter().append("Firma: " + firma);
		
	}

}
