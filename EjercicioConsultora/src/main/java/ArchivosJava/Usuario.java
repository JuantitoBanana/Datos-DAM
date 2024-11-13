package ArchivosJava;

public class Usuario {

	private String nombre;
	private String contrasena;
	private String categoria;
	private String perfil;
	public Usuario(String nombre, String contrasena, String categoria, String perfil) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.categoria = categoria;
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
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
}
