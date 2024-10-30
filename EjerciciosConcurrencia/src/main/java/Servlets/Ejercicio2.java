package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class Ejercicio2
 */
@WebServlet("/Ejercicio2")
public class Ejercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int valor = 0;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Object lock = new Object();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random random = new Random();
        
        int[] numerosAleatorios = new int[10];

        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = random.nextInt(100) + 1;
        }

        synchronized (lock) {
            for (int numero : numerosAleatorios) {
                valor += numero;
            }

            for (int numero : numerosAleatorios) {
                valor -= numero;
            }
        }

        response.setContentType("text/html");
        response.getWriter().append("<html><body>");
        response.getWriter().append("<h1>El valor final es: " + valor + "</h1>");
        response.getWriter().append("</body></html>");
    }

}
