package practice;

import java.util.ArrayList;

public class OrderedPairDemo{

	private static final int MAX = 10;
	
	public static void main(String[] args) {
		
		ArrayList<OrderedPair<Integer>> myList = new ArrayList<>();
		for(int i = 0; i<10; i++){
			myList.add(new OrderedPair<Integer>(1,i));
		}
		
		// without toString method, returns object 
		// but toString is never called
		for(int i = 0; i < myList.size(); i++)	{	
			System.out.println(myList.get(i));
		}
	}

}