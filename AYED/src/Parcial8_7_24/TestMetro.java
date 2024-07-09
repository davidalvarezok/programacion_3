package Parcial8_7_24;

import java.util.LinkedList;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.ListAdy.AdjListGraph;

public class TestMetro {
    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<>();
        Vertex<String> v1 = grafo.createVertex("Butanta");
        Vertex<String> v2 = grafo.createVertex("Vila Lobos");
        Vertex<String> v3 = grafo.createVertex("C. Universitaria");
        Vertex<String> v4 = grafo.createVertex("Pinheiros");
        Vertex<String> v5 = grafo.createVertex("Hebraica");
        Vertex<String> v6 = grafo.createVertex("Cidade Jardim");
        Vertex<String> v7 = grafo.createVertex("Vila Olimpia");
        Vertex<String> v8 = grafo.createVertex("Faria Lima");
        Vertex<String> v9 = grafo.createVertex("Vila Madalena");
        Vertex<String> v10 = grafo.createVertex("Clinicas");
        Vertex<String> v11 = grafo.createVertex("Paulista");
        Vertex<String> v12 = grafo.createVertex("Trianon");
        Vertex<String> v13 = grafo.createVertex("Brigadeiro");
        Vertex<String> v14 = grafo.createVertex("Republica");
        Vertex<String> v15 = grafo.createVertex("Armenia");
        Vertex<String> v16 = grafo.createVertex("Tiradentes");
        Vertex<String> v17 = grafo.createVertex("Luz");
        Vertex<String> v18 = grafo.createVertex("Faraiso");
        Vertex<String> v19 = grafo.createVertex("Saúde");

        grafo.connect(v1, v4);
        grafo.connect(v4, v3);
        grafo.connect(v3, v2);
        grafo.connect(v4, v8);
        grafo.connect(v4, v5);
        grafo.connect(v5, v6);
        grafo.connect(v6, v7);
        grafo.connect(v8, v11);
        grafo.connect(v11, v16);
        grafo.connect(v11, v14);
        grafo.connect(v11, v12);
        grafo.connect(v11, v10);
        grafo.connect(v10, v9);
        grafo.connect(v12, v13);
        grafo.connect(v16, v15);
        grafo.connect(v14, v16);
        grafo.connect(v14, v17);
        grafo.connect(v14, v18);
        grafo.connect(v18, v19);

        Metro metro = new Metro();
        LinkedList<Registro> camino = (LinkedList<Registro>) metro.menosTransbordos(grafo, "Butanta");
        for (Registro r : camino) {
            System.out.println(r);
        }
    }

}
