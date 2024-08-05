package ParcialCovidCiudades;

public class Ciudad {
	String nombre; 
	int fase;
	
	public Ciudad() {
		
	}
	public Ciudad(String nombre, int fase) {
		this.nombre = nombre;
		this.fase = fase;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFase() {
		return fase;
	}
	public void setFase(int fase) {
		this.fase = fase;
	}
	@Override 
	public boolean equals(Object o){
		boolean result=false;
	    if ((o!=null) && (o instanceof Ciudad)){
		Ciudad c = (Ciudad)o;
		if (c.getNombre()==this.getNombre() && c.getFase()==this.getFase()) result=true;
		}
		return result;
	}
	@Override
	public String toString() {
		return nombre + ", fase " + fase;
	} 
	
}
