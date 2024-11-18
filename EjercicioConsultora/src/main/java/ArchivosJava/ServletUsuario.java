package ArchivosJava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<String> perfiles =  new ArrayList<String>();
    private ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		getServletContext().setAttribute("nombre", nombre);
		String contrasena = request.getParameter("contrasena");
		getServletContext().setAttribute("contrasena", contrasena);
		perfiles.clear();
		
		if ( nombre.isBlank() || contrasena.isBlank()) {
        	getServletContext().setAttribute("error", true);
            getServletContext().getRequestDispatcher("/Registro.jsp").forward(request, response);
        }else {
        	HashMap<String, String> listaPerfiles = (HashMap<String, String>) getServletContext().getAttribute("listaPerfiles");
        	for(String key : listaPerfiles.keySet()) {
        		if(request.getParameter("categoriaProfesional").equals("I")) {
        			if(key.contains("C1")) {
        				perfiles.add(listaPerfiles.get(key));
        			}
        		} else if(request.getParameter("categoriaProfesional").equals("II")){
        			if(key.contains("C2")) {
        				perfiles.add(listaPerfiles.get(key));
        			}
        		} else {
        			if(key.contains("C3")) {
        				perfiles.add(listaPerfiles.get(key));
        			}
        		}
        	}
        	Usuario nuevoUsuario =  new Usuario(nombre, contrasena);
        	usuarios.add(nuevoUsuario);
        	
        	getServletContext().setAttribute("usuarios", usuarios);
        	getServletContext().setAttribute("perfiles", perfiles);
        	request.getRequestDispatcher("Acceso.jsp").forward(request, response);
        }
		
	}

}
