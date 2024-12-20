package com.gf.webapp.empresa.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.gf.webapp.empresa.dao.EmpleadoDAO;
import com.gf.webapp.empresa.resources.ConexionBD;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

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
					try {
						getServletContext().setAttribute("listaEmpleados", EmpleadoDAO.select());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					page = "Mensaje.jsp";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} break;
			
			case "Listar": {
				JasperReport jasperReport= null;
				JasperPrint jasperPrint= null;
				Connection conn= null;
				
				try{
					conn= (Connection) ConexionBD.getConnection();
					jasperReport= JasperCompileManager.compileReport("/src/main/Resources/EmpleadosReport.jrxml");
					Map<String, Object> parameters= new HashMap<String, Object>();
					jasperPrint= JasperFillManager.fillReport(jasperReport, parameters, conn);
					
					File outDir= new File("D:/MisArchivos/EclipseAD/Reports");
					outDir.mkdir();
					JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/MisArchivos/EclipseAD/Reports/Ejercicio12.pdf");
					System.out.println("Documento creado!");
					JasperPrint jasperPrintWindow= JasperFillManager.fillReport("/src/main/Resources/Ejercicio12.jasper", null, conn);
					
					JasperViewer jasperViewer= new JasperViewer(jasperPrintWindow);
					jasperViewer.setVisible(true);
					
				}catch (JRException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					if(conn!=null) {
						try {
							conn.close();
						}catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				page = "datosEmpleados.jsp";
			} break;
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}
}
