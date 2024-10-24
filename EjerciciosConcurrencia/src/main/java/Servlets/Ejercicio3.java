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
 * Servlet implementation class Ejercicio3
 */
@WebServlet("/Ejercicio3")
public class Ejercicio3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio3() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession(true);

        String usuario = request.getParameter("usuario");

        if (usuario != null && sesion.getAttribute("usuario") == null) {
            sesion.setAttribute("usuario", usuario);
        }

        String usuarioSesion = (String) sesion.getAttribute("usuario");
        String idSesion = sesion.getId();
        Date fechaCreacion = new Date(sesion.getCreationTime());
        Date fechaUltimoAcceso = new Date(sesion.getLastAccessedTime());

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Información de la sesión</h1>");
        response.getWriter().println("<p>Usuario: " + usuarioSesion + "</p>");
        response.getWriter().println("<p>Id de la sesión: " + idSesion + "</p>");
        response.getWriter().println("<p>Fecha creación sesión: " + fechaCreacion + "</p>");
        response.getWriter().println("<p>Fecha último acceso: " + fechaUltimoAcceso + "</p>");
        response.getWriter().println("</body></html>");
    }

}
