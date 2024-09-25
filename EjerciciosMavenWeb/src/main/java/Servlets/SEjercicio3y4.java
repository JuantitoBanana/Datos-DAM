package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Pojo.Persona;

/**
 * Servlet implementation class SEjercicio3
 */
@WebServlet("/SEjercicio3")

public class SEjercicio3y4 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SEjercicio3y4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		Map<String, String[]> parametros = request.getParameterMap();
		
		response.getWriter().append("<html><body>");
        response.getWriter().append("<table border='1'>");
        response.getWriter().println("<tr><th>Campo</th><th>Valor</th></tr>");
        /*
        response.getWriter().append("<tr><th>Nombre</th><th>Apellidos</th><th>Dirección</th><th>Tarjeta</th><th>Número de tarjeta</th></tr>");
        response.getWriter().append("<tr>");
        response.getWriter().append("<td>" + request.getParameter("nombre") + "</td>");
        response.getWriter().append("<td>" + request.getParameter("apellidos") + "</td>");
        response.getWriter().append("<td>" + request.getParameter("direccion") + "</td>");
        response.getWriter().append("<td>" + request.getParameter("tipoTarjeta") + "</td>");
        response.getWriter().append("<td>" + request.getParameter("numeroTarjeta") + "</td>");
        response.getWriter().append("</tr>");
        */
        
        for (Map.Entry<String, String[]> entry : parametros.entrySet()) {
            String nombreCampo = entry.getKey();        // Nombre del campo (clave)
            String[] valoresCampo = entry.getValue();   // Valores asociados al campo (en caso de múltiple selección)

            // Mostrar todos los valores (en caso de ser un campo múltiple, como checkboxes o selects múltiples)
            for (String valor : valoresCampo) {
                response.getWriter().println("<tr>");
                response.getWriter().println("<td>" + nombreCampo + "</td>");
                response.getWriter().println("<td>" + valor + "</td>");
                response.getWriter().println("</tr>");
            }
        }

        
        response.getWriter().append("</table>");
        response.getWriter().append("</body></html>");
	}

}
