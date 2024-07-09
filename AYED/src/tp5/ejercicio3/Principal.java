package tp5.ejercicio3;
import tp5.ejercicio1.*;
import tp5.ejercicio1.ListAdy.*;
import java.util.List; 

public class Principal {
	public static void main(String[] args) {
	    Graph<String> g= new AdjListGraph<>();
	    Vertex<String> v1= g.createVertex("ciudad1");
	    Vertex<String> v2= g.createVertex("ciudad2");
	    Vertex<String> v3= g.createVertex("ciudad3");
	    Vertex<String> v4= g.createVertex("ciudad4");
	    Vertex<String> v5= g.createVertex("ciudad5");
	 
	    g.connect(v1, v5); //v1 --> v5
	    g.connect(v2, v1); //v2 --> v1
	    g.connect(v5, v4); //v5 --> v4
	    g.connect(v2, v3); //v2 --> v3
	    g.connect(v1, v3); //v1 --> v3
	    g.connect(v4, v2); //v4 --> v2
	 
	    Mapa m = new Mapa(g);
	    List<String> lista= m.devolverCamino("ciudad1", "ciudad2");
	    System.out.println(lista);
    }
	
}

