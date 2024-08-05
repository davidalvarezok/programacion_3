package Parcial29_8_24;
import java.util.*;
import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;

public class Parcial {
	public List<Invitado> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite){
		List<Invitado> lista = new LinkedList<Invitado>();
		Queue<Vertex<String>> queue = new Queue<Vertex<String>>(); 
		boolean[] marca = new boolean[red.getSize()];
		Vertex<String> actual = red.search(usuario); 
		queue.enqueue(actual);
		queue.enqueue(null); 
		marca[actual.getPosition()] = true; 
		int nivel = 0, encolados = 0; 
		while (!queue.isEmpty()) {
			actual = queue.dequeue(); 
			if (nivel > 0 && actual != null) {
				if (nivel <= distancia && encolados < limite) {
					lista.add(new Invitado(actual.getData(),nivel));
					encolados++; 
				} else {
					break; 
				}
			}
			if (actual != null) {
				List<Edge<String>> adyacentes = red.getEdges(actual); 
				for (Edge<String> e : adyacentes) {
					if (!marca[e.getTarget().getPosition()]) {
						queue.enqueue(e.getTarget());
					}
				}			
			} else {
				queue.enqueue(null);
				nivel++; 
			}
		}
		return lista; 
	}

}
