package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.Iterator; 

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Estudiante> e = new ArrayList<>(); 
        crearLista(e); 
        Estudiante e4 = new Estudiante("Guillermo","Mosconi","12345/6");
        int valuo = 0; 
        for (Estudiante s : e) {
        	if (s.equials(e4)) {
        		break; 
        	}
        	valuo++; 
        }
        if (e.size() == valuo) {
        	e.add(e4); 
        	System.out.println("Se agrego un nuevo estudiante a la lista");
        } else {
        	System.out.println("El estudiante ya existe en la lista");
        }
        Iterator<Estudiante> it = e.iterator();
        System.out.println("Contenido de la lista:");
        while (it.hasNext()) {
        	System.out.println(it.next());
        }
        //--------------------------Second Part--------------------------------
        ArrayList<Integer> num = new ArrayList<>(); 
        num.add(5); 
        num.add(4); 
        num.add(2); 
        num.add(4); 
        num.add(5); 
        if (esCapicua1(num)) {
        	System.out.println("El numero es capicua");
        } else {
        	System.out.println("El numero no es capicua");
        }
    }
    public static void crearLista(ArrayList<Estudiante> e) {
    	Estudiante e1 = new Estudiante ("Simon","Avendaño","03242/6"); 
        Estudiante e2 = new Estudiante ("Peter","Griffin","37492/6"); 
        Estudiante e3 = new Estudiante ("Juan","Alvarez","03100/2"); 
        e.add(e1); e.add(e2); e.add(e3);
        ArrayList<Estudiante> s = new ArrayList<>();
        Estudiante s1 = new Estudiante(e1.getNombre(),e1.getApellido(),e1.getLegajo()); 
        Estudiante s2 = new Estudiante(e2.getNombre(),e2.getApellido(),e2.getLegajo()); 
        Estudiante s3 = new Estudiante(e3.getNombre(),e3.getApellido(),e3.getLegajo());
        s.add(s1); s.add(s2); s.add(s3); 
        for (Estudiante st: s) {
        	st.setLegajo("00000/0"); 
        }
        System.out.println("Lista original y copia: ");
        for (int i = 0; i<e.size(); i++) {
        	System.out.println(e.get(i).toString());
        	System.out.println(s.get(i).toString());
        }
    }
    public static boolean esCapicua(ArrayList<Integer> lista) {
    	boolean resul = true; int aux;  
    	ArrayList<Integer> l = new ArrayList<>();
    	if (lista.size()%2 != 0) {
    		aux = lista.size()/2 + 1; 
    	} else {
    		aux = lista.size()/2; 
    	}
    	for (int i = aux; i < lista.size(); i++) { //I create a new list with the second half of the list
    		 l.add(0,lista.get(i)); //add a new number in a new list
    		 System.out.println("Numero que estoy agregando "+lista.get(i));
    	}
    	for (int i = 0; i < lista.size()/2; i++) {
    		if (lista.get(i) != l.get(i)) {
    			resul = false; 
    			break; 
    		}
    	}
    	return resul; 
    }
    public static boolean esCapicua1(ArrayList<Integer> lista) { //More efficient 
    	boolean resul = true; int n = lista.size() - 1;  
    	for (int i = 0; i < lista.size()/2; i++) {
    		if (lista.get(i) != lista.get(n-i)) {
    			resul = false; 
    			break;
    		}
    	}
    	return resul; 
    }
}
