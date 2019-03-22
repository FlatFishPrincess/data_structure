/**
 * Demonstrates use of sort algorithms. 
 * 
 * Change the SortUtilities method to demonstrate a particular algorithm.
 * @author mhrybyk
 *
 */

public class TimedSortDemo {

	public static void main(String[] args) {

		// make two lists of integers, each the same, so we can compare sort methods
		long startTime;
		long endTime;
		
		int startingInteger = 10000000;
		
		int[] testListSizes = {10000, 100000, 1000000, 10000000, 100000000, 100000000};
		
		
		for(int size : testListSizes) {
			
			// create a list of random numbers of a a particular size, and copy to the test list
			ListInterface<String> originalListOfIntegers = new AList<>(size);
			ListInterface<String> testListOfIntegers = new AList<>(size);
			DemoUtilities.generateListOfNumbers(originalListOfIntegers, startingInteger, size);
			
			System.out.println("Testing sorting of list size " + size);
			
			// sort test for each sorting method
			// first copy the original list of random numbers to the test list
			// set the starting time
			// run the sort method on the test list
			// get the end time
			// display the elapsed time result
			
			DemoUtilities.copyListOfNumbers(originalListOfIntegers, testListOfIntegers);
			startTime = System.nanoTime();
			SortUtilities.selectionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println("Selection Sort Time = " + (endTime - startTime));

			// do the same for each sorting method 
			
//			------------Insertion Sort Time -----------------------
			startTime = System.nanoTime();
			SortUtilities.insertionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println("Insertion Sort Time = " + (endTime - startTime));
			
//			----------- Recursive Insertion Sort Time ------------------
			startTime = System.nanoTime();
			SortUtilities.recursiveInsertionSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println("Recursive Sort Time = " + (endTime - startTime));
			
//			------------Shell Sort Time --------------------
			startTime = System.nanoTime();
			SortUtilities.shellSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println("Shell Sort Time = " + (endTime - startTime));
			
//			----------- Merge Sort Time --------------------
			startTime = System.nanoTime();
			SortUtilities.mergeSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println("Merge Sort Time = " + (endTime - startTime));
			
//			-------------- Quick Sort Time ----------------
			startTime = System.nanoTime();
			SortUtilities.quickSort(testListOfIntegers, 0, testListOfIntegers.size() - 1);	
			endTime = System.nanoTime();
			System.out.println("Quick Sort Time = " + (endTime - startTime));
			
			System.out.println("------------------------");
		}
	
		
	}

}
