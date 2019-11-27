package HeapPackage;

import java.util.Arrays;

/**
 * A class that implements the ADT maxheap by using an array.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
	private T[] heap; // Array of heap entries; ignore heap[0]
	private int lastIndex; // Index of last entry and number of entries

	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public MaxHeap() {
		this(DEFAULT_CAPACITY); // Call next constructor
	} // end default constructor

	public MaxHeap(int initialCapacity) {
		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initialCapacity too big?
			checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
	} // end constructor

	private void checkCapacity(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void add(T newEntry) {
		// See Segment 27.8.
	} // end add

	public T removeMax() {
		return null;
		// See Segment 27.12.
	} // end removeMax

	public T getMax() {
		T root = null;
		if (!isEmpty())
			root = heap[1];
		return root;
	} // end getMax

	private void checkIntegrity() {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmpty() {
		return lastIndex < 1;
	} // end isEmpty

	public int getSize() {
		return lastIndex;
	} // end getSize

	public void clear() {
		while (lastIndex > -1) {
			heap[lastIndex] = null;
			lastIndex--;
		} // end while
		lastIndex = 0;
	} // end clear

} // end MaxHeap
