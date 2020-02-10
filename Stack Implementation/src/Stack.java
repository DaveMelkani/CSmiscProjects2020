import java.util.ArrayList;


public class Stack<S> { //--> <T> allows you to generalize the TYPE stored in the class
//	DJDave123 :)
	private ArrayList<S> data; //<T> works b/c of line 3 which represents the TYPE as T
	private int size;
	
	public Stack() {
		data = new ArrayList<S>();
	}
	
	public void push(S s) {
		data.add(s);
		size++;
	}
	
//	write a pop method
//	to remove the top element from the list
	public S pop() {
		size--;
		return data.remove(size);
	}

//	write the method peek which returns the last element
//	but does not remove it from the list
	public S peek() {
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
