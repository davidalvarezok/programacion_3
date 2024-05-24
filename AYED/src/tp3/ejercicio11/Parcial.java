package tp3.ejercicio11;
import java.util.*;
import tp3.ejercicio2.GeneralTree;
import tp1.ejercicio8.Queue;

public class Parcial {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean result = true; int contador = 0, nivel = 0; 
		
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>(); 
		GeneralTree<Integer> tree_aux; 
		queue.enqueue(arbol);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue(); 
			if (tree_aux != null) {
				List<GeneralTree<Integer>> children = tree_aux.getChildren();
				for (GeneralTree<Integer> child : children) {
					contador++;
					queue.enqueue(child);
				}    //Contador posee el numero de hijos que se pusieron en cola, si es cero, el ult
			} else { //nivel procesado fueron todas hojas
				nivel++; //Nivel_de_nodos_que_se_guardo_hasta_ahora
				if (contador > 0) {
					queue.enqueue(null);
					if (nivel+1 != contador) {
						result = false; 
						break; 
					}
					contador = 0; 
				}
			}
			
		}
		return result; 
	}

}
