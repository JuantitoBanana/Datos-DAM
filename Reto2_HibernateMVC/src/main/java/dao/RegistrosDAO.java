package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Registros;
import utils.HibernateUtils;

public class RegistrosDAO {
	public static void insert(Registros r) {
		try(Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			Transaction tr = sesion.beginTransaction();
			sesion.save(r);
			tr.commit();
		}
	}
	
	public static Registros select(Registros r) throws Exception {

		Transaction tr = null;
		Registros registro=null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();	
			registro=sesion.get(Registros.class,r.getNumRegistro());
			tr.commit();
			return registro;
		}
		
	}
		
		public static Registros select(String numRegistro) throws Exception {

			Transaction tr = null;
			Registros registro=null;
			try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
				tr = sesion.beginTransaction();	
				registro=sesion.get(Registros.class,numRegistro);
				tr.commit();
				return registro;
			}
	}
}
