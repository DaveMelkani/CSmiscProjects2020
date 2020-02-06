import java.util.ArrayList;


public class Stack<T> {
//	DJDave123 :)
	private ArrayList<T> data;
	private int size;
	
	public Stack() {
		data = new ArrayList<T>();
	}
	
	public void push(T t) {
		data.add(t);
		size++;
	}
	
//	write a pop method
//	to remove the top element from the list
	public T pop() {
		size--;
		return data.remove(size);
	}

//	write the method peek which returns the last element
//	but does not remove it from the list
	public T peek() {
//		size-- -> size = size - 1;
		return data.get(size-1);
	}
		
//	write the isEmpty method which returns 
//	true if the stack is empty
	
	public int size() { // <--- following ArrayList size naming
		return size;
	}
	
	public int getSize() {
		return size;
	}
	
//	override so that Stack objects can be printed
	public String toString() {
		return data.toString();
	}
}
