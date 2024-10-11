package Servlets;

public class Libro {

	private String nombre;
	private int numUnidades;
	
	public Libro(String nombre, int numUnidades) {
		this.nombre = nombre;
		this.numUnidades = numUnidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumUnidades() {
		return numUnidades;
	}

	public void setNumUnidades(int numUnidades) {
		this.numUnidades = numUnidades;
	}
	
}
