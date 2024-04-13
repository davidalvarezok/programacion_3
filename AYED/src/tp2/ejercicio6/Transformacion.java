package tp2.ejercicio6;
import tp2.ejercicio1.BinaryTree;

public class Transformacion {
	BinaryTree<Integer> ab; 
	
	public Transformacion(BinaryTree<Integer> ab) {
		this.ab = ab; 
	}
	
	public BinaryTree<Integer> suma() {
		this.recursivo(ab); 
		return ab; 
	}
	
	public int recursivo (BinaryTree<Integer> a) {
		if (a.isLeaf()) {
			int valou = a.getData(); 
			a.setData(0);
			return valou; 
		} else if (a.hasLeftChild() && !a.hasRightChild()){
			int valou = a.getData();
			a.setData(this.recursivo(a.getLeftChild())); 
			return valou + a.getData(); 
		} else if (!a.hasLeftChild() && a.hasRightChild()) {
			int valou = a.getData(); 
			a.setData(this.recursivo(a.getRightChild()));
			return valou + a.getData(); 
		} else {
			int valou = a.getData();
			a.setData(this.recursivo(a.getLeftChild()) + this.recursivo(a.getRightChild()));
			return valou + a.getData(); 
		}
	}
}
