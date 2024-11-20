package Servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Servlet implementation class ServletCotizacion
 */
@WebServlet("/ServletCotizacion")
public class ServletCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String PIN_ACCESO = "123456";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCotizacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context =  getServletContext();
		String page = "";
		switch (request.getParameter("boton")) {
			case "Acceso": {
				String nombre = request.getParameter("nombre");
				String pin = request.getParameter("pin");
				if(!nombre.isBlank() && !pin.isBlank()) {
					if(pin.equals(PIN_ACCESO)) {
						HttpSession sesion = request.getSession(true);
						sesion.setAttribute("nombreUsuario", nombre);
						sesion.setAttribute("fechaCreacion", LocalDate().now());
						page = "Cotizacion.jsp";
					}else {
						request.setAttribute("errorCredenciales", true);
						page = "Acceso.jsp";
					}
				} else {
					request.setAttribute("errorBlanco", true);
					page = "Acceso.jsp";
				}
			}break;
			
			case "Enviar":{
				for(String s :request.getParameterValues("valoresNuevos")){
					System.out.println(s);
				}
				page = "ConsultaCotizacion.jsp";
			}break;
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	private LocalDate LocalDate() {
		// TODO Auto-generated method stub
		return null;
	}
}
