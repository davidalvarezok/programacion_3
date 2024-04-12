package tp2.ejercicio5;
import tp2.ejercicio1.BinaryTree;
import java.util.ArrayList;
import java.util.List; 

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab; 
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
		ab = a; 
	}
	
	public List<Integer> nodosEnProfundidad(int profundidad){
		List<Integer> nodos = new ArrayList<Integer>(); 
		obtenerNodosEnProfundidad(ab,profundidad,0,nodos);
		return nodos; 
	}
	
	public void obtenerNodosEnProfundidad(BinaryTree<Integer> arbol, int profundidad, int profActual, List<Integer> nodos) {
		if (arbol != null) {
			if (profundidad == profActual) {
				nodos.add(arbol.getData()); //Agrega a la lista todos los nodos que esten a esta profundidad
			} else { 
				this.obtenerNodosEnProfundidad(arbol.getLeftChild(), profundidad, profActual+1, nodos);
				this.obtenerNodosEnProfundidad(arbol.getRightChild(), profundidad, profActual+1, nodos);
			}
		}
	}
	
	public int sumaElementosProfundidad(int p) {
		List<Integer> nodos = nodosEnProfundidad(p); 
		int suma = 0; 
		for (int valor: nodos) {
			suma+=valor; 
		}
		return suma;
	}

}
