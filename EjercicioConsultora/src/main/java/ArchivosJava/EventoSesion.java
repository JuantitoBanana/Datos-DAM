package ArchivosJava;

import java.util.Date;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class EventoSesion
 *
 */
@WebListener
public class EventoSesion implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public EventoSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession sesion = se.getSession();
    	sesion.setAttribute("fechaCreacion", new Date(System.currentTimeMillis()).toString());
    	sesion.setAttribute("identificadorSesion", sesion.getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
