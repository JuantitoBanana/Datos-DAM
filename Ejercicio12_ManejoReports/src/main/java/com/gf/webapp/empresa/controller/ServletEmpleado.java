package com.gf.webapp.empresa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.gf.webapp.empresa.dao.EmpleadoDAO;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Llega a post");
		String page = "";
		switch (request.getParameter("boton")) {
			case "Consultar": {
				try {
					getServletContext().setAttribute("listaEmpleados", EmpleadoDAO.select());
					page = "Mensaje.jsp";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} break;
			
			case "Listar": {
				page = "datosEmpleados.jsp";
			} break;
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
