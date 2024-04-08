package tp2.ejercicio1;

public class ProbandoAB {

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
        System.out.println("La cantidad de hojas del arbol "+ab.contarHojas());
        BinaryTree<Integer> copia = ab.espejo(); 
        copia.entreNiveles(1, 3);
        ab.entreNiveles(2, 3);
	}
    //Funcianan
}
