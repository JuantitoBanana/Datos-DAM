package Pojo;

public class Cotizacion {
	private String nombreCiclo;
	private double valorActual;
	private double valorNuevo;
	
	public Cotizacion(String nombreCiclo, double valorActual, double valorNuevo) {
		super();
		this.nombreCiclo = nombreCiclo;
		this.valorActual = valorActual;
		this.valorNuevo = valorNuevo;
	}

	public String getNombreCiclo() {
		return nombreCiclo;
	}

	public void setNombreCiclo(String nombreCiclo) {
		this.nombreCiclo = nombreCiclo;
	}

	public double getValorActual() {
		return valorActual;
	}

	public void setValorActual() {
		valorActual = valorNuevo;
	}

	public double getValorNuevo() {
		return valorNuevo;
	}

	public void setValorNuevo(double valorNuevo) {
		this.valorNuevo = valorNuevo;
	}
	
	public String estado() {
		if(valorActual == valorNuevo) {
			return "Igual";
		} else if (valorActual > valorNuevo) {
			return "Menor";
		} else if(valorActual < valorNuevo) {
			return "Mayor";
		}
		
		return "NO COTIZA";
	}
}
