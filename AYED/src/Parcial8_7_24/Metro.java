package Parcial8_7_24;

import java.util.*;
import tp5.ejercicio1.*;


public class Metro {
	public List<Registro> menosTrasbordos (Graph<String> maps, String origen){
		List<Registro> lista = new LinkedList<Registro>(); 
		boolean[] marca = new boolean [maps.getSize()]; 
		Vertex<String> v = maps.search(origen); 
		if (v != null) {
			dfs(maps, v.getPosition(), marca, origen, 0, lista); 
		}
		return lista; 
	}
	
	public void dfs(Graph<String> grafo, int i, boolean[] marca, String origen, int cant, List<Registro> l) {
		marca[i] = true; 
		Vertex<String> v = grafo.getVertex(i); 
		List<Edge<String>> adyacentes = grafo.getEdges(v); 
		int size = adyacentes.size(); 
		for (Edge<String> e : adyacentes) {
			int j = e.getTarget().getPosition(); 
			if (!marca[j]) {
				if (size > 2) {
					dfs(grafo, j, marca, origen, cant+1, l); 
				} else {
					dfs(grafo, j, marca, origen, cant, l); 
				}
			}
		}
		if (adyacentes.size() == 1 && !v.getData().equals(origen)) {
			boolean encontre = false; 
			for (Registro r : l) { //Lista inicialmente vacia
				if(r.getEstacion().equals(v.getData())) { //Si el nombre de la estacion ya esta en lista
					encontre = true; 
					if(r.getTransbordo() > cant) { //Me quedo con la menor cantidad de trasbordos 
						r.setTransbordo(cant);
					}
					
				}
			}
			if (!encontre) {
				l.add(new Registro(v.getData(),cant)); 
			}
		}
		marca[i] = false; 
	}

}
