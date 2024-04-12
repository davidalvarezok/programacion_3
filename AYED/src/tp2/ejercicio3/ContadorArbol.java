package tp2.ejercicio3;
import tp2.ejercicio1.*;
import java.util.ArrayList; 
//Necesita con metodo statico main para ser ejecutado 
public class ContadorArbol {
	private BinaryTree<Integer> ab; 
	
	public ContadorArbol() {
		ab = null; 
	}
	
	public void agregarNumeros(int n) {
		agregarNumeros(ab,n); 
	}
	
	private void agregarNumeros(BinaryTree<Integer> a, int n) {
		if (a == null) {
			a = new BinaryTree<Integer>(n);
		} else {
			BinaryTree<Integer> a2; 
			if (n < a.getData()) {
				a2 = a.getLeftChild();
				agregarNumeros(a2,n); 
			} else {
				a2 = a.getRightChild(); 
				agregarNumeros(a2,n); 
			}
		}
	}
	
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
