package com.gf.webapp.empresa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gf.webapp.empresa.entities.Empleado;
import com.gf.webapp.empresa.resources.ConexionBD;


public class EmpleadoDAO {
	
	public static List<Empleado> select() throws SQLException, ClassNotFoundException{
		String sql = "SELECT * FROM empresa.empleados";
		List<Empleado> empleados = new ArrayList<>();
		try (Connection conn = ConexionBD.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Empleado empleado = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),rs.getString(6));
				empleados.add(empleado);
			}

		}
		return empleados;
	}
}
