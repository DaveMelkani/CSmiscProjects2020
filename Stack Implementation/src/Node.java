
public class Node<T> {
	private T data;
	private Node next;
	
	public Node(T t) {
		data = t;
	}
	
//	returns next ref
	public Node next() {
		return next;
	}
	
	
}
