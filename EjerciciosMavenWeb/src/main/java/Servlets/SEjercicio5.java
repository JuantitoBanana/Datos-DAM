package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SEjercicio5
 */
@WebServlet("/SEjercicio5")
public class SEjercicio5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SEjercicio5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] asignaturasSeleccionadas = request.getParameterValues("asignaturas");
		String[] actividadesSeleccionadas = request.getParameterValues("checkActividades");
		response.setContentType("text/plain");
		response.getWriter().append("Asignaturas: ");
		if (asignaturasSeleccionadas != null) {
            for (String asignatura : asignaturasSeleccionadas) {
                response.getWriter().append(asignatura+ " ");
            }
        } else {
            response.getWriter().append("No has seleccionado ninguna");
        }
		response.getWriter().append("\nSexo: " + request.getParameter("genero") + "\n");
		response.getWriter().append("Actividades Extraescolares: ");
		
		if (actividadesSeleccionadas != null) {
            for (String actividad : actividadesSeleccionadas) {
                response.getWriter().append(actividad+ " ");
            }
        } else {
            response.getWriter().append("No has seleccionado ninguna");
        }
	}

}
