package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class Ejercicio3b
 */
@WebServlet("/Ejercicio3b")
public class Ejercicio3b extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio3b() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Object lock = new Object();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession(true);

        synchronized (lock) {
            String usuario = request.getParameter("usuario");

            if (usuario != null && sesion.getAttribute("usuario") == null) {
                sesion.setAttribute("usuario", usuario);
            }

            String usuarioSesion = (String) sesion.getAttribute("usuario");
            String idSesion = sesion.getId();
            Date fechaCreacion = new Date(sesion.getCreationTime());
            Date fechaUltimoAcceso = new Date(sesion.getLastAccessedTime());

            response.setContentType("text/html");
            response.getWriter().append("<html><body>");
            response.getWriter().append("<h1>Información de la sesión</h1>");
            response.getWriter().append("<p>Usuario: " + usuarioSesion + "</p>");
            response.getWriter().append("<p>Id de la sesión: " + idSesion + "</p>");
            response.getWriter().append("<p>Fecha creación sesión: " + fechaCreacion + "</p>");
            response.getWriter().append("<p>Fecha último acceso: " + fechaUltimoAcceso + "</p>");
            response.getWriter().append("</body></html>");
        }
    }

}
