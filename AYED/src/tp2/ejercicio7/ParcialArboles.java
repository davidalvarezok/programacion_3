package tp2.ejercicio7;
import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> ab;
	
	public ParcialArboles(BinaryTree<Integer> ab) {
		this.ab = ab; 
	}
	
	public BinaryTree<Integer> nodoBuscado (BinaryTree<Integer> a, int n){		
		if (a == null || a.getData() == n) {
		    return a; 
		}
	    BinaryTree<Integer> resultLeft = this.nodoBuscado(a.getLeftChild(), n); 
	    if (resultLeft != null) {
	    	return resultLeft;
	    }
	    return this.nodoBuscado(a.getRightChild(), n); 
	}
	
	public int unicoHijo(BinaryTree<Integer> a) {
		if (a.isLeaf()) {
			return 0; 
		} else if (a.hasLeftChild() && !a.hasRightChild()) {
			return 1 + unicoHijo(a.getLeftChild()); 
		} else if (!a.hasLeftChild() && a.hasRightChild()) {
			return 1 + unicoHijo(a.getLeftChild()); 
		} else {
			return unicoHijo(a.getLeftChild()) + unicoHijo(a.getRightChild()); 
		}
	}
	
	public boolean isLeftTree (int n) {
		boolean result = false;  
		if (nodoBuscado(ab, n) != null) { //El nodo está en el arbol
			if (ab.hasLeftChild() && ab.hasRightChild()) { //Tiene ambos hijos
				result = unicoHijo(ab.getLeftChild()) > unicoHijo(ab.getRightChild());  
			} else if (ab.hasLeftChild() && !ab.hasRightChild()) {
				result = unicoHijo(ab.getLeftChild()) > -1; 
			} else if (!ab.hasLeftChild() && ab.hasRightChild()){
				result = -1 > unicoHijo(ab.getRightChild());
			}
		}
		return result; 
	}

}
