package ArchivosJava;

public class Votacion {
	private String nombre;
	private int numeroVotos;

	public Votacion(String nombre, int numeroVotos) {
		this.nombre = nombre;
		this.numeroVotos = numeroVotos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumeroVotos() {
		return numeroVotos;
	}

	public void setNumeroVotos(int numeroVotos) {
		this.numeroVotos = numeroVotos;
	}
}
