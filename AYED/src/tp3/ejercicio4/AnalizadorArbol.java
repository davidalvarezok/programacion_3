package tp3.ejercicio4;
import tp3.ejercicio2.GeneralTree;
import java.util.List;
import java.util.LinkedList;
import tp1.ejercicio8.Queue;

public class AnalizadorArbol {

	public static void main(String[] args) {
		AreaEmpresa area = new AreaEmpresa("M",14); 
		GeneralTree<AreaEmpresa> ag = new GeneralTree<AreaEmpresa>(area); //Agregamos un elemento 
		//Fill the tree
		System.out.println(devolverMaximoPromedio(ag));

	}
	
	private static List<Integer> traversalLevel(GeneralTree<AreaEmpresa> tree) {
		 
		int total = 0, cant = 0;
		List<Integer> result = new LinkedList<Integer>();
		GeneralTree<AreaEmpresa> tree_aux; 
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
		queue.enqueue(tree);
	    result.add(tree.getData().tiempo); //Agrego el primer promedio 
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
		    List<GeneralTree<AreaEmpresa>> children = tree_aux.getChildren();
		    for (GeneralTree<AreaEmpresa> child: children) {
		    	queue.enqueue(child);
		    	cant += child.getData().tiempo;
		    	total++; 
		    }
		    if (children != null) {
		    	result.add(cant/total); //Calculo promedio de los hijos
		    }
		}
	    return result;
	}
	
	public static int devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		List<Integer> prom = traversalLevel(arbol);
		int max = -1; 
		for (Integer valor : prom) {
			if (valor > max) {
				max = valor; 
			}
		}
		return max; 
	}

}
