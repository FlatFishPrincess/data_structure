/**
 * Demonstrates use of sorted lists that insert an element in a sorted position each time.
 * @author mhrybyk
 *
 */
public class SortedListDemo {

	public static void main(String[] args) {
		

		ListInterface<String> originalListOfIntegers = new AList<>();

		// first generate a list of integers, and display them
		
		DemoUtilities.generateListOfNumbers(originalListOfIntegers, 10, 20);
		DemoUtilities.display(originalListOfIntegers, "Original List of random Integers");
		
		// comment out one SortedList to test the other

//		IterativeSortedLList<String> sortedListOfIntegers = new IterativeSortedLList<>();
		SortedAList<String> sortedListOfIntegers = new SortedAList<>();
		
		// copy the original list to the sorted list. copy method uses add() so
		//  items will be inserted in order
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, sortedListOfIntegers);


		DemoUtilities.display(sortedListOfIntegers, "List of Sorted Integers");

		sortedListOfIntegers.add("31");
		sortedListOfIntegers.add("32");

		DemoUtilities.display(sortedListOfIntegers, "Sorted Integers with 31 and 32 added");

		sortedListOfIntegers.removeEntry("31");
		sortedListOfIntegers.remove(2);
		DemoUtilities.display(sortedListOfIntegers, "Sorted Integers 31 and position 2 removed");
	}

}
