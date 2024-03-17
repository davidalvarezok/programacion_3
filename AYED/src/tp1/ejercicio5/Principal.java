package tp1.ejercicio5;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] v = new int [] {3,4,8,7,3,5}; 
        int [] p = valores(v); 
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i]+" ");
        }
	}
	public static int [] valores(int [] v) {
		int max = 0, min = 9999, prom = 0; 
		for (int i = 0; i < v.length; i++) {
			if (v[i] > max)
				max = v[i];
		    if (v[i] < min)
		    	min = v[i]; 
		    prom += v[i]; 
		}
		prom = prom/v.length; 
		int [] p = new int [] {max, min, prom}; 
		return p; 
	}
//    public static void valores1(int )
}
