
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> myStrs = new Stack<String>();
		myStrs.push("Hello");
		System.out.println(myStrs.pop());
		System.out.println(myStrs.size());
		
		Stack<Integer> myNums = new Stack<Integer>();
		myNums.push(666);
		System.out.println(myNums);
		
		Stack<Dave> daves = new Stack<Dave>();
		daves.push(new Dave()); //shows you can have a seperate class
	}

}

class Dave {
//	dave = dabawesome :)
}