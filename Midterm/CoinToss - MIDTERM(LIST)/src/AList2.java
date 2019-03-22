import java.util.Arrays;

/**
 * A class that implements a list of objects by using an array. Entries in a
 * list have positions that begin with 1. Duplicate entries are allowed.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class AList2<T> implements ListInterface<T> {
	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public AList2() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public AList2(int initialCapacity) {
		integrityOK = false;

		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else // Is initialCapacity too big?
			checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Object[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		integrityOK = true;
	} // end constructor

	// Doubles the capacity of the array list if it is full.
	// Precondition: checkIntegrity has been called.
	private void ensureCapacity() {
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			list = Arrays.copyOf(list, newCapacity + 1);
		} // end if
	} // end ensureCapacity

	// Throws an exception if this object is corrupt.
	private void checkIntegrity() {
		if (!integrityOK)
			throw new SecurityException("AList object is corrupt.");
	} // end checkIntegrity

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a list " + "whose capacity exceeds " + "allowed maximum.");
	} // end checkCapacity

	@Override
	public void add(T newEntry) {
		ensureCapacity();
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		ensureCapacity();
		if(newPosition > 0 && newPosition <= numberOfEntries+1){
			if(newPosition < numberOfEntries + 1){
				makeRoom(newPosition);
			}
			list[newPosition] = newEntry;
		}
	}
	
	private void makeRoom(int givenPosition) {
		for(int i = numberOfEntries; i >= givenPosition; i--){
			list[i + 1] = list[i];
		}
	} // end makeRoom
	
	@Override
	public T remove(int givenPosition) {
		T result = list[givenPosition];
		list[givenPosition] = null;
		removeGap(givenPosition);
		return result;
	}
	
	private void removeGap(int givenPosition){
		for(int i = givenPosition; i< numberOfEntries; i++){
			list[i] = list[i + 1];
		}
	}
	

	@Override
	public void clear() {
		list = null;
		numberOfEntries = 0;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		list[givenPosition] = newEntry;
		return list[givenPosition];
	}

	@Override
	public T getEntry(int givenPosition) {
		return list[givenPosition];
	}

	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[numberOfEntries];
		for(int i =0; i< numberOfEntries; i++){
			arr[i] = list[i + 1];
		}
		return arr;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean contains = false;
		for(int i = 1; i<= numberOfEntries; i++){
			if(list[i].equals(anEntry)){
				contains = true;
				break;
			}
		}
		return contains;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
} // end AList
