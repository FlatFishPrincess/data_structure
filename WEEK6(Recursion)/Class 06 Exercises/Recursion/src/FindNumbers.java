
public class FindNumbers {
	private static int numberOfRounds = 0;

	public static void main(String[] args) {

		int[] array = { 5, 300, 24, 22, 23, 900, 320, 901 };
		System.out.print("Array len " + array.length + ": ");
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
		numberOfRounds = 0;
		System.out.println("Largest is " + findLargest(array, 0, array.length - 1) + " in " + numberOfRounds + " rounds");
		System.out.println();

		int[] sortedArray = { 2, 4, 6, 8, 10, 11, 12, 13 };
		System.out.print("Sorted Array len " + sortedArray.length + ": ");
		for (int i : sortedArray)
			System.out.print(i + " ");
		System.out.println();

		numberOfRounds = 0;
		int number = 6;
		int position = findPosition(number, sortedArray, 0, sortedArray.length - 1);
		System.out.println("Found " + number + " in position " + position + " in " + numberOfRounds + " rounds");

	}

	/**
	 * Find the largest number in an array. Array is not necessarily sorted. Compare
	 * the bottom of an array with the top. Choose the largest if we are in the
	 * middle Otherwise split the array in half and do it again for both halves.
	 * 
	 * @param array input array
	 * @param low index of the lowest value
	 * @param high index of the highest value
	 * @return
	 */
	static int findLargest(int[] array, int low, int high) {
		numberOfRounds++;
		System.out.println("FindLargest " + array[low] + "[" + low + "] " + array[high] + "[" + high + "]");

		// figure out the midpoint, if we are in the middle (1 or 2 elements) pick the
		// largest

		int mid = (low + high) / 2;
		if (mid == low || mid == high)
			if (array[low] >= array[high])
				return array[low];
			else
				return array[high];

		// otherwise recursively call method on the upper and lower half of the array

		System.out.print("Upper half [" + mid + "," + high + "] - ");
		int x = findLargest(array, mid, high);		
		System.out.println("Chose highest as " + x);
		
		System.out.print("Lower half [" + low + "," + mid + "] - ");
		int y = findLargest(array, low, mid);
		System.out.println("Chose highest as " + y);
		
		System.out.println("Compare " + x + " to " + y);
		if (x >= y)
			return x;
		else
			return y;
	}

	/**
	 * Find the position of a number in an  array. Note that low and high are zero
	 * offset rather than counting from 1.
	 * 
	 * @param number
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	static int findPosition(int number, int[] array, int low, int high) {
		numberOfRounds++;
		int mid = (low + high) / 2;
		if (number == array[mid])
			return mid;
		// we didn't find it!!
		if(mid == low || mid == high)
			return -1;
		
		// recursively call using upper and lower halves of array
		if (number > array[mid])
			return findPosition(number, array, mid, high);
		else
			return findPosition(number, array, 0, mid);
	}

}
