package tp3.ejercicio9;
import tp3.ejercicio2.GeneralTree;
import tp1.ejercicio8.Queue;
import java.util.*;

public class Parcial {
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		boolean result = true; 
		int menor, raiz; 
		
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>(); 
		GeneralTree<Integer> tree_aux; 
		queue.enqueue(arbol);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			raiz = tree_aux.getData(); menor = 9999; 
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for (GeneralTree<Integer> child : children) {
				queue.enqueue(child);
				if (child.getData() < menor) {
					menor = child.getData(); 
				}
			}
			if (children != null) {
				if (raiz != menor) {
					result = false; 
					break; 
				}
			}
		}
		return result; 
	}

}
