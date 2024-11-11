package ArchivosJava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletVotacion
 */
@WebServlet("/ServletVotacion")
public class ServletVotacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int votosRuth = 0;
	private int votosVictor = 0;
	private int votosBlancos = 0;
	private int numeroVotaciones = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVotacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] candidatos = request.getParameterValues("candidato");

		numeroVotaciones++;
		if (numeroVotaciones >= 6) {
			numeroVotaciones = 0;
			votosRuth = 0;
			votosVictor = 0;
			votosBlancos = 0;
		}

		if (candidatos == null) {
			votosBlancos++;
		} else {
			for (String candidato : candidatos) {
				if (candidato.equals("Ruth Fernández")) {
					votosRuth++;
				} else if (candidato.equals("Victor Vergel")) {
					votosVictor++;
				}
			}
		}

		getServletContext().setAttribute("votosRuth", votosRuth);
		getServletContext().setAttribute("votosVictor", votosVictor);
		getServletContext().setAttribute("votosBlancos", votosBlancos);
		request.getRequestDispatcher("Resultados.jsp").forward(request, response);
	}

}
