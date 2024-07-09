package Parcial8_7_24;

import java.util.*;
import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;

public class Metro {
	public List<Registro> menosTransbordos(Graph<String> maps, String origen) {
		List<Registro> camino = new LinkedList<Registro>();
		boolean[] marca = new boolean[maps.getSize()];
		Vertex<String> v = maps.search(origen);
		bfs(maps, camino, v.getPosition(), marca, 0);
		return camino;
	}

	private List<Registro> bfs(Graph<String> maps, List<Registro> camino, int i, boolean[] marca, int trans) {
		Queue<Vertex<String>> queue = new Queue<Vertex<String>>();
		Vertex<String> v = maps.getVertex(i);
		Vertex<String> aux;
		queue.enqueue(v);
		while (!queue.isEmpty()) {
			aux = queue.dequeue();
			marca[aux.getPosition()] = true; // marcamos_como_visitado
			List<Edge<String>> adyacentes = maps.getEdges(aux);
			if (adyacentes.size() > 2) {
				trans++;
			}
			if (adyacentes.size() == 0) {
				// Es un extremo
				Registro res = new Registro(aux.getData(), trans);
				camino.add(res);
			}
			for (Edge<String> e : adyacentes) {
				queue.enqueue(e.getTarget());
			}
		}
		return camino;
	}

}
