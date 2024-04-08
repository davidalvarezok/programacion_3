package tp1.ejercicio8;

public class CircularQueue <T> extends Queue <T> {
	public T shift () {
		T data = dequeue(); //Obtengo el primer elemento de la cola
		enqueue(data); //Lo agrego al final de la cola 
		return data; 
	}

}
