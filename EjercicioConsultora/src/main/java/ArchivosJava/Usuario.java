package ArchivosJava;

public class Usuario {

	private String nombre;
	private String contrasena;
	private String perfil;
	public Usuario(String nombre, String contrasena, String perfil) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.perfil = perfil;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
