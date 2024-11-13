package ArchivosJava;

import java.util.HashMap;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Evento
 *
 */
@WebListener
public class Evento implements HttpSessionListener, ServletContextListener {

    /**
     * Default constructor. 
     */
    public Evento() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	HashMap<String, String> listaPerfiles = new HashMap();
    	listaPerfiles.put("C1A", "Programador Senior");
    	listaPerfiles.put("C1B", "Programador Junior");
    	listaPerfiles.put("C2A", "Analista");
    	listaPerfiles.put("C2B", "Analista-Programador");
    	listaPerfiles.put("C3", "Jefe de Proyecto");
    	sce.getServletContext().setAttribute("listaPerfiles", listaPerfiles);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
