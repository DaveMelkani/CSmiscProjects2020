import java.util.*;

public class DemoGoodToKnow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dab = 423403;

		switch (dab) {
		
		case 0:
			System.out.println("val is 0");
			break;
		case 1:
			System.out.println("3");
			break;
		case 5:
			System.out.println("found the cake :)");
			break;
			
		default: 
			System.out.println("Default case - all other case");
			
		}
		
		// using Queues in Java!
		ArrayDeque<Integer> myQ = new ArrayDeque<Integer>();
		
		// now myQ behaves like a queue
		// first in -> first out
		
		myQ.push(1);
		myQ.push(12);
		myQ.push(24);
		myQ.push(22);
		System.out.println(myQ.getLast() + " should be 1");
		
		
		//try catches
		
		try{
			//when something throws an exception
			//or you might want to handle exceptions in this way
			int[] x = null;
			x[1] = 5;
			
			int x2 = 1;
			x2 = x2/0;
			
		}catch(NullPointerException n) {
			System.out.println("null pointer exception handler");
		
		}catch(Exception e) { //Exception covers all cases
			System.out.println("handled all other exceptions!" +e);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
