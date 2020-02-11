public class LinkedList<A> { // <T> allows us to use any data type

	// number of elements in list
	private int size;

	// reference to the front of the list
	private Node head;

	public LinkedList(int s) {
		// job of the constructor is to
		// initialize the instance variables
		size = s;
		head = null;
	}

	// return the number of elements in the list
	public int size() {
		return size;
	}

	// returns the head reference
	public Node peek() {
		return head;
	}

	// add a node at the end of the list!
	public void add(A a) {
		// what all needs to happen to add to the list?
		size++; // adding an element size increase!

		if (head == null) {
			 Node n = new Node(a); // create a new node that encapsulates the data a
			head = n; // head reference now points to this first node
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			// we know it is not the end of the list unless
			// the next Node reference is pointing to null
			temp = temp.next;
		}
		// if we hit the end of the loop, we know next is null!
		// aka end of the list!
		temp.next = new Node(a); // done!
	}

	// add a node at the beginning of the list
	public void addFront(A a) {
		
	}

	// remove the head of the list
	public Node remove() {
		size--;
		Node temp = head;
		if(temp.next != null) {
			temp = temp.next;
		}
		temp = null;
		return temp;
	}

	// remove Node at index i -> REQUIRES: i < size
	public Node remove(int i) {
		return null;
	}

	public boolean isCircular() {
		return false;
	}
}
