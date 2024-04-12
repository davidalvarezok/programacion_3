package tp2.ejercicio6;
import tp2.ejercicio1.BinaryTree;

public class Transformacion {
	BinaryTree<Integer> ab; 
	
	public Transformacion(BinaryTree<Integer> ab) {
		this.ab = ab; 
	}
	
	public BinaryTree<Integer> suma() {
		this.recorrer(ab,0);
		return ab; 
	}
	
	public int dataChild (BinaryTree<Integer> a) {
		return a.getData(); 
	}
	
	public void recorrer (BinaryTree<Integer> a, int aux) {
		if (a == null) {
			return; 
		}
		
		if (a.isLeaf()) {
			a.setData(0);
			return; 
		}
		
		int suma = 0; 
		if (a.hasLeftChild()) {
			suma += this.dataChild(a.getLeftChild()); //Devuelve el dato del hijo
			this.recorrer(a.getLeftChild(), aux);
		}
		if (a.hasRightChild()) {
			suma += this.dataChild(a.getRightChild()); 
			this.recorrer(a.getRightChild(), aux);
		}
		aux = a.getData();
		suma += aux; //Le sumo el valor de arrastre
		 
		a.setData(suma);
	}
}
