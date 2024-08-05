package Parcial29_8_24;

import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.ListAdy.AdjListGraph;

public class Principal {

	public static void main (String[] args) {
		Graph<String> grafo = new AdjListGraph<>(); 
		Vertex<String> v1 = grafo.createVertex("Lionel");
		Vertex<String> v2 = grafo.createVertex("Rodrigo");
		Vertex<String> v3 = grafo.createVertex("Angel");
		Vertex<String> v4 = grafo.createVertex("Emiliano");
		Vertex<String> v5 = grafo.createVertex("Julian");
		Vertex<String> v6 = grafo.createVertex("Diego");
		Vertex<String> v7 = grafo.createVertex("Lautaro");
		Vertex<String> v8 = grafo.createVertex("Enzo");
		
		grafo.connect(v1, v2);
		grafo.connect(v2, v1);
		grafo.connect(v1, v3);
		grafo.connect(v3, v1);
		grafo.connect(v2, v4);
		grafo.connect(v4, v2);
		grafo.connect(v2, v5);
		grafo.connect(v5, v2);
		grafo.connect(v4, v7);
		grafo.connect(v7, v4);
		grafo.connect(v5, v7);
		grafo.connect(v7, v5);
		grafo.connect(v3, v5);
		grafo.connect(v5, v3);
		grafo.connect(v3, v8);
		grafo.connect(v8, v3);
		grafo.connect(v3, v6);
		grafo.connect(v6, v3);
		grafo.connect(v6, v8);
		grafo.connect(v8, v6);
		grafo.connect(v6, v7);
		grafo.connect(v7, v6);
		grafo.connect(v4, v8);
		grafo.connect(v8, v4);
		
		Parcial p = new Parcial(); 
		List<Invitado> lista = p.invitacionMasterClass(grafo, "Lionel", 2, 4); 
		for (Invitado invitado : lista) {
			System.out.println(invitado);
		}
	}

}
