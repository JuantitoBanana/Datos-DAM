package servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerContext
 *
 */
@WebListener
public class ListenerContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerContext() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("Aplicación arrancando el contexto..." + sce.getServletContext() 
        		+ "con el siguiente parametro inicial " + sce.getServletContext().getInitParameter("bbdd"));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	 System.out.println("Aplicación deteniendo el contexto..." + sce.getServletContext() 
 		+ "con el siguiente parametro inicial " + sce.getServletContext().getInitParameter("bbdd"));
    }
	
}
