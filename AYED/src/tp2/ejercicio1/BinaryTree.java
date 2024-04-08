package tp2.ejercicio1;
import tp1.ejercicio8.*; 

public class BinaryTree <T> {
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild;
	   
    public BinaryTree() {
	   	 super();
	}
    public BinaryTree(T data) {
   	     this.data = data;
   	}
    
    public T getData() {
	   	 return data;
    }
    public void setData(T data) {
	   	 this.data = data;
    }   
    public BinaryTree<T> getLeftChild() {
	   	 return leftChild;
    }
    public BinaryTree<T> getRightChild() {
	   	 return rightChild;	 
	}
	public void addLeftChild(BinaryTree<T> child){
	   	 this.leftChild = child;
    }
	public void addRightChild(BinaryTree<T> child) {
	   	 this.rightChild = child;
	}
    public void removeLeftChild() {
	   	 this.leftChild = null;
    }
    public void removeRightChild() {
	   	 this.rightChild = null;
    }
    public boolean isEmpty(){
      	 return (this.isLeaf() && this.getData() == null);
    }
    public boolean isLeaf() {
      	return (!this.hasLeftChild() && !this.hasRightChild());
    }
    public boolean hasLeftChild() {
      	 return this.leftChild!=null;
    }
    public boolean hasRightChild() {
      	 return this.rightChild!=null;
    }
    
    public int contarHojas() {
         if(this.isEmpty()) {
             return 0; 
         } else if (this.isLeaf()) {
        	 return 1; 
         } else {
        	 return (this.getLeftChild()).contarHojas() + (this.getRightChild()).contarHojas(); 
         }
    }
    
    public BinaryTree <T> espejo(){
        BinaryTree<T> mirror = new BinaryTree<T>(this.data); 
        if(this.hasLeftChild()){ 
            mirror.addRightChild(this.getLeftChild().espejo()); } //Se llama recursivamente 
        if(this.hasRightChild()){
            mirror.addLeftChild(this.getRightChild().espejo());  
        }
        return  mirror;
    }
    
    public void entreNiveles(int n, int m) {
    	BinaryTree<T> ab = null; int nivel = 0; 
    	Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
    	cola.enqueue(this); 
    	cola.enqueue(null); 
    	nivel++; 
    	while (!cola.isEmpty()) {
    		ab = cola.dequeue(); 
    		if (ab != null) {
    			if (nivel >= n && nivel <= m) {
    				System.out.print(ab.getData());
    			}
    			if (ab.hasLeftChild()) {
    				cola.enqueue(ab.getLeftChild()); 
    			}
    			if (ab.hasRightChild()) {
    				cola.enqueue(ab.getRightChild()); 
    			}
    		} else if (!cola.isEmpty()){
    			nivel++; 
    			System.out.println();
    			cola.enqueue(null); 
    		}
    	}
    }
    
    @Override
    public String toString() {
      	 return this.getData().toString();
    }
    
}
