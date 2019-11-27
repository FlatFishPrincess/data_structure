package HeapPackage;

import java.util.Arrays;

/**
 * A class that implements the ADT maxheap by using an array.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 */
public final class MinHeap<T extends Comparable<? super T>> implements MinHeapInterface<T> {
	private T[] heap; // Array of heap entries; ignore heap[0]
	private int lastIndex; // Index of last entry and number of entries
	private static final int FRONT = 1;  // the first element in the heap

	private static final int DEFAULT_CAPACITY = 5; // NB: Changed to 5 from 25 for testing convenience
	private static final int MAX_CAPACITY = 10000;


	public MinHeap() {
		this(DEFAULT_CAPACITY); // Call next constructor
	} // end default constructor

	public MinHeap(int initialCapacity) {
		// NOTE: This code deviates from the book somewhat in that checkCapacity throws
		// an exception
		// if initialCapacity is either too small or too large.

		checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity + FRONT]; // First array element is not used
		heap = tempHeap;
		lastIndex = 0;

	} 

	/**
	 * Create a heap from an array of entries by reheap()ing as each is added
	 * @param entries
	 */
	public MinHeap(T[] entries) {
		this(entries.length); // Call other constructor
		// Assertion: integrityOK = true
		lastIndex = entries.length;

		// Copy given array to data field
		for (int index = FRONT; index <= lastIndex; index++)
			heap[index] = entries[index - 1];

		// Create heap. Start with the parent of the last index.
		for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
			reheap(rootIndex);
	}

	public void add(T newEntry) {
		
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2; // parent is always halfway up
		while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) < 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
	    } // end while
		// place the entry in the vacancy/leaf and bump the last index (last node of the tree)
	   heap[newIndex] = newEntry;
	   lastIndex++;
	   ensureCapacity();
	} 

	public T removeMin() {
		T root = null;
	   if (!isEmpty())
	   {
	      root = heap[1];            // Return value
	      heap[1] = heap[lastIndex]; // Form a semiheap
	      lastIndex--;               // Decrease size
	      reheap(1);                 // Transform to a heap
	   } // end if
		return root;
	} 

	public T getMin() {
		T root = null;
		if (!isEmpty())
			root = heap[1];
		return root;
	} 

	public boolean isEmpty() {
		return lastIndex < 1;
	} 

	public int getSize() {
		// your code goes here
		return lastIndex;
	} 

	public void clear() {
		heap = null;
		lastIndex = 0;
	}

	
	/**
	 * Transform a semiheap into a heap.
	 * 
	 * You will need to reheap whenever something is removed
	 * @param rootIndex
	 */
	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;
		while (!done && (leftChildIndex <= lastIndex)) {
			int smallerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			if ((rightChildIndex <= lastIndex) 
					&& heap[rightChildIndex].compareTo(heap[smallerChildIndex]) < 0) { 
				smallerChildIndex = rightChildIndex;
		}
			if (orphan.compareTo(heap[smallerChildIndex]) > 0) { 
				heap[rootIndex] = heap[smallerChildIndex]; 
				rootIndex = smallerChildIndex; 
				leftChildIndex = 2 * rootIndex;
			} else
			done = true;
		} 
		heap[rootIndex] = orphan;
	} 

	// Doubles the capacity of the array heap if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {
		int numberOfEntries = lastIndex;
		int capacity = heap.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			heap = Arrays.copyOf(heap, newCapacity + FRONT);
		} // end if
	} // end ensureCapacity


	// Throws an exception if the client requests a capacity
	// that is either too small or too large.
	private void checkCapacity(int capacity) {
		if (capacity < DEFAULT_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a heap " + "whose capacity is smaller than " + DEFAULT_CAPACITY);
		else if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a heap " + "whose capacity is larger than " + MAX_CAPACITY);
	} // end checkCapacity
	
	/**
	 * This is just for test purposes
	 */
	public void display() {
        for (int rootIndex = 1; rootIndex <= lastIndex / 2; rootIndex++ )
        {
        	int leftChildIndex = 2 * rootIndex;
        	int rightChildIndex = leftChildIndex + 1;
            System.out.print("PARENT: " + heap[rootIndex] + " LEFT CHILD: " + heap[leftChildIndex]);
            
            if(rightChildIndex <= lastIndex)
            	System.out.print( " RIGHT CHILD:" + heap[rightChildIndex]);
            System.out.println();
        }
    }
} // end MaxHeap
