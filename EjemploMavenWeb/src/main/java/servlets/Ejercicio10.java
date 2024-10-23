package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio10
 */
@WebServlet("/Ejercicio10")
public class Ejercicio10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int val = 0;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public synchronized void prueba(HttpServletRequest request, HttpServletResponse response) {
    	val = Integer.parseInt(request.getParameter("param"));
		//Mostrar el proceso que se está ejecutando
		System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor " + val);
		
		//Simulación operativa antes de volver a utilizar la variable
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Mostrar el proceso que se está ejecutando
		System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor " + val);
    }
    private final Object lock = new Object();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Opción 1
		int val = Integer.parseInt(request.getParameter("param"));
		//Mostrar el proceso que se está ejecutando
		System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor " + val);
		
		//Simulación operativa antes de volver a utilizar la variable
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Mostrar el proceso que se está ejecutando
		System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor " + val);
		*/
		
		/*Opción 2
		System.out.println("Comienzo de la sincronización...");
		prueba(request, response);
		System.out.println("Final de la sincronización...");
		*/
		
		try {
			synchronized (lock) {
				
			
			val = Integer.parseInt(request.getParameter("param"));
			//Mostrar el proceso que se está ejecutando
			System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor " + val);
			
			//Simulación operativa antes de volver a utilizar la variable
				Thread.sleep(10000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Mostrar el proceso que se está ejecutando
		System.out.println("Thread: " + Thread.currentThread().getName() + " usa el valor " + val);
		
	}


}
