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
//		ensureCapacity();
		try{
			ensureCapacity();
			list[numberOfEntries + 1] = newEntry;
			numberOfEntries++;
		} catch(Exception e){
			System.out.println(e.getMessage() + " out of boundary");
		}
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// check if newPosition is within array
//		try{
//			if(newPosition >= 1 && newPosition <= numberOfEntries+1){
//				makeRoom(newPosition);
//				list[newPosition] = newEntry;
//			} else {
//				throw new Exception("out of boundary");
//			} 
//		} catch(Exception e){
//			System.out.println(e.getMessage());
//		}
		ensureCapacity();
		if(newPosition >= 1 && newPosition <= numberOfEntries+1){
			makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
		} else {
			throw new IndexOutOfBoundsException("out of boundary");
		} 
	}
	
	private void makeRoom(int givenPosition) {
		// cheeck capacity first as we need one extra element
		ensureCapacity();
		int lastIndex = numberOfEntries;
		for(int i = lastIndex; i > givenPosition; i--){
			list[lastIndex + 1]  = list[lastIndex];
		}
	} // end makeRoom
	
	@Override
	public T remove(int givenPosition) {
		T result = null;
		if(givenPosition >= 1 && givenPosition <= numberOfEntries){
			result = list[givenPosition];
			list[givenPosition] = null;
			removeGap(givenPosition);
			numberOfEntries--;
		} else 
			// throw exception with out of boundary 
			return null;
		
		return result;
	}
	
	private void removeGap(int givenPosition){
		int lastIndex = numberOfEntries;
		for(int i = givenPosition; i< lastIndex ; i++){
			list[i] = list[i + 1];
		}
	}
	

	@Override
	public void clear() {
		numberOfEntries = 0;
		list = null;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		T result = null;
		if(givenPosition >= 1 && givenPosition <= numberOfEntries){
			result = list[givenPosition];
			list[givenPosition] = newEntry;
		}  else 
			throw new IndexOutOfBoundsException("out of boundary");
		return result;
	}

	@Override
	public T getEntry(int givenPosition) {
		T result = list[givenPosition];
		return result;
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
		boolean found = false;
		int counter = 1;
		while(!found && counter <= numberOfEntries){
			T entry = list[counter];
			if(entry.equals(anEntry))
				found = true;
			counter++;
		}
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
} // end AList
