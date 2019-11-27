package HeapPackage;

/**
 * Demonstrates use of sort algorithms. 
 * 
 * Change the SortUtilities method to demonstrate a particular algorithm.
 * @author mhrybyk
 *
 */

public class SortDemo {

	public static void main(String[] args) {

		// make two lists of integers, each the same, so we can compare sort methods
		
		ListInterface<String> originalListOfIntegers = new AList<>();
		ListInterface<String> aListOfIntegers = new AList<>();
			
		// first generate a list of integers, and display them
		
		DemoUtilities.generateListOfNumbers(originalListOfIntegers, 10, 20);
		DemoUtilities.display(originalListOfIntegers, "Original List of random Integers");
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);	
		SortUtilities.selectionSort(aListOfIntegers, 0, aListOfIntegers.size() - 1);	
		DemoUtilities.display(aListOfIntegers, "Integers Selection Sort");
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		SortUtilities.heapSort(aListOfIntegers, 0, aListOfIntegers.size() - 1);			
		DemoUtilities.display(aListOfIntegers, "Integers Heap Sort");		
		
	}

}
