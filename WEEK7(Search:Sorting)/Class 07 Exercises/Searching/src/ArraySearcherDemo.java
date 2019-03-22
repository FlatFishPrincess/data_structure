/**
 * A driver that demonstrates the class ArraySearcher.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class ArraySearcherDemo {
	public static void main(String[] args) {
		Integer[] unsortedArray = { 20, 24, 4, 12, 8, 14 };
		Integer[] sortedArray = { 4, 8, 12, 14, 20, 24 };

		System.out.println("Iterative sequential search of an unsorted array: ");
		ArraySearcher.display(unsortedArray);

		System.out.println(
				"Is 4 in the array? " + ArraySearcher.inUnsortedArrayIterative(unsortedArray, 4) + " (should be true)");
		System.out.println("Is 24 in the array? " + ArraySearcher.inUnsortedArrayIterative(unsortedArray, 24)
				+ " (should be true)");
		System.out.println("Is 14 in the array? " + ArraySearcher.inUnsortedArrayIterative(unsortedArray, 14)
				+ " (should be true)");
		System.out.println("Is 10 in the array? " + ArraySearcher.inUnsortedArrayIterative(unsortedArray, 10)
				+ " (should be false)");

		System.out.println("\nRecursive sequential search of an unsorted array: ");
		ArraySearcher.display(unsortedArray);
		System.out.println(
				"Is 4 in the array? " + ArraySearcher.inUnsortedArrayRecursive(unsortedArray, 4) + " (should be true)");
		System.out.println("Is 24 in the array? " + ArraySearcher.inUnsortedArrayRecursive(unsortedArray, 24)
				+ " (should be true)");
		System.out.println("Is 14 in the array? " + ArraySearcher.inUnsortedArrayRecursive(unsortedArray, 14)
				+ " (should be true)");
		System.out.println("Is 10 in the array? " + ArraySearcher.inUnsortedArrayRecursive(unsortedArray, 10)
				+ " (should be false)");

		System.out.println("\nRecursive binary search of a sorted array: ");
		ArraySearcher.display(sortedArray);

		System.out.println(
				"Is 4 in the array? " + ArraySearcher.inSortedArrayRecursive(sortedArray, 4) + " (should be true)");
		System.out.println(
				"Is 24 in the array? " + ArraySearcher.inSortedArrayRecursive(sortedArray, 24) + " (should be true)");
		System.out.println(
				"Is 14 in the array? " + ArraySearcher.inSortedArrayRecursive(sortedArray, 14) + " (should be true)");
		System.out.println(
				"Is 3 in the array? " + ArraySearcher.inSortedArrayRecursive(sortedArray, 3) + " (should be false)");
		System.out.println(
				"Is 15 in the array? " + ArraySearcher.inSortedArrayRecursive(sortedArray, 15) + " (should be false)");
		System.out.println(
				"Is 30 in the array? " + ArraySearcher.inSortedArrayRecursive(sortedArray, 30) + " (should be false)");
	} // end main
} // end Driver
/*
 Iterative sequential search of an unsorted array:
 The array contains the following entries: 20 24 4 12 8 14
 Is 4 in the array? true (should be true)
 Is 24 in the array? true (should be true)
 Is 14 in the array? true (should be true)
 Is 10 in the array? false (should be false)
 
 Recursive sequential search of an unsorted array:
 The array contains the following entries: 20 24 4 12 8 14
 Is 4 in the array? true (should be true)
 Is 24 in the array? true (should be true)
 Is 14 in the array? true (should be true)
 Is 10 in the array? false (should be false)
 
 Recursive binary search of a sorted array:
 The array contains the following entries: 4 8 12 14 20 24
 Is 4 in the array? true (should be true)
 Is 24 in the array? true (should be true)
 Is 14 in the array? true (should be true)
 Is 3 in the array? false (should be false)
 Is 15 in the array? false (should be false)
 Is 30 in the array? false (should be false)
 
 */
