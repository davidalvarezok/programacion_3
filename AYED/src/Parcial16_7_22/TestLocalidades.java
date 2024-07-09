package Parcial16_7_22;
import tp5.ejercicio1.*;
import tp5.ejercicio1.ListAdy.AdjListGraph;

import java.util.*;

public class TestLocalidades {

	public static void main(String[] args) {
		List<String> listaExcep = new LinkedList<String>(); 
		Scanner in = new Scanner(System.in); 
		Graph<String> g= new AdjListGraph<>();
		Vertex<String> v1= g.createVertex("Mendoza");
		Vertex<String> v2= g.createVertex("Tunuyán");
		Vertex<String> v3= g.createVertex("Malargue");
		Vertex<String> v4= g.createVertex("San Martín");
		Vertex<String> v5= g.createVertex("San Rafael");
		Vertex<String> v6= g.createVertex("Santa Rosa");
		Vertex<String> v7= g.createVertex("La Paz");
		Vertex<String> v8= g.createVertex("General Alvear");
		
		g.connect(v1, v2, 10);
		g.connect(v1, v4, 6);
		g.connect(v2, v4, 10);
		g.connect(v2, v3, 12);
		g.connect(v4, v7, 8);
		g.connect(v4, v5, 13);
		g.connect(v7, v6, 2);
		g.connect(v5, v2, 11);
		g.connect(v5, v8, 7);
		g.connect(v8, v3, 6);
		
		System.out.print("Ingrese la cantidad de localidades a visitar: ");
		int cantLocalidades = in.nextInt( );
		System.out.print("Ingrese la cantidad de nafta: ");
		int cantNafta = in.nextInt();
//		System.out.println("Ingrese ciudades a exceptuar: ");
//	    System.out.println("Ciudad 1: "); String ciudad1 = in.nextLine(); 
//	    in.nextLine(); 
//	    System.out.println("Ciudad 2: "); String ciudad2 = in.nextLine();
	    listaExcep.add("General Alvear"); 
	    listaExcep.add("La Paz"); 
//	    System.out.println("Los datoa caegados son "+cantLocalidades+" "+cantNafta+" "+ciudad1+" "+ciudad2);
	    Localidades localidades = new Localidades();
	    LinkedList<String> camino = (LinkedList<String>) localidades.recorrido(g, cantLocalidades, cantNafta, listaExcep);
	    System.out.println(camino);
        in.close();
	}

}
