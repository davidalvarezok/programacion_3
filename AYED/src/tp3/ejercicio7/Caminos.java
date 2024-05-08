package tp3.ejercicio7;
import tp3.ejercicio2.GeneralTree;
import java.util.*;

public class Caminos {
	GeneralTree<Integer> numeros;

	public Caminos(GeneralTree<Integer> numeros) {
		this.numeros = numeros;
	} 
	
	private void furthestPath (List<Integer> originalPath, List<Integer> maxPath, GeneralTree<Integer> tree, int height, int max) {
		originalPath.add(tree.getData());
		if (tree.isLeaf()) {
			if (height > max) {
				max = height; 
				maxPath = new LinkedList<Integer>(originalPath); //Clono_la_lista
			}
		}
		height++; 
		List<GeneralTree<Integer>> children = tree.getChildren(); 
		for (GeneralTree<Integer>  child : children) {
			this.furthestPath(originalPath, maxPath, child, height, max);
		}
		originalPath.removeLast(); //Elimino_ult_Elemento
		height--; 
	}
	
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> originalPath = new LinkedList<Integer>(); 
		List<Integer> maxPath = new LinkedList<Integer>(); //El_garbage_collector_elimina_obj_no_referenciados
		this.furthestPath(originalPath, maxPath, numeros, 0, -1);
     	return maxPath; 
	}

}
