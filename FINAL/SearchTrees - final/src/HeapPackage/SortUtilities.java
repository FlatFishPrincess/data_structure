package HeapPackage;
/**
 * Set of utility sort methods.
 * 
 * Although utility methods are not recommended in OO design, this keeps the code simple
 * and in one place for demonstrating all of the sorting algorithms.
 * 
 * All work against any class that implements ListInterface with a type that is Comparable
 * 
 * All of the sort methods use the list methods rather than the typical array, list, ... .
 * 
 * Note that most methods are inefficient unless arrays are used. getEntry() and replace()
 * are efficient when used with arrays. These are the only methods actually used from ListInterface.
 * 
 * This is a different approach from the textbook where a new class is created for each sort algorithm.
 * 
 * 
 * @author mhrybyk
 *
 */
public final class SortUtilities <T extends Comparable<? super T>>  {
	
	private SortUtilities() {}; // to prevent instantiation

	/**
	 * Swap the data in the given positions in the list
	 * 
	 * @param list
	 * @param first  position to swap
	 * @param second position to swap
	 */
	static public <T> void swap(ListInterface<T> list, int first, int second) {

		if (first == second || list == null)
			return;

		T firstEntry = list.getEntry(first);
		T secondEntry = list.getEntry(second);

		list.replace(first, secondEntry);
		list.replace(second, firstEntry);

	}

	/**
	 * Selection sort
	 * 
	 * iterate through the list, finding the smallest in the rest of the list then swapping
	 * @param list
	 * @param first beginning of range to sort
	 * @param last end of range to sort
	 */	
	static public <T extends Comparable<? super T>> void selectionSort(ListInterface<T> list, int first, int last) {

		for (int index = first; index <= last; index++) {
			// find the smallest in the rest of the list, then swap
			int nextSmallest = findSmallest(list, index, last);
			swap(list, index, nextSmallest);
		}
	}
	
	/**
	 * Recursive Selection sort
	 * 
	 * finding the smallest in the rest of the list swap, then recursively call again
	 * @param list
	 * @param first beginning of range to sort
	 * @param last end of range to sort
	 */	
	static public <T extends Comparable<? super T>> void recursiveSelectionSort(ListInterface<T> list, int first,
			int last) {

		if (first < last) {
			int nextSmallest = findSmallest(list, first, last);
			swap(list, first, nextSmallest);
			recursiveSelectionSort(list, first + 1, last);

		}
	}
	/**
	 * return the index (position) of the smallest entry in the list
	 * @param list
	 * @param first
	 * @param last
	 * @return
	 */
	static private <T extends Comparable<? super T>> int findSmallest(ListInterface<T> list, int first, int last) {
		T minimum = list.getEntry(first);

		int indexOfMinimum = first;

		for (int index = first + 1; index <= last; index++) {
			T temp = list.getEntry(index);
			if (temp.compareTo(minimum) < 0) {
				minimum = temp;
				indexOfMinimum = index;
			}
		}

		return indexOfMinimum;

	}


	/**
	 * Insertion sort
	 * 
	 * Get the next entry in a list. A sub list then exists of all prior entries.
	 * 
	 * Iterate through the sub list of prior entries, and then insert the current entry in
	 * the correct sorted position in the sub list.
	 * 
	 * Then iteratively get the next entry.
	 * 
	 * 
	 * @param list
	 * @param first
	 * @param last
	 */
	static public <T extends Comparable<? super T>> void insertionSort(ListInterface<T> list, int first, int last) {

		// iterate through the list, start with the second entry
		
		for (int unsorted = first + 1; unsorted <= last; unsorted++) {
			T current = list.getEntry(unsorted);
			// compare the current entry with the sub list and insert in order. Note
			// that the sub list ends prior to the current entry
			insertInOrder(current, list, first, unsorted - 1);
		}
	}

	/**
	 * Recursive insertion sort
	 * 
	 * Recursively call insertion sort until we only have a list of one, then begin to insert
	 * the current entry into the sorted sub list portion.
	 * @param list
	 * @param first
	 * @param last
	 */
	static public <T extends Comparable<? super T>> void recursiveInsertionSort(ListInterface<T> list, int first,
			int last) {
		if (first < last) {
			insertionSort(list, first, last - 1);
			T next = list.getEntry(last);
			insertInOrder(next, list, first, last - 1);
		}
	}

	/**
	 * Compare an item to each list entry and insert it in the proper position. 
	 * 
	 * 
	 * @param item
	 * @param list
	 * @param first
	 * @param last
	 */
	static public <T extends Comparable<? super T>> void insertInOrder(T item, ListInterface<T> list, int first,
			int last) {
		
		// work from the last to first, since we have to shift items
		
		int index = last;

		for (; index >= first; index--) {
			T current = list.getEntry(index);
			// shift the item to the right if it is larger
			if (current.compareTo(item) > 0)
				list.replace(index + 1, current);
			else
				break;
		}
		// went one too far, replace current item in the right slot.
		list.replace(index + 1, item);

	}

	/**
	 * Shell Sort
	 * 
	 * Variation on insertion sort by using a set of intervals and then gradually decreasing the intervals
	 * @param list
	 * @param first
	 * @param last
	 */

	static public <T extends Comparable<? super T>> void shellSort(ListInterface<T> list, int first, int last) {

		int space = (last - first + 1) / 2; // initial interval is array size divided by 2

		while (space > 0) {
			for (int begin = first; begin <= (first + space - 1); begin++) {
				incrementalInsertionSort(list, begin, last, space);
			}

			space /= 2;
		}
	}

	/**
	 * Sort an interval sublist where each item position in the array to be sorted is offset by space.
	 * @param list
	 * @param first
	 * @param last
	 * @param space
	 */
	static private <T extends Comparable<? super T>> void incrementalInsertionSort(ListInterface<T> list, int first,
			int last, int space) {

		for (int unsorted = (first + space); unsorted <= last; unsorted += space) {
			int index = unsorted - space;
			T nextToInsert = list.getEntry(unsorted);
			for (; index >= first; index -= space) {
				T current = list.getEntry(index);
				if (current.compareTo(nextToInsert) > 0)
					list.replace(index + space, current);
				else
					break;
			}

			list.replace(index + space, nextToInsert);

		}

	}

	/**
	 * Merge sort
	 * 
	 * Divide the list in half, and then recursively sort until a list of size 2 is found.
	 * Sort each list, then merge the respective small lists together until the entire list
	 * is sorted.
	 * @param list
	 * @param first
	 * @param last
	 */
	@SuppressWarnings("unchecked")
	static public <T extends Comparable<? super T>> void mergeSort(ListInterface<T> list, int first, int last) {
		
		// uses a temp array for the merge. 
		// create it now, then call a helper method to actually implement the sort
		
		Object[] tempArray = list.toArray();  // because we need an object that implements Comparable

		T[] temp = (T[]) tempArray;

		// this is probably not necessary
		
		for (int i = 0; i < temp.length; i++)
			temp[i] = null;

		mergeSort(list, temp, first, last);
	}
	
	/**
	 * Helper method that implements recursive merge sort
	 * @param list
	 * @param temp temp list to use so it does not have to be recreated on each recursive call
	 * @param first
	 * @param last
	 */

	static private <T extends Comparable<? super T>> void mergeSort(ListInterface<T> list, T[] temp, int first,
			int last) {
		if (first < last) {
			
			// find the midpoint
			int middle = first + (last - first) / 2;
			
			// sort each 
			
			mergeSort(list, temp, first, middle);
			
			mergeSort(list, temp, middle + 1, last);
			
			// then merge the two 
			
			merge(list, temp, first, middle, last);
		}
	}

	static private <T extends Comparable<? super T>> void merge(ListInterface<T> list, T[] temp, int first, int middle,
			int last) {
		
		// copy items to temp array
		
		for (int i = first; i <= last; i++) {
			temp[i] = list.getEntry(i);
		}
		
		// merge the first with the second half
		// set up the indices
		
		int beginFirstHalf = first;
		int beginSecondHalf = middle + 1;
		int index = first;   // slot to place the merged item into
		
		// iterate through each half, comparing items
		// put the smallest one back on the original list in the next slot
		
		while (beginFirstHalf <= middle && beginSecondHalf <= last) {
			
			T firstHalfItem = temp[beginFirstHalf];
			T secondHalfItem = temp[beginSecondHalf];
			
			// the first half has the smaller item
			
			if (firstHalfItem.compareTo(secondHalfItem) <= 0) {
				list.replace(index, temp[beginFirstHalf]);
				beginFirstHalf++;
			} else {        // or else the second half does
				list.replace(index, temp[beginSecondHalf]);
				beginSecondHalf++;
			}
			index++;  
		}
		
		// are there any more in the first half?, if so add them in
		
		while (beginFirstHalf <= middle) {
			list.replace(index, temp[beginFirstHalf]);
			index++;
			beginFirstHalf++;
		}
	}

	/**
	 * Quick sort
	 * 
	 * Sort using a pivot value. In this implementation, we use the last element as the initial pivot
	 * @param list
	 * @param first
	 * @param last
	 */
	static public <T extends Comparable<? super T>> void quickSort(ListInterface<T> list, int first, int last) {
		if (first < last) {
			int pivotIndex = partition(list, first, last);
			// sort around the pivot index, splitting the list
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}

	}

	/**
	 * Partition the list with a new pivot, starting with the last
	 * @param list
	 * @param first
	 * @param last
	 * @return
	 */
	static private <T extends Comparable<? super T>> int partition(ListInterface<T> list, int first, int last) {
	
		T pivotValue = list.getEntry(last);
		int pivotIndex = last;
		
		// index to compare to pivot
		
		int indexFromLeft = first;       // start at the beginning of the list
		int indexFromRight = last - 1;   // pivot is at the back, so start one before it

		boolean done = false;
		
		while(!done) {
			
			// compare the left half of the array to the pivot until
			// we find one equal or greater
			
			T leftValue = list.getEntry(indexFromLeft);
			
			while(leftValue != null && leftValue.compareTo(pivotValue) < 0) {
				indexFromLeft++;
				leftValue = list.getEntry(indexFromLeft);
			}
			
			// do the same for right half, but find one less than or equal to
			
			T rightValue = list.getEntry(indexFromRight);
			
			while(rightValue != null && rightValue.compareTo(pivotValue) > 0) {
				indexFromRight--;
				rightValue = list.getEntry(indexFromRight);
			}

			// we now have one that is greater on the left, and less on the right
			// if the indices aren't equal, swap the values
			
			if(indexFromLeft < indexFromRight) {
				swap(list, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else done = true;
		}
		
		// finally, the left index value is the largest, so swap with pivot
		
		swap(list, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;
		
		return pivotIndex;
	}

	/**
	 * Heap sort using reheap to create an initial semiheap.
	 * Then swap last element with root and reheap until complete.
	 * @param list
	 * @param first
	 * @param last
	 */
	static public <T extends Comparable<? super T>> void heapSort(ListInterface<T> list, int first, int last) {
		// Create first heap
		for (int rootIndex = (last / 2); rootIndex >= first; rootIndex--)
			reheap(list, rootIndex, last);

		// exchange the last with the root, and reheap.
		
		// continue reheap until we have iterated through all of the elements
		// starting with the last element
		
		swap(list, 0, last);

		for (int lastIndex = last - 1; lastIndex > 0; lastIndex--) {
			reheap(list, 0, lastIndex);
			swap(list, 0, lastIndex);  // swap and reheap
		} 
	} 

	/**
	 * Using a list instead of an array, create a heap from a semiheap
	 * @param list
	 * @param rootIndex
	 * @param lastIndex
	 */
	static public <T extends Comparable<? super T>> void reheap(ListInterface<T> list, int rootIndex, int lastIndex) {
		boolean done = false;
		
		T orphan = list.getEntry(rootIndex);
		System.out.println("reheap rootindex " + rootIndex + " last " + lastIndex + " orphan " + orphan);
		
		// children start at double the root index
		
		// left child is one more
		
		int leftChildIndex = (2 * rootIndex) + 1;

		while (!done && (leftChildIndex <= lastIndex)) {
			
			// assume left child is the larger one
			
			int largerChildIndex = leftChildIndex;
			
			// right child is one more than left
			
			int rightChildIndex = leftChildIndex + 1;
			
			// get the right child data. left child data is the largest
			T rightChild = list.getEntry(rightChildIndex);
			T largerChild = list.getEntry(largerChildIndex);
			
			// if right is larger than left, then set larger to right child
			if ((rightChildIndex <= lastIndex) && rightChild.compareTo(largerChild) > 0) {
				largerChildIndex = rightChildIndex;
				largerChild = rightChild;
			} 
			
			// if our current root list smaller, move the larger to the root
			// and then go to its child
			// otherwise we are done
			if (orphan.compareTo(largerChild) < 0) {
				list.replace(rootIndex, largerChild);
				rootIndex = largerChildIndex;
				leftChildIndex = (2 * rootIndex) + 1;
			} else
				done = true;
		} 

		// set the current root value to the (possibly redefined) root slot
		
		list.replace(rootIndex, orphan);
	}
}
