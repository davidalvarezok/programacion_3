package tp5.ejercicio3;
import tp5.ejercicio1.*;
import java.util.List; 
import java.util.LinkedList; 

public class Mapa {
	private Graph<String> mapaCiudades; 

	public Mapa(Graph<String> g) {
		mapaCiudades = g; 
	}

	public List<String> devolverCamino (String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
		Boolean exito = false; 
	    
		boolean[] marca = new boolean [mapaCiudades.getSize()];
		Vertex<String> encontre = mapaCiudades.search(ciudad1); 
		System.out.println("Encontre ciudad1: "+encontre.getData());
		if (encontre != null) {
			dfs(encontre.getPosition(), marca, camino, ciudad2, exito);
		}
		return camino; //si_ciudad1_no_esta_devuelve_lista_vacia
	}
	
	private void dfs(int i, boolean[] marca, List<String> lista, String ciudad2, Boolean encontre) {
		marca[i] = true; 
		Vertex<String> v = mapaCiudades.getVertex(i);
		System.out.println(v.getData());
		lista.add(v.getData()); //Agrego ciudad
		if (v.getData() != ciudad2) {
		System.out.println("Ingreso al if ciudad2 != v.getData()");
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(v);
			for (Edge<String> e : adyacentes) {
				int j = e.getTarget().getPosition();
			    if (!marca[j]) {
				    dfs(j, marca, lista, ciudad2, encontre);
     			}
			    if (encontre) {
			    	break; 
			    }
		    }
			System.out.println("valor del encontre luego de procesar aristas "+encontre);
			if (adyacentes == null || !encontre) {
				System.out.println("Elimino el ult elemento");
			    lista.removeLast(); 
		    }
		} else { //caso_base
			encontre = true; 
			System.out.println(encontre);
		}
	}
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades) {
		List<String> camino = new LinkedList<String>(); 
		boolean[] marca = new boolean[mapaCiudades.getSize()]; 
		Vertex<String> v = mapaCiudades.search(ciudad1); 
		if (v != null) {
			dfs1(v.getPosition(), marca, camino, ciudades, ciudad2, false);
		}
		return camino; 
	}
	
	private void dfs1 (int i, boolean[] marca, List<String> camino, List<String> ciudades, String cd2, boolean encontre) {
		marca[i] = true; 
		Vertex<String> v = mapaCiudades.getVertex(i); 
		camino.add(v.getData()); //Agrego_la_ciudad
		if (v.getData() != cd2) {
			List<Edge<String>> adyacencias = mapaCiudades.getEdges(v);
			for (Edge<String> e : adyacencias) {
				int j = e.getTarget().getPosition(); 
				if (!marca[j]) {
					if (!ciudades.contains(e.getTarget().getData())) { //si_la_ciudad_NO_esta_en_la_lista
						dfs1(j, marca, camino, ciudades, cd2, encontre); 
					}
				}
				if (encontre) {
					break; 
				}
			}
			if (adyacencias == null || !encontre) {
				camino.removeLast(); 
			}
		} else { //caso_base 
			encontre = true; 
		}
	}
	
	public List<String> caminoMasCorto (String ciudad1, String ciudad2) {
		List<String> camino = new LinkedList<String>(); 
		boolean[] marca = new boolean[mapaCiudades.getSize()]; 
		Vertex<String> v = mapaCiudades.search(ciudad1); 
		if (v != null) {
			dfs2(v.getPosition(), marca, ciudad2, false);
		}
		return camino;  
	}
	
	private void dfs2 (int i, boolean[] marca, String cd2, boolean encontre) {
		 
	}
	
}
