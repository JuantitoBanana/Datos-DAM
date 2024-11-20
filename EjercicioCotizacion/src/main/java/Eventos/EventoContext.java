package Eventos;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EventoContext
 *
 */
@WebListener
public class EventoContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EventoContext() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         Map<String, Double> mapaValores =  new HashMap<String, Double>();
         mapaValores.put("TURISMO", 19.5);
         mapaValores.put("FARMACIA", 35.6);
         mapaValores.put("DAM", 48.5);
         mapaValores.put("ATENCION", 30.5);
         mapaValores.put("VENTAS", 20.5);
         sce.getServletContext().setAttribute("mapaValores", mapaValores);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
