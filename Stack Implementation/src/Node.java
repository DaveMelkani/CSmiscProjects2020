
public class Node<T> {
	private T data;
	public Node next;
//	public Node back;
	
	public Node(T t) {
		data = t;
		this.next = null;
	}
	
//	returns next ref
	public Node next() {
		return next;
	}
	
	
	
	public T getData() {
		return data;
	}
}
