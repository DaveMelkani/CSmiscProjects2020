import java.util.ArrayList;


public class LinkedList<A> {
	private ArrayList<A> data;
	private int size;
	
	public LinkedList() {
		data = new ArrayList<A>();
	}
	
	public A peek() {
		return data.get(size-1);
	}
	
	public void add(A a) {
		data.add(a);
		size++;
	}
	
	
	
	public int size() {
		return size;
	}
}
