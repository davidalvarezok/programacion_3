package tp1.ejercicio5;

public class Principal {

	static Estadistica e;  
	public static void main(String[] args) {
		int[] v = { 3, 4, 8, 7, 3, 5 };
		int[] p = valores(v);
		System.out.println("Max : "+p[0]);
		System.out.println("Min : "+p[1]);
		System.out.println("Promedio : "+p[2]);
//		Estadistica e = valores1(v);
		valores2(v);
		System.out.println("Max : "+e.getMax());
		System.out.println("Min : "+e.getMin());
		System.out.println("Promedio : "+e.getProm());
		
    }

	public static int[] valores(int[] v) {
		int max = 0, min = 9999, prom = 0;
		for (int e : v) {
			if (e > max)
				max = e;
			if (e < min)
				min = e;
			prom += e;
		}
		prom = prom / v.length;
		int[] p = { max, min, prom };
		return p;
	}

	public static Estadistica valores1(int[] v) {
		int max = 0, min = 9999, prom = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i] > max)
				max = v[i];
			if (v[i] < min)
				min = v[i];
			prom += v[i];
		}
		prom = prom / v.length;
		return new Estadistica (max,min,prom); 
	}
    
	public static void valores2(int [] v) {
		int max = 0, min = 9999; 
		double prom = 0;
		for (int a : v) {
			if (a > max)
				max = a; 
			if (a < min)
				min = a; 
			prom += a; 
		}
		prom = prom / v.length; 
		e = new Estadistica(max,min,prom); 
	}
}
