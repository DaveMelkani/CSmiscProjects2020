import java.util.ArrayList;


public class Queue<Q> {
	private ArrayList<Q> dab;
	private int big;
	public Queue() {
		dab = new ArrayList<Q>();
	}
	
//	enqueue
	public void add(Q q) {
		dab.add(q);
		big++;
	}
	
//	dequeue
	public Q remove() {
		Q q = dab.remove(0);
		big--;
		return q;
	}
	
	public Q peek() {
		return dab.get(0);
	}
	
	public int size() {
		return big;
	}
	
	public int getSize() {
		return big;
	}
	
	public String toString() {
		return dab.toString();
	}
}
