package parcial10_6;
import tp2.ejercicio1.BinaryTree; 
import java.util.*;

public class ProcesadorDeArbol {
	private BinaryTree<Character> ab;

	public ProcesadorDeArbol(BinaryTree<Character> ab) {
		this.ab = ab;
	} 
	
	public void procesar(int k) {
		List<List<Character>> caminos = new LinkedList<List<Character>>(); 
		
	}
	
	public void buscar(BinaryTree<Character> a, int k, int cont, List<List<Character>> caminos, List<Character> lista){
		lista.add(a.getData());
		if (!a.hasLeftChild() && a.hasRightChild()) {
			cont++; 
		}
		if (a.hasLeftChild() && !a.hasRightChild()) {
			cont++; 
		}
		
		if (a.hasLeftChild()) {
			buscar(a.getLeftChild(),k,cont,caminos,lista); 
		}
		if (a.hasRightChild()) {
			buscar(a.getRightChild(),k,cont,caminos,lista); 
		}
		if (cont == k) {
			caminos.add(lista); 
		}
		lista.removeLast(); //Saco el ult elemento
	}

}
