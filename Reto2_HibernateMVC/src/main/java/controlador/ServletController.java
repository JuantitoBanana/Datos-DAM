package controlador;

import java.io.IOException;

import dao.RegistrosDAO;
import entities.Registros;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ln.RegistrosLN;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletController() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boton = request.getParameter("boton");
		String page = "";
		boolean validacion = false;
		
		switch (boton) {
			case "Grabar":{
				String dni = request.getParameter("dni");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String tramite = request.getParameter("tramite");
				String entidad = request.getParameter("entidad");
				
				if(dni.isBlank() || nombre.isBlank() || apellidos.isBlank() || tramite.isBlank()) {
					validacion = false;
				}else {
					validacion = true;
					
					Registros registro = new Registros(dni, nombre, apellidos, tramite, entidad);
					registro.setNumRegistro("REG_" + nombre.substring(0, 2).toUpperCase() + apellidos.substring(0, 2).toUpperCase() + dni.substring(dni.length()-3));
					request.setAttribute("numRegistro", registro.getNumRegistro());
					String mensaje = "";
					try {
						mensaje = RegistrosLN.alta(registro);
					} catch (Exception e) {
						e.printStackTrace();
					}
					request.setAttribute("mensaje", mensaje);
				}
				request.setAttribute("validacion", validacion);
				page = "mensaje.jsp";
			}break;
			case "Nuevo Registro":{
				page = "registro.jsp";
			}break;
			case "Consulta Registro":{
				page = "buscar.jsp";
			}break;
			case "Buscar":{
				String numRegistro = request.getParameter("numRegistro");
				try {
					Registros registro = (Registros) RegistrosDAO.select(numRegistro);
					
					if(registro == null) {
						validacion = false;
					}else {
						validacion = true;
						request.setAttribute("dni", registro.getDni());
						request.setAttribute("nombre", registro.getNombre());
						request.setAttribute("apellidos", registro.getApellidos());
						request.setAttribute("tramite", registro.getTramite());
						request.setAttribute("entidad", registro.getEntidad());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("validacion", validacion);
				page = "consultar.jsp";
			}break;
		
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
