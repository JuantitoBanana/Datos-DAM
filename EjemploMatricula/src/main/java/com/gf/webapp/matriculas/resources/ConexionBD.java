package com.gf.webapp.matriculas.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import jakarta.servlet.annotation.*;

@Resource(name="jdbc/miDataSource")
public class ConexionBD {

	private static Connection conn;
	public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException {
		/*
		 * Método 1
		 * 
		Context initContext =  new InitialContext(); //JNDI
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/miDataSource");
		return ds.getConnection();
		*/
		return ((DataSource) new InitialContext().lookup("java:/comp/env/jdbc/miDataSource")).getConnection();
		//Class.forName("com.mysql.cj.jbdc.Driver");
		//return DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculas", "root", "");
	}

}
