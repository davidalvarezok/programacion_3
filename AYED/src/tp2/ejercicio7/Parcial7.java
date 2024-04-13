package tp2.ejercicio7;
import tp2.ejercicio1.BinaryTree;

public class Parcial7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> ab = new BinaryTree<Integer>(1); 
		BinaryTree<Integer> izq = new BinaryTree<Integer>(2); 
		izq.addLeftChild(new BinaryTree<Integer>(4));
		izq.addRightChild(new BinaryTree<Integer>(5));
        BinaryTree<Integer> der = new BinaryTree<Integer>(3); 
        der.addLeftChild(new BinaryTree<Integer>(6));
        der.addRightChild(new BinaryTree<Integer>(7));
        ab.addLeftChild(izq);
        ab.addRightChild(der);
        ParcialArboles p = new ParcialArboles(ab);
        if (p.isLeftTree(4)) {
        	System.out.println("El sub-arbol izquierdo es mayor estricto al sub-arbol derecho");
        } else {
        	System.out.println("El numero no esta o el sub-arbol izquierdo es menor al derecho");
        }
	}

}
