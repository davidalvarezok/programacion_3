package tp3.ejercicio2;

import java.util.List;
import tp1.ejercicio8.Queue;
import java.util.LinkedList;


public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children; 
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return children != null && !children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			List<GeneralTree<T>> children = this.getChildren();
			if (children.contains(child))
				children.remove(child);
		}
	}
	
	private void alturaMax (List<Integer> lista, GeneralTree<T> ag, int height) {
		if (ag != null) {
			if (ag.isLeaf()) {
				lista.add(height); 
			}
			height++; 
			List<GeneralTree<T>> children = ag.getChildren(); 
			for (GeneralTree<T> child : children) {
				this.alturaMax(lista, child, height);
			}
			height--;
		}
	}
	
	public int altura () {
		List<Integer> lista = new LinkedList<Integer>(); 
		this.alturaMax(lista, this, 0);
		int max = 0; 
	    for (Integer valor : lista) {
			if (valor > max) {
				max = valor; 
			} 
		}
		return max; 
	}
	
	private int nivelHelper (T dato, GeneralTree<T> ag, int nivelActual) {
		if (ag.getData() == dato) {
			return nivelActual; 
		}
		List<GeneralTree<T>> children = ag.getChildren(); 
		for (GeneralTree<T> child : children) {
			int nivelEncontrado = this.nivelHelper(dato, child, nivelActual + 1); 
			if (nivelEncontrado != -1) {
				return nivelEncontrado; 
			}
		}
		return -1; 
	}
	
	public int nivel (T dato) { //Assuming that the entered data is in the tree
		return this.nivelHelper(dato, this, 0); 
	}
	
	private void numberChildren(GeneralTree<T> ag, List<Integer> list) {
		int quantity = 0; 
		List<GeneralTree<T>> children = ag.getChildren(); 
		for (GeneralTree<T> child : children) {
			quantity++; 
			this.numberChildren(child, list);
		}
		if (children != null) {
			list.add(quantity);
		}
	}
	
	public int ancho () {
		List<Integer> list = new LinkedList<Integer>(); 
		this.numberChildren(this, list);
		int max = -1; 
		for (Integer valor : list) {
			if (valor > max) {
				max = valor; 
			}
		}
		return max; 
	}
	
	private GeneralTree<T> buscarNodo (GeneralTree<T> tree, T dato) {
		GeneralTree<T> a = null; 
		boolean encontre = false; 
		
		GeneralTree<T> tree_aux; 
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>(); 
		queue.enqueue(tree);
		while (!queue.isEmpty() || encontre != true) {
			tree_aux = queue.dequeue();
			if (tree_aux.getData() == dato) {
				a = tree_aux; 
				encontre = true; 
			} 
			if (encontre != true) {
				List<GeneralTree<T>> children = tree_aux.getChildren(); 
				for (GeneralTree<T> child : children) {
					queue.enqueue(child);
				}
			}
		}
		return a; 
	}
	
	/*Un nodo A es ancestro de un nodo B si existe un camino desde A a B*/
	
	public boolean esAncestro(T a, T b) {
		boolean encontre = false; 
		GeneralTree<T> arbolA = this.buscarNodo(this, a); //Nodo a
		if (arbolA != null) {
			GeneralTree<T> arbolB = this.buscarNodo(arbolA, b);
			if (arbolB != null) {
				encontre = true; 
			}
		}
		return encontre; 
	}

}
