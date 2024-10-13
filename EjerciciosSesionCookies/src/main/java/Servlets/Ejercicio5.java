package Servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Obtener el contexto de la aplicación
        ServletContext context = getServletContext();
        
        // Obtener el número aleatorio almacenado en el contexto (si existe)
        Integer numeroContexto = (Integer) context.getAttribute("numeroAleatorioContexto");
        
        // Si no hay número en el contexto, generarlo por primera vez
        if (numeroContexto == null) {
            numeroContexto = generarNumeroAleatorio();
            context.setAttribute("numeroAleatorioContexto", numeroContexto);
        }
        
        // Generar un nuevo número aleatorio para la comparación
        int numeroAleatorio = generarNumeroAleatorio();
        
        // Comparar los números y generar el mensaje adecuado
        String mensaje;
        if (numeroAleatorio == numeroContexto) {
            mensaje = "Aleatorio: " + numeroAleatorio + ". Contexto: " + numeroContexto + ". Números iguales.";
        } else {
            mensaje = "Aleatorio: " + numeroAleatorio + ". Contexto: " + numeroContexto + ". Números distintos.";
        }
        
        // Actualizar el valor del número en el contexto
        context.setAttribute("numeroAleatorioContexto", numeroAleatorio);
        
        // Enviar la respuesta al cliente
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + mensaje + "</h1>");
        out.println("</body></html>");
    }
    
    // Método auxiliar para generar un número aleatorio entre 1 y 10
    private int generarNumeroAleatorio() {
        return (int) (Math.random() * 10) + 1;
    }

}
