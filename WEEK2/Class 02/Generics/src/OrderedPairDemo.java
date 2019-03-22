import java.util.ArrayList;

/**
 * 
 */

/**
 * 
 * Test demo of OrderedPair class implementing Pairable interface
 * Shows use of generics
 * @author mhrybyk
 *
 */
public class OrderedPairDemo {

	private static final int NPAIRS = 10;

	public static void main(String[] args) {
		
		ArrayList<OrderedPair<Integer>> pairs = new ArrayList<>();
		
		// add ordered pairs to the list
		
		for(int i = 1; i < NPAIRS; i++)
			pairs.add(new OrderedPair<Integer>(1,i));
		
		System.out.println("Displaying pairs");
		for(int i = 0; i < pairs.size(); i++)	{	
			System.out.println(pairs.get(i));
			pairs.get(i).changeOrder();		
		}
		
		System.out.println("Displaying pairs after changed order");
		for(int i = 0; i < pairs.size(); i++)		
			System.out.println(pairs.get(i));

		// illegal! String array cannot used as generic 
//		OrderedPair<String>[] pairsOfStrings = new OrderedPair<String>[NPAIRS];
	}

}
