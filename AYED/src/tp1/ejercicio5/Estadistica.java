package tp1.ejercicio5;

public class Estadistica {
	private int max; 
	private int min; 
	private double prom;
	
    public Estadistica() {
    	
    }
    
	public Estadistica(int max, int min, double prom) {
		this.max = max;
		this.min = min;
		this.prom = prom;
	}

	public int getMax() {
		return max;
	}
	
	public int getMin() {
		return min;
	}
	
	public double getProm() {
		return prom;
	} 
    
}
