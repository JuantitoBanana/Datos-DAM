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
@WebServlet("/SEjercicio11")
public class SEjercicio11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SEjercicio11() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		String saluda = request.getParameter("saludo")!=null?"HOLA MUNDO":"NO HAY SALUDO";
		response.getWriter().append(saluda);
		if(!saluda.equals("HOLA MUNDO")) {
			switch((request.getParameter("idioma")!=null)?request.getParameter("idioma"):" ") {
				case "espaniol":
					response.getWriter().append("Hola Mundo");
					break;
				case "ingles":
					response.getWriter().append("Hello World");
					break;	
				case "italiano":
					response.getWriter().append("Ciao Monde");
					break;
		
				case "frances":
					response.getWriter().append("Bonjour Monde");
					break;
		
			}
		}
		 
		
	}

}
