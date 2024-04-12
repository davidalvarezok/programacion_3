package tp2.ejercicio6;
import tp2.ejercicio1.BinaryTree;

public class ProbandoSumaArbol {

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
        Transformacion t = new Transformacion(ab); 
        ab = t.suma();
        ab.entreNiveles(1, 3);

	}

}
