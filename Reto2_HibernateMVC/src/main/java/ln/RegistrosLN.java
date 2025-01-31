package ln;

import dao.RegistrosDAO;
import entities.Registros;



public class RegistrosLN {
	public static String alta(Registros r) throws Exception {
		String mensaje = "";
		if(RegistrosDAO.select(r) == null) {
			RegistrosDAO.insert(r);
			mensaje = "La grabación se ha realizado correctamente en registro. Guarde el siguiente número de registro:";
		} else {
			mensaje = "El registro ya existe.";
		}
		return mensaje;
	}
}
