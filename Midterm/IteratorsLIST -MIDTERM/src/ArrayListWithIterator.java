import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 A class that implements the ADT list by using a resizable array and
 gives it an iterator.
 
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public class ArrayListWithIterator<T> implements ListWithIteratorInterface<T> {
	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public ArrayListWithIterator() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public ArrayListWithIterator(int initialCapacity) {
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

	public Iterator<T> iterator() {
		return new IteratorForArrayList();
	} // end iterator

	public Iterator<T> getIterator() {
		return iterator();
	} // end getIterator

	// The array of list entries uses indexes that begin at 1 and
	// correspond to the position of the entry within the list.
	private class IteratorForArrayList implements Iterator<T> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

	} // end IteratorForArrayList

	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
} // end ArrayListWithIterator

