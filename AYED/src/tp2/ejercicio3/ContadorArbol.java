package tp2.ejercicio3;
import tp2.ejercicio1.*;
import java.util.ArrayList; 

public class ContadorArbol {
	private BinaryTree<Integer> ab; 
	
	public ArrayList<Integer> numerosPares() {
		ArrayList<Integer> pares = new ArrayList<Integer>();
		this.numerosParesIn(ab, pares);
		return pares;
	}
	
	public void numerosParesPre(BinaryTree<Integer> a, ArrayList<Integer> pares) {
		if (a != null) {
			if (a.getData()%2 == 0) {
				pares.add(a.getData()); 
			}
			this.numerosParesPre(a.getLeftChild(), pares);
			this.numerosParesPre(a.getRightChild(), pares);
		}
	}
	
	public void numerosParesIn(BinaryTree<Integer> a, ArrayList<Integer> pares) {
		if (a != null) {
			this.numerosParesIn(a.getLeftChild(), pares);
			if (a.getData()%2 == 0) {
				pares.add(a.getData()); 
			}
			this.numerosParesIn(a.getRightChild(), pares);
		}
	}
	
	public void numerosParesPos(BinaryTree<Integer> a, ArrayList<Integer> pares) {
		if (a != null) {
			this.numerosParesPos(a.getLeftChild(), pares);
			this.numerosParesPos(a.getRightChild(), pares);
			if (a.getData()%2 == 0) {
				pares.add(a.getData()); 
			}
		}
	}

}
