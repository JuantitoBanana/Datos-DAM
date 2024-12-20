package com.gf.webapp.empresa.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.gf.webapp.empresa.dao.EmpleadoDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEmpleados
 */
@WebServlet("/ServletEmpleados")
public class ServletEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletEmpleados() {
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
