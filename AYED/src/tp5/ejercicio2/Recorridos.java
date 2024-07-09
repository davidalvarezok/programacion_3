package tp5.ejercicio2;

import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;
import java.util.List;
import java.util.ArrayList;

public class Recorridos<T> {

	public List<T> dfs(Graph<T> grafo) {
		List<T> lista = new ArrayList<T>();

		boolean[] marca = new boolean[grafo.getSize()];
		for (int i = 0; i < grafo.getSize(); i++) {
			if (!marca[i]) {
				/* System.out.println("largo con: "+grafo.getVertex(i).getData()); */
				lista.add(grafo.getVertex(i).getData());
				dfs(i, grafo, marca);
			}
		}
		return lista;
	}

	private void dfs(int i, Graph<T> grafo, boolean[] marca) {
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		System.out.println(v);
		List<Edge<T>> adyacentes = grafo.getEdges(v); 
		for (Edge<T> e : adyacentes) {
			int j = e.getTarget().getPosition();
			if (!marca[j]) {
				dfs(j, grafo, marca);
			}
		}
	}

	public List<T> bfs(Graph<T> grafo) {
		List<T> lista = new ArrayList<T>();

		boolean[] marca = new boolean[grafo.getSize()];
		for (int i = 0; i < marca.length; i++) {
			if (!marca[i]) {
				lista.add(grafo.getVertex(i).getData());
				bfs(i, grafo, marca);
			}
		}
		return lista;
	}

	private void bfs(int i, Graph<T> grafo, boolean[] marca) {
		Queue<Vertex<T>> queue = new Queue<Vertex<T>>();
		queue.enqueue(grafo.getVertex(i));
		marca[i] = true;
		while (!queue.isEmpty()) {
			Vertex<T> w = queue.dequeue();
			System.out.println(w);
			List<Edge<T>> adyacentes = grafo.getEdges(w);
			for (Edge<T> e : adyacentes) {
				int j = e.getTarget().getPosition();
				if (!marca[j]) {
					marca[j] = true;
					queue.enqueue(e.getTarget());
				}
			}
		}
	}

}
