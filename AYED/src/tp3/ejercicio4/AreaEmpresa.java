package tp3.ejercicio4;

public class AreaEmpresa {
	String nombre; 
	int tiempo;
	
	public AreaEmpresa() {
		
	}
	public AreaEmpresa(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempo = tiempo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	@Override
	public String toString() {
		return "AreaEmpresa [Nombre " + getNombre()
				+ ", Tiempo " + getTiempo() +"]";
	} 

}
