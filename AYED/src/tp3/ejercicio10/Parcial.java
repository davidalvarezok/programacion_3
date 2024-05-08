package tp3.ejercicio10;
import tp3.ejercicio2.GeneralTree;
import java.util.*;

public class Parcial {
	
	private static void path (GeneralTree<Integer> a, List<Integer> orig, List<Integer> def, boolean cero, int height, int max) {
		if (a.isLeaf()) {
			if (!cero && height > max) {
				max = height; 
				def = new LinkedList<Integer>(orig); //Solo_listas_con_filtro 1 (el cero me avisa)
			}
		}
		if (a.getData() != 0) {
			orig.add(a.getData()); 
		} else {
			cero = true; 
		}
		height++; 
		List<GeneralTree<Integer>> children = a.getChildren(); 
		for (GeneralTree<Integer> child : children) {
			path(child, orig, def, cero, height, max);
		}
		height--; 
	}
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> orig = new LinkedList<Integer>();
		List<Integer> def = new LinkedList<Integer>(); 
		int max = -1; 
		path(arbol, orig, def, false, 0, max);
		System.out.println("La sumatoria es "+max*(max+1)/2); //Nodo*Nivel + ...
		return def; 
	}

}
