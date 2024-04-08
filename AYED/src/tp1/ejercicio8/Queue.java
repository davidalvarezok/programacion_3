package tp1.ejercicio8;
import java.util.*; 

public class Queue <T> extends Sequence {
	List<T> data;
	
	public Queue () {
		this.data = new ArrayList<T>(); 
	}
	public void enqueue(T dato) {
		data.add(dato); 
	}
	public T dequeue() {
		return data.remove(0); 
	}
	public T head() {
        return data.get(0);
    }
	@Override
	public boolean isEmpty() {
	    return data.size()==0;
	}
	@Override 
	public int size() {
	    return data.size();
	}
	
	@Override
	public String toString() {
	    String str = "[";
	    for(T d: data)
	       str = str + d +", ";
	    str = str.substring(0, str.length()-2)+"]";
	    return str;
	}

}