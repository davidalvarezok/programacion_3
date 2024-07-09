package Parcial16_7_22;
import tp5.ejercicio1.*;
import java.util.*; 

public class Localidades {
	public List<String> recorrido (Graph<String> graph, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas){
		List<String> camino = new LinkedList<String>();
		List<String> lista = new LinkedList<String>(); 
		boolean [] marca = new boolean[graph.getSize()];
		LinkedList<LinkedList<String>> buffer = new LinkedList<LinkedList<String>>(); 
		Vertex<String> v = graph.search("Mendoza"); //Comienza_en_Mendoza
		if (v != null) {
			lista.add(v.getData()); //Agregamos_la_ciudad_origen
			marca[v.getPosition()] = true;
			dfs(v.getPosition(), graph, lista, marca, buffer, localidadesExceptuadas, cantLocalidades-1, cantNafta); 
			if (buffer.size() != 0) {
				camino = new LinkedList<String>(buffer.getFirst()); //Clonamos_el primer camino_que_en_contramos
			}
		}
		return camino; 
	}
	
	private void dfs (int i, Graph<String> grafo, List<String> lista, boolean [] marca, LinkedList<LinkedList<String>> buffer, 
			List<String> Excep, int cantLocalidades, int cantNafta) {
		Vertex<String> v = grafo.getVertex(i); 
		List<Edge<String>> adyacentes = grafo.getEdges(v); 
		for (Edge<String> e : adyacentes) {
			int j = e.getTarget().getPosition(); 
			if (!marca[j]) { //Evita_que haya_ciudades_repetidas
				int nafta = e.getWeight(); 
				if (cantLocalidades - 1 >= 0) { //¿puedo_agregar mas_ciudades?
					if (cantNafta - nafta >= 0 && !Excep.contains(e.getTarget().getData()) ) {
						marca[j] = true; //Si_tengo_nafta y la_ciudad no esta_exceptuada y no esta_repetida
						lista.add(e.getTarget().getData()); //Agregamos_la_ciudad
						System.out.println("Se agrego la ciudad "+ lista);
						dfs(j, grafo, lista, marca, buffer, Excep, cantLocalidades-1, cantNafta-nafta);
						if (cantLocalidades-1 == 0) { //Si_paso todos_los filtros_guardo la_lista
							buffer.add(new LinkedList<String>(lista));
						}
						lista.removeLast(); 
						marca[j] = false; 
					} 
				} 
			}
		}
	}

}
