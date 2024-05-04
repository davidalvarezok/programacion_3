package tp3.ejercicio2;

import java.util.*;
import tp1.ejercicio8.Queue;

public class RecorridosAG {
	
	private void preOrder (GeneralTree<Integer> AG, List<Integer> impares, Integer n) {
		System.out.println(AG.getData());
		if (AG.getData()%2 != 0 && AG.getData() > n){
			impares.add(AG.getData());
		}
		List<GeneralTree<Integer>> children = AG.getChildren(); 
		for (GeneralTree<Integer> child : children) { 
			this.preOrder(child, impares, n);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> lista = new ArrayList<Integer>(); 
		this.preOrder(a, lista, n);
		return lista; 
	}
	
	private void InOrder (GeneralTree<Integer> AG, List<Integer> impares, Integer n) {
		if (AG.isLeaf()) {
			System.out.println(AG.getData());
			if (AG.getData()%2 != 0 && AG.getData() > n) {
				impares.add(AG.getData()); 
			}
		} else {
			this.InOrder(AG.getChildren().get(0), impares, n); //Mando al hijo izquierdo
			
			System.out.println(AG.getData());
			if (AG.getData()%2 != 0 && AG.getData() > n) {
				impares.add(AG.getData()); 
			}
			for (int i = 1; i < AG.getChildren().size(); i++) {
				this.InOrder(AG.getChildren().get(i), impares, n);
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> lista = new ArrayList<Integer>(); 
		this.InOrder(a, lista, n);
		return lista; 
	}
	
	private void PostOrder (GeneralTree<Integer> a, List<Integer> lista, Integer n) {
		List<GeneralTree<Integer>> children = a.getChildren(); 
		for (GeneralTree<Integer> child : children) {
			this.PostOrder(child, lista, n);
		}
		System.out.println(a.getData());
		if (a.getData() != 0 && a.getData() > n) {
			lista.add(a.getData()); 
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> lista = new ArrayList<Integer>(); 
		this.PostOrder(a, lista, n);
		return lista; 
	}
	
	private List<Integer> traversalLevel (GeneralTree<Integer> tree, Integer n) {
		List<Integer> result = new LinkedList<Integer>();
		GeneralTree<Integer> tree_aux; 
		
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>(); 
		queue.enqueue(tree);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue(); 
			if (tree_aux.getData()%2 != 0 && tree_aux.getData() > n) {
				result.add(tree_aux.getData()); 
			}
			List<GeneralTree<Integer>> children = tree_aux.getChildren(); 
			for (GeneralTree<Integer> child : children) {
				queue.enqueue(child);
			}
		}
		return result; 
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
		return this.traversalLevel(a, n); 
	}

}
