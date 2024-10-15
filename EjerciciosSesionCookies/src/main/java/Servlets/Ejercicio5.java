package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio5
 */
@WebServlet("/Ejercicio5")
public class Ejercicio5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
        Integer numeroContexto = (Integer) getServletContext().getAttribute("numeroAleatorioContexto");
        
        if (numeroContexto == null) {
            numeroContexto = (int)(Math.random() * 10) + 1;
            getServletContext().setAttribute("numeroAleatorioContexto", numeroContexto);
        }
        
        int numeroAleatorio = (int)(Math.random() * 10) + 1;
        
        String mensaje = (numeroAleatorio == numeroContexto)? "Aleatorio: " + numeroAleatorio + ". Contexto: " + numeroContexto + ". Números iguales." :"Aleatorio: " + numeroAleatorio + ". Contexto: " + numeroContexto + ". Números distintos.";
        
        getServletContext().setAttribute("numeroAleatorioContexto", numeroAleatorio);

        response.getWriter().append("<h1>" + mensaje + "</h1>");
    }
    

}
