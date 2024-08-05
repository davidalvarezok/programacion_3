package ParcialCovidCiudades;

import tp5.ejercicio1.*;
import java.util.*;

public class Parcial {
	public List<Ciudad> resolver (Graph<Ciudad> ciudades, String origen, String destino){
		LinkedList<Ciudad> camino = new LinkedList<Ciudad>();
		List<LinkedList<Ciudad>> lista = new LinkedList<LinkedList<Ciudad>>(); 
		boolean[] marca = new boolean[ciudades.getSize()];
		Ciudad ciudad = new Ciudad(origen,3); //La ciudad que se busca
		Vertex<Ciudad> v = ciudades.search(ciudad);
		if (v != null) {
			dfs(ciudades, v.getPosition(), marca, origen, destino, camino, lista); 
			camino.addAll(lista.getFirst());
		}
		return camino; 
	}
	
	private void dfs (Graph<Ciudad> ciudades, int i, boolean[] marca, String origen, String destino, LinkedList<Ciudad> camino, 
			List<LinkedList<Ciudad>> lista) {
		marca[i] = true; 
		Vertex<Ciudad> v = ciudades.getVertex(i);
		if (v.getData().getNombre().equals(destino)) {
			lista.add(camino); 
		} else if (v.getData().getFase() > 1) {
			//Vertice valido 
			camino.add(v.getData());
			List<Edge<Ciudad>> adyacentes = ciudades.getEdges(v);
		    for (Edge<Ciudad> e : adyacentes) {
    			if (!marca[e.getTarget().getPosition()]) {
    				dfs(ciudades, e.getTarget().getPosition(), marca, origen, destino, camino, lista);
    			}
    			if (e.getTarget().getData().getNombre().equals(destino)) {
    				break;
    			}
		    }
		}
		marca[i] = false; 
	}

}
