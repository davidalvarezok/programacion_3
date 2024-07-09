package Parcial8_7_24;

public class Registro {
	private String estacion; 
	private int transbordo;
	
	public Registro(String estacion, int transbordo) {
		this.estacion = estacion;
		this.transbordo = transbordo;
	}
	public String getEstacion() {
		return estacion;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	public int getTransbordo() {
		return transbordo;
	}
	public void setTransbordo(int transbordo) {
		this.transbordo = transbordo;
	}
	@Override
	public String toString() {
		return "Estacion " + getEstacion() + " " + getTransbordo() + " ";
	} 
	

}
