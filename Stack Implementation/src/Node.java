
public class Node<T> {
	private T data;
	public Node next;
	public Node back;
	
	public Node(T t) {
		data = t;
	}
	
//	returns next ref
	public Node next() {
		return next;
	}
	
	public Node back() {
		return back;
	}
	
	public T getData() {
		return data;
	}
}
