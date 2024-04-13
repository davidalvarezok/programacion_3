package tp2.ejercicio4;
import java.util.LinkedList;
import java.util.Iterator; 
import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> ab; 
	private Integer max; 
	
	public RedBinariaLlena() {
		this.max = 0; 
	}
	
	public RedBinariaLlena(BinaryTree<Integer> ab) {
		this.ab = ab; 
		this.max = 0; 
	}
	
	public int retardoReenvio() {
		LinkedList<Integer> valores = new LinkedList<Integer>(); 
		this.preOrden(ab, valores);
		return max;  
	}
	
	public void preOrden (BinaryTree<Integer> a, LinkedList<Integer> valores) {
		if (a != null) {
			valores.add(a.getData()); //Guardo el valor del nodo
			if (a.isLeaf()) {
				Iterator<Integer> it = valores.iterator();
				int total = 0; 
				while (it.hasNext()) {
					total += it.next(); 
				}
				if (total > max) {
					max = (Integer)total; 
				}
			}
			this.preOrden(a.getLeftChild(), valores);
			this.preOrden(a.getRightChild(), valores);
			valores.removeLast(); //Elimina el ult elem de la lista
		}
	}
	
	

}
