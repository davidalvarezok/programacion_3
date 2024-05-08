package tp3.ejercicio6;
import tp3.ejercicio2.GeneralTree;
import tp1.ejercicio8.Queue;
import java.util.*; 

public class RedDeAguaPoteble {
	GeneralTree<Character> red; 
    
    public double minimoCaudal(Double caudal){    
	    double auxCaudal, caudalMin=9999; int cant_hijos;


		Queue<GeneralTree<Character>> colaNodos= new Queue<GeneralTree<Character>>();
	    Queue<Double> colaCaudal= new Queue<Double>();
		GeneralTree<Character> arbol_aux; 
		colaNodos.enqueue(red);
		colaNodos.enqueue(null);
		
	    colaCaudal.enqueue(caudal);
        colaCaudal.enqueue(0.0);

		while (!colaNodos.isEmpty()){
	        cant_hijos = 0;

	        auxCaudal = colaCaudal.dequeue();
			arbol_aux = colaNodos.dequeue();

     		if (arbol_aux != null){

	            if (auxCaudal < caudalMin) {
	                caudalMin= auxCaudal;
	            }

				if (arbol_aux.hasChildren()) {
				    List<GeneralTree<Character>> hijos = arbol_aux.getChildren();
					for (GeneralTree<Character> child : hijos) {
					    colaNodos.enqueue(child);
						cant_hijos++; 
					}
	                auxCaudal /= (double)cant_hijos;
	                    
				}
			
	            for (int i=0; i < cant_hijos; i++) {//Encola caudal por la misma cant_Hijos
                    colaCaudal.enqueue(auxCaudal);
	            }
	                
			} else if (!colaNodos.isEmpty()){
			    colaNodos.enqueue(null);		
	            colaCaudal.enqueue(0.0);			 
			}
     	}
	    return caudalMin;
    }

}
