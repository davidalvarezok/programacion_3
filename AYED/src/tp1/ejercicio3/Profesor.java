package tp1.ejercicio3;

public class Profesor {
	private String nombre, apellido, email, facultad; 
	private int catedra;
	
	public Profesor () {
		
	}
	public Profesor(String nombre, String apellido, String email, String facultad, int catedra) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.facultad = facultad;
		this.catedra = catedra;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public int getCatedra() {
		return catedra;
	}
	public void setCatedra(int catedra) {
		this.catedra = catedra;
	}
	
	public String tusDatos() {
		return "Profesor [nombre " + getNombre() + ", apellido=" + getApellido() + ", email " + getEmail() + ", facultad " + getFacultad()
				+ ", catedra " + getCatedra() + "]";
	} 
    
}
