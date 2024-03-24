package tp1.ejercicio7;

public class Estudiante {
	private String nombre; 
	private String apellido; 
	private String legajo;
	
	public Estudiante() {
		
	}
	public Estudiante(String nombre, String apellido, String legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
	}
	public boolean equials(Object o) {
		boolean result = false;
		if ((o!=null) && (o instanceof Estudiante)) {
			Estudiante e = (Estudiante)o; 
			if (e.getNombre()==this.getNombre() && e.getApellido()==this.getApellido() &&e.getLegajo()==this.getLegajo()) {
				result = true; 
			}
		}
		return result; 
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	@Override
	public String toString() {
		return "Estudiante Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", Legajo: "
				+ getLegajo();
	} 

}
