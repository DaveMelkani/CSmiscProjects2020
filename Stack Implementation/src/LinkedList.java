public class LinkedList<A> { // <T> allows us to use any data type

	// number of elements in list
	private int size;

	// reference to the front of the list
	private Node<A> head;
	
	// reference to the end of the list
	//private Node tail;

	public LinkedList() {
		// job of the constructor is to
		// initialize the instance variables
		size = 0;
		head = null;
	}

	// return the number of elements in the list
	public int size() {
		return size;
	}

	// returns the head reference
	public Node<A> peek() {
		return head;
	}
	
	
	

	// add a node at the end of the list!
	public void add(A a) {
		// what all needs to happen to add to the list?
		size++; // adding an element size increase!

		if (head == null) {
			Node n = new Node(a); // create a new node that
			// encapsulates the data a
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
		Node<A> temp = new Node<A>(a);//creating a new Node called temp 
		temp.next = head;
		head = temp;
		size++;
	}

	// remove the head of the list
	public Node<A> remove() {
		Node<A> temp = head;
		if(head != null) {
			head = head.next();
			size--;
		}
		return temp;
		
		
	}

	// remove Node at index i -> REQUIRES: i < size
	public Node<A> remove(int i) {
		if(i == 0) {
			return remove();
		}
		else {
			if(i+1 <= size && i >= 0) { //is i within the Node?
				int c = 0; // creating my counter variable for each tic
				Node<A> temp = head;
				while(c != i-1) {
					temp = temp.next();
					c++;
				}
				Node<A> dab = temp.next();
				temp.next = dab.next;
				
				size--;
				return dab;
			}
		}
		return null;
	}

	public boolean isCircular() {
		return false;
	}
}
