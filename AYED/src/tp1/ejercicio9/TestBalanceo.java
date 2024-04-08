package tp1.ejercicio9;
import tp1.ejercicio8.Stack; 

public class TestBalanceo {
	public static boolean verificar(String exp) {
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> reg = new Stack<Character>();  //Sirve como registro, ¿que llave esperamos? 
		for (int i = 0; i<exp.length(); i++) {
			char car = exp.charAt(i); 
			if (car == '(') {
				stack.push(car);
				reg.push(')'); 
			} else if (car == '[') {
				stack.push(car);
				reg.push(']'); 
			} else if (car == '{') {
				stack.push(car);
				reg.push('}'); 
			} else if (stack.isEmpty()) {
				return false; 
			} else if (car == reg.top()){
				stack.pop(); 
				reg.pop(); 
			} else {
				return false; //No es igual a la ultima llave
			}
		}
		return stack.isEmpty(); 
	}

}
