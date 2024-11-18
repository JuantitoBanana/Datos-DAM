package ArchivosJava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Servlet implementation class ServletIncidencia
 */
@WebServlet("/ServletIncidencia")
public class ServletIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Incidencia> incidencias = new ArrayList<>();
    private Random gen =  new Random();
    /**
     * Default constructor. 
     */
    public ServletIncidencia() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tema = request.getParameter("tema");
        String descripcion = request.getParameter("descripcion");

        if (tema == null || tema.isEmpty() || descripcion == null || descripcion.isEmpty()) {
        	request.setAttribute("error", "El tema y la descripción son obligatorios.");
            request.getRequestDispatcher("AltaIncidencia.jsp").forward(request, response);
        }else {
        	int codigo;
            do {
                codigo = gen.nextInt(1, 21);
            } while (existeCodigo(codigo));

            Incidencia nuevaIncidencia = new Incidencia(codigo, tema, descripcion);
            incidencias.add(nuevaIncidencia);

            HttpSession sesion = request.getSession();
            sesion.setAttribute("codigoGenerado", codigo);
            sesion.setAttribute("incidencias", incidencias);

            request.getRequestDispatcher("AltaIncidencia.jsp").include(request, response);
        }
    }
    
    private boolean existeCodigo(int codigo) {
        for(Incidencia incidencia : incidencias) {
        	if (incidencia.getCodigo() == codigo)
        		return true;
        }
    	return false;
    }

}
