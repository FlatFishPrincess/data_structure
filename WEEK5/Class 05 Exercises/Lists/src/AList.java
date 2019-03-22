import java.util.Arrays;

/**
 * A class that implements a list of objects by using an array. Entries in a
 * list have positions that begin with 1. Duplicate entries are allowed.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class AList<T> implements ListInterface<T> {
	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public AList() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public AList(int initialCapacity) {
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

	private void checkCapacity(int initialCapacity) {
		// TODO Auto-generated method stub

	}

	private void checkIntegrity() {
		// TODO Auto-generated method stub

	}

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

	@Override
	public void add(T newEntry) {
		checkIntegrity();
		list[numberOfEntries + 1] = newEntry; 
		numberOfEntries++; 
		ensureCapacity();
	}

	@Override
	public void add(int newPosition, T newEntry) {
		checkIntegrity();
		// newPosition can be up to numberOfEntries + 1 as it is for adding, not replacing
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			if (newPosition <= numberOfEntries) 
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity(); // Ensure enough room for next add
		}else
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
	}
	
	private void makeRoom(int givenPosition) {
		int newIndex = givenPosition;
		int lastIndex = numberOfEntries;
		for (int index = lastIndex; index >= newIndex; index--)
		list[index + 1] = list[index];
	} // end makeRoom

	@Override
	public T remove(int givenPosition) {
		checkIntegrity();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			T result = list[givenPosition]; // Get entry to be removed // Move subsequent entries towards entry to be removed, // unless it is last in list
			if (givenPosition < numberOfEntries)
			removeGap(givenPosition);
			list[numberOfEntries] = null;
			numberOfEntries--;
			return result; // Return reference to removed entry
		} else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}
	
	private void removeGap(int givenPosition){
		int removedIndex = givenPosition;
		for(int index = removedIndex; index < numberOfEntries; index++){
			list[index] = list[index + 1];
		}
	}

	@Override
	public void clear() {
		list = null;
		numberOfEntries = 0;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if(givenPosition > numberOfEntries)
			return null;
		T replaced = list[givenPosition];
		list[givenPosition] = newEntry;
		return replaced;
	}

	@Override
	public T getEntry(int givenPosition) {
		return list[givenPosition];
	}

	@Override
	public T[] toArray() {
		T[] result = (T[])new Object[numberOfEntries];
		for(int i = 0; i< numberOfEntries; i++){
			result[i] = list[i+1];
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		checkIntegrity();
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)) {
			if (anEntry.equals(list[index])) found = true;
			index++;
		} // end while return found;
		return found;
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/*
	 * < This class will define checkCapacity, checkIntegrity, and two more private
	 * methods that will be discussed later. >
	 */
} // end AList
