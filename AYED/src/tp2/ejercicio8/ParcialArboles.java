package tp2.ejercicio8;
import tp2.ejercicio1.BinaryTree;
import java.util.*; 

public class ParcialArboles {
	
	public void analisis (BinaryTree<Integer> a, List<Integer> list) {
		if (a != null) {
			this.analisis(a.getLeftChild(), list);
			list.add(a.getData());
			this.analisis(a.getRightChild(), list); 
		}
	}
	
	public boolean comparo (List<Integer> list1, List<Integer> list2) {
		for (int valor : list2) {
			if (valor == list1.getFirst()) {
				list1.removeFirst(); 
			}
		}
		return list1 == null; 
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		List<Integer> lista1 = new ArrayList<Integer>();
		List<Integer> lista2 = new ArrayList<Integer>();
		this.analisis(arbol1, lista1); 
		this.analisis(arbol2, lista2);
		return this.comparo(lista1, lista2); 
	} 

}
