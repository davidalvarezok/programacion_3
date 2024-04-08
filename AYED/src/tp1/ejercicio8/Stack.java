package tp1.ejercicio8;
import java.util.*; 

public class Stack<T> extends Sequence {
	private List<T> data; 
	
	public Stack () {
		data = new ArrayList<T>(); 
	}
	
	public void push(T dato) {
		data.add(0, dato);
	}
	
	public T pop() {
		return data.remove(0); 
	}
	
	public T top() {
		return data.get(0); 
	}
	
	@Override
	public int size() {
	    return data.size();
	}
	@Override
    public boolean isEmpty() {
	    return data.size()==0;
	}
	@Override
	public String toString() {
	String str = "[";
	for(T d: data)
	    str = str + d +", ";
	    str = str.substring(0,str.length()-2)+"]";
	    return str;
	}

}
