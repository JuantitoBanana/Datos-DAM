package com.gf.webapp.matriculas.ln;

import java.sql.SQLException;

import com.gf.webapp.matriculas.dao.AlumnoDAO;
import com.gf.webapp.matriculas.entities.Alumno;

public class AlumnoLN {

	public static String alta(Alumno a) throws SQLException {

		if (AlumnoDAO.select(a) == null) {
			AlumnoDAO.insert(a);
			return "El alumno s eha guardado correctamente.";
		} else {
			return "El alumno ya existe.";
		}

	}

}
