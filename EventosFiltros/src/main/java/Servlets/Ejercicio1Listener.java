package Servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Ejercicio1Listener
 *
 */
@WebListener
public class Ejercicio1Listener implements ServletContextListener {

	private static final String FICHERO_TAREAS = "tareas.dat";
	
    /**
     * Default constructor. 
     */
    public Ejercicio1Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	HashMap<String, String> notificaciones = cargarTareas();
        sce.getServletContext().setAttribute("notificaciones", notificaciones);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	HashMap<String, String> notificaciones = (HashMap<String, String>) sce.getServletContext().getAttribute("notificaciones");
        guardarTareas(notificaciones);
    }
	
    private void guardarTareas(HashMap<String, String> tareas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_TAREAS))) {
            oos.writeObject(tareas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private HashMap<String, String> cargarTareas() {
        File fichero = new File(FICHERO_TAREAS);
        if (!fichero.exists()) {
            return new HashMap<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            return (HashMap<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }   
}
