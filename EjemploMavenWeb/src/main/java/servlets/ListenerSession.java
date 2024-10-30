package servlets;

import java.util.Date;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerSession
 *
 */
@WebListener
public class ListenerSession implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ListenerSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession sesion = se.getSession();
         System.out.println("A las " + new Date(System.currentTimeMillis()).toString() 
        		 + " se creó la sesión con el ID: " + sesion.getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession sesion = se.getSession();
        System.out.println("A las " + new Date(System.currentTimeMillis()).toString() 
       		 + " se cerro la sesión con el ID: " + sesion.getId());
    }
	
}
