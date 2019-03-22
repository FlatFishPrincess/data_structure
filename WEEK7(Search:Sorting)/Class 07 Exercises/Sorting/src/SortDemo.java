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
		LinkedGroup<String> linkedGroupListOfIntegers = new LinkedGroup<>();	
		SortInterface<String> sortAListOfIntegers = new InsertionSortAList<>();
			
		// first generate a list of integers, and display them
		
		DemoUtilities.generateListOfNumbers(originalListOfIntegers, 10, 20);
		DemoUtilities.display(originalListOfIntegers, "Original List of random Integers");
		
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, aListOfIntegers);
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, linkedGroupListOfIntegers);
		DemoUtilities.copyListOfNumbers(originalListOfIntegers, sortAListOfIntegers);
		
		SortUtilities.selectionSort(originalListOfIntegers, 0, originalListOfIntegers.size() - 1);	
		DemoUtilities.display(originalListOfIntegers, "Integers Selection Sort");
		
		SortUtilities.insertionSort(aListOfIntegers, 0, originalListOfIntegers.size() - 1);			
		DemoUtilities.display(aListOfIntegers, "Integers Insertion Sort");		
		
		linkedGroupListOfIntegers.sort();		
		DemoUtilities.display(linkedGroupListOfIntegers, "Integers Linked Group Insertion Sort");
		
		sortAListOfIntegers.sort(0, sortAListOfIntegers.size() - 1);;		
		DemoUtilities.display(sortAListOfIntegers, "Integers InsertionSortAList");
	}

}
