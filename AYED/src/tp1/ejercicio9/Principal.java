package tp1.ejercicio9;

public class Principal {

	public static void main(String[] args) {
		String palabra = "[{}()]"; 
		boolean valor = TestBalanceo.verificar(palabra); 
		if (valor) {
			System.out.println("Esta balanceado");
		} else {
			System.out.println("No esta balanceado");
		}
	}
}
