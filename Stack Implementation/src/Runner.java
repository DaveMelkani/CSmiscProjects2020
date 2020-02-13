
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Stack<String> myStrs = new Stack<String>();
//		myStrs.push("Hello");
//		System.out.println(myStrs.pop());
//		System.out.println(myStrs.size());
//		
//		Stack<Integer> myNums = new Stack<Integer>();
//		myNums.push(666);
//		System.out.println(myNums);
//		
//		Stack<Dave> daves = new Stack<Dave>();
//		daves.push(new Dave()); //shows you can have a seperate class
		
//		LinkedList<String> dabStrs = new LinkedList<String>();
		
		Node head = new Node(10);
		Node second = new Node(8);
		Node third = new Node(1);
		Node fourth = new Node(11);
		
		head.next = second;
		head.next = third;
		head.next = fourth;
		
		LinkedList linklist = new LinkedList();
		linklist.addFront(head);
		System.out.println();
		head = linklist.remove();
		
	}

}

//class Dave {
////	dave = dabawesome :)
//}