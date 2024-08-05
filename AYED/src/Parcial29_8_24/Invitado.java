package Parcial29_8_24;

public class Invitado {
	String nombre; 
	int distancia;
	
	public Invitado(String nombre, int distancia) {
		this.nombre = nombre;
		this.distancia = distancia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	} 
	
	@Override
	public String toString() {
		return nombre + ", " + distancia;
	}

}
