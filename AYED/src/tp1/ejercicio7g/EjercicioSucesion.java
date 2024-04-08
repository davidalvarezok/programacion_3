package tp1.ejercicio7g;
import java.util.ArrayList;
import java.util.LinkedList; 
import java.util.Iterator; 

public class EjercicioSucesion {

	public static void main(String[] args) {
		ArrayList<Integer> l = calcularSucesion(6); 
		LinkedList<Integer> e = new LinkedList<>(); 
		e.add(3); e.add(5); e.add(6); e.add(9); 
		int a = sumarLinkedList(e); 
		System.out.println("La suma de la LinkedList es : "+a);
		ArrayList<Integer> b = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>(); 
		b.add(3); b.add(8); b.add(17); b.add(24); b.add(33); 
		c.add(1); c.add(5); c.add(18); c.add(22); c.add(37); 
		ArrayList<Integer> d = combinarOrdenado(b,c); 
		Iterator<Integer> iter = d.iterator(); 
		System.out.println("La nueva lista Ordenada: ");
        while (iter.hasNext()) {
        	System.out.print(iter.next()+" ");
        }
        System.out.println("");
        System.out.println("La Sucesion nos queda: ");
        Iterator<Integer> it = l.iterator(); 
        while (it.hasNext()) {
        	System.out.print(it.next()+" ");
        }
        System.out.println("");
        invertirArrayList(l); 
        System.out.println("Lista Invertida");
        for (Integer n : l) {
        	System.out.print(n+" ");
        }
	}
    public static ArrayList<Integer> calcularSucesion(int n){
    	//Caso Base
    	if (n == 1) {
    		ArrayList<Integer> l = new ArrayList<>();
    		l.add(1); 
    		return l; 
    	}
    	if (n%2 == 0) {
    		ArrayList<Integer> l = calcularSucesion(n/2);
    		l.add(0,n);
    		return l; 
    	} else {
    		ArrayList<Integer> l = calcularSucesion(3*n+1);
    		l.add(0,n); 
    		return l; 
    	}
    }
    public static void invertirArrayList(ArrayList<Integer> lista) {
    	if (!lista.isEmpty()) {
    		int n = lista.remove(0); 
    		invertirArrayList(lista); //lista - 1
    		lista.add(n); 
    	} //Caso Base: NO hacer nada 
    }
    public static int sumarLinkedList(LinkedList<Integer> lista) {
    	//caso Base 
    	if (lista.isEmpty()) {
    		return 0; 
    	} 
    	return lista.remove(0) + sumarLinkedList(lista);  
    }
    public static int menor(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
    	int n = -1; 
    	if (!lista1.isEmpty() && !lista2.isEmpty()) {
    		if (lista1.get(0) <= lista2.get(0)) {
    			n = lista1.remove(0); 
    		} else {
    			n = lista2.remove(0); 
    		}
    	} else if (lista1.isEmpty()) {
    		n = lista2.remove(0); 
    	} else {
    		n = lista1.remove(0); 
    	}
    	return n; 
    }
    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
    	//Caso Base
    	if (lista1.isEmpty() && lista2.isEmpty()) {
    		ArrayList<Integer> l = new ArrayList<>();
    		return l; 
    	} else { 
    		int n = menor(lista1,lista2); 
    	    ArrayList<Integer> l = combinarOrdenado(lista1,lista2);
    	    l.addFirst(n); 
    	    return l; 
    	}
    }
}
