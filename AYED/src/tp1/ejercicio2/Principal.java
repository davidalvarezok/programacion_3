package tp1.ejercicio2;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.println("Ingrese numero "); int a = in.nextInt();
        int [] v = generador(a); 
        for (int i = 0; i < a; i++) {
        	System.out.print(v[i]+" ");
        }
        in.close();
	}
    public static int[] generador (int n) {
    	int [] v = new int [n]; 
    	int k = 1; 
    	for (int i = 0; i < n; i++) {
    		v[i] = n*k; 
    		k++;
    	}
    	return v;  
    }
}
