package Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Ejercicio7
 */
@WebServlet("/Ejercicio7")
public class Ejercicio7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio7() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		config.getServletContext().setAttribute("Fiebre", 0);
		config.getServletContext().setAttribute("Tos Seca", 0);
		config.getServletContext().setAttribute("Diarrea", 0);
		config.getServletContext().setAttribute("Perdida de Olfato", 0);
		config.getServletContext().setAttribute("Dolor Muscular", 0);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<form method='post'><fieldset><legend>Test Covid-19</legend>")
							.append("<input type='checkbox' name='sintomas' value='Fiebre'>Fiebre<br>")
							.append("<input type='checkbox' name='sintomas' value='Tos Seca'>Tos Seca<br>")
							.append("<input type='checkbox' name='sintomas' value='Diarrea'>Diarrea<br>")
							.append("<input type='checkbox' name='sintomas' value='Perdida de Olfato'>Perdida de Olfato<br>")
							.append("<input type='checkbox' name='sintomas' value='Dolor Muscular'>Dolor Muscular<br>")
							.append("<input type='submit' value='Enviar'")
							.append("</fieldset></form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String [] listaSintomas = request.getParameterValues("sintomas");
		String [] sintomas = {"Fiebre", "Tos Seca", "Diarrea", "Perdida de Olfato", "Dolor Muscular"};
		boolean verificacion = false;
		Cookie [] cs = request.getCookies();
		if(cs != null) {
			for (int i = 0; i < cs.length && !verificacion ; i++) {
				if(cs[i].getName().equals("formularioRealizado")) {
					verificacion = true;
				}
			}
		}
		if(!verificacion) {
			Cookie c = new Cookie("formularioRealizado", "");
			response.addCookie(c);
			for (int i = 0; i < listaSintomas.length; i++) {
				if(listaSintomas[i].equals("Fiebre")) {
					int cont = (int) getServletContext().getAttribute("Fiebre");
					cont++;
					getServletContext().setAttribute("Fiebre", cont);
				}
				if(listaSintomas[i].equals("Tos Seca")) {
					int cont = (int) getServletContext().getAttribute("Tos Seca");
					cont++;
					getServletContext().setAttribute("Tos Seca", cont);
				}
				if(listaSintomas[i].equals("Diarrea")) {
					int cont = (int) getServletContext().getAttribute("Diarrea");
					cont++;
					getServletContext().setAttribute("Diarrea", cont);
				}
				if(listaSintomas[i].equals("Perdida de Olfato")) {
					int cont = (int) getServletContext().getAttribute("Perdida de Olfato");
					cont++;
					getServletContext().setAttribute("Perdida de Olfato", cont);
				}
				if(listaSintomas[i].equals("Dolor Muscular")) {
					int cont = (int) getServletContext().getAttribute("Dolor Muscular");
					cont++;
					getServletContext().setAttribute("Dolor Muscular", cont);
				}
			}
			response.getWriter().append("<table border='1'>")
								.append("<tr><td>Síntomas</td><td>Número Personas</td></tr>");
			for (int i = 0; i < sintomas.length; i++) {
				response.getWriter().append("<tr><td>" + sintomas[i] + "</td><td>" + getServletContext().getAttribute(sintomas[i]) + "</td></tr>");
			}
			response.getWriter().append("</table><br>")
								.append("<a href='Ejercicio7'>Volver</a>");
			
		}else {
			
			response.getWriter().append("<table border='1'>")
								.append("<tr><td>Síntomas</td><td>Número Personas</td></tr>");
			for (int i = 0; i < sintomas.length; i++) {
				response.getWriter().append("<tr><td>" + sintomas[i] + "</td><td>" + getServletContext().getAttribute(sintomas[i]) + "</td></tr>");
			}
			response.getWriter().append("</table><br>")
								.append("Usted ya ha realizado el test. No puede repetirlo.<br>")
								.append("<a href='Ejercicio7'>Volver</a>");
		}
	}
}
