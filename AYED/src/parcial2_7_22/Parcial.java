package parcial2_7_22;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.ListAdy.AdjListGraph;

public class Parcial {
	
	List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMaximo){
		boolean [] marca = new boolean[ciudades.getSize()];   
		LinkedList<String> lista = new LinkedList<String>(); //Sirve_como_auxiliar
		List<LinkedList<String>> buffer = new LinkedList<LinkedList<String>>(); 
		List<String> camino = new LinkedList<String>(); 
		Vertex<String> v = ciudades.search(origen);
		if (v != null) { 
			marca[v.getPosition()] = true; 
			lista.add(origen);  
			dfs(v.getPosition(), ciudades, destino, buffer, lista, marca, montoMaximo, 0); 
		    if (buffer.size() != 0) {
		    	camino = new LinkedList<String>(buffer.getFirst()); //Agregamos_el primer camino_que hayamos_encontrado 
		    }
		}
    	return camino;
	}
	private void dfs(int i, Graph<String> grafo, String destino, List<LinkedList<String>> buffer, 
			LinkedList<String> lista, boolean[] marca, int montoMaximo, int monto) {
		
	    Vertex<String> v = grafo.getVertex(i); //Vertice_ciudad actual
	    List<Edge<String>> ady = grafo.getEdges(v); 
	    for (Edge<String> e : ady) {
			int j = e.getTarget().getPosition(); 
			if (!marca[j]) {
				int p = e.getWeight();
				if (monto + p < montoMaximo) { //Esto_me garantiza_que el camino_simpre sera_menor al_montoMaximo
					marca[j] = true;
					lista.add(e.getTarget().getData()); //Guardamos_la_ciudad
					if (!e.getTarget().getData().equals(destino)) { //No_llegamos a la_ciudad_destino
						dfs(j, grafo, destino, buffer, lista, marca, montoMaximo, monto + p); 
					} else {
						buffer.add(new LinkedList<String>(lista)); //Guarda_todos los_caminos de_origen a_destino que_cumplan la_condicion
					}
					marca[j] = false;
					lista.removeLast(); 
				}
				
			}
		}
	    
	 }
	 public static void main(String[]args) {
		 @SuppressWarnings("resource")
		Scanner in= new Scanner(System.in);
		 Graph<String> g= new AdjListGraph<>();
		 Vertex<String> v1= g.createVertex("Lincoln");
		 Vertex<String> v2= g.createVertex("Chascomus");
		 Vertex<String> v3= g.createVertex("Canuelas");
		 Vertex<String> v4= g.createVertex("Dolores");
		 Vertex<String> v5= g.createVertex("Veronica");
		 Vertex<String> v6= g.createVertex("Villa Urquiza");
		 Vertex<String> v7= g.createVertex("Ranchos");
		 Vertex<String> v8= g.createVertex("Berisso");
		 
		 g.connect(v1, v2, 70); 
		 g.connect(v2, v1, 70);
		 g.connect(v1, v3, 50); 
		 g.connect(v3, v1, 50); 
		 g.connect(v1, v4, 90);
		 g.connect(v4, v1, 90);
		 g.connect(v2, v5, 80); 
		 g.connect(v5, v2, 80);
		 g.connect(v2, v6, 60); 
		 g.connect(v6, v2, 60); 
		 g.connect(v3, v5, 85);
		 g.connect(v5, v3, 85);
		 g.connect(v3, v7, 90);
		 g.connect(v7, v3, 90);
		 g.connect(v4, v7, 70);
		 g.connect(v7, v4, 70);
		 g.connect(v4, v6, 70);
		 g.connect(v6, v4, 70);
		 g.connect(v5, v8, 60);
		 g.connect(v8, v5, 60);
		 g.connect(v6, v8, 90);
		 g.connect(v8, v6, 90);
		 g.connect(v7, v8, 75);
		 g.connect(v8, v7, 75);
		 
		 System.out.println("Ingrese ciudad de origen: ");
		 String origen= in.next();
		 System.out.println("Ingrese ciudad de destino: ");
		 String destino= in.next();
		 System.out.println("Ingrese monto maximo: ");
		 int montoMaximo= in.nextInt();
		 
		 Parcial p= new Parcial();
		 System.out.println(p.caminoConPresupuesto(g, origen, destino, montoMaximo));
	 }
}
