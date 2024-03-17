package tp1.ejercicio1;

public class Principal {

	public static void main(String[] args) {
		rango1(2,5); 
		rango2(2,5); 
        rango3(2,5);
	}
    public static void rango1 (int a, int b) {
    	for (int i=a; i<=b; i++)
    	    System.out.println(i);
    }
    public static void rango2 (int a, int b) {
    	while (a != (b+1)) {
    		System.out.println(a); 
    	    a++; 
    	}
    }
    public static void rango3 (int a, int b) {
    	if (a!=(b+1)) {
    	    System.out.println(a);
    	    rango3(a+1,b); 
    	}
    }
}
