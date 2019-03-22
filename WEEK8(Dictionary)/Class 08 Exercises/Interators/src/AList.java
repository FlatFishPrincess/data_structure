import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT sorted list by using a resizable array.
 * Duplicate entries are allowed.
 * 
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 *         Redone to simplify and make everything zero index based
 */
public class AList<T extends Comparable<? super T>> implements ListWithIteratorInterface<T> {
	private T[] list; // Array of list entries
	private int numberOfEntries;

	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public AList() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public AList(int initialCapacity) {

		// Is initialCapacity too small?
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;

		// cap it at maximum capacity

		if (initialCapacity >= MAX_CAPACITY)
			initialCapacity = MAX_CAPACITY;

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Comparable[initialCapacity];
		list = tempList;

		numberOfEntries = 0;

	} // end default constructor

	public boolean add(T newEntry) {

		if (hasRoom() == false)
			return false;

		list[numberOfEntries] = newEntry;
		numberOfEntries++;

		return true;

	} // end add

	public boolean removeEntry(T anEntry) {

		boolean found = false;

		if (!isEmpty()) {
			int position = findEntry(anEntry);
			if (position >= 0) {
				remove(position);
				found = true;
			} // end if
		} // end if

		return found;
	} // end remove

	public int findEntry(T anEntry) {

		int position = 0;

		// if the entry exists, loop will end when found.

		while ((position < numberOfEntries) && !anEntry.equals(getEntry(position))) {
			position++;
		} // end while

		// return -1 if not found

		return position == numberOfEntries ? -1 : position;

	} // end getPosition

	public T getEntry(int givenPosition) {

		if (isInRange(givenPosition)) {
			return list[givenPosition];
		} else
			return null;
	} // end getEntry

	public boolean contains(T anEntry) {
		return findEntry(anEntry) >= 0;
	} // end contains

	public T remove(int givenPosition) {

		T result = null;

		if (isInRange(givenPosition)) {
			result = list[givenPosition]; // Get entry to be removed

			// shift all of the elements of the array down

			for (int index = givenPosition; index < numberOfEntries; index++)
				list[index] = list[index + 1];

			// decrement size
			numberOfEntries--;
		}

		return result;
	} // end remove

	public void clear() {

		// Clear entries but retain array; no need to create a new array
		for (int index = 0; index < numberOfEntries; index++)
			list[index] = null;

		numberOfEntries = 0;
	} // end clear

	public int size() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	public boolean isInRange(int givenPosition) {
		return (givenPosition >= 0) && (givenPosition < numberOfEntries) && (numberOfEntries > 0);
	}

	/**
	 * Determine if there is enough room in the array
	 * 
	 * @return
	 */
	public boolean isFull() {
		if (numberOfEntries >= list.length)
			return false;
		else
			return true;
	}

	public boolean hasRoom() {
		if (numberOfEntries < list.length)
			return true;
		else
			return false;
	}

	public T[] toArray() {
		return (T[]) Arrays.copyOf(list, numberOfEntries);
	}

	@Override
	public boolean add(int newPosition, T newEntry) {

		// if it is not in range or want the last position, make sure we have room

		if (newPosition < 0 || newPosition > numberOfEntries || hasRoom() == false)
			return false;

		// shift all entries starting the the desired position for the new entry
		// up by one to make room
		// notice we are starting from the back and shifting each to a new position

		for (int index = numberOfEntries - 1; index >= newPosition; index--) {
			list[index + 1] = list[index];
		}

		// now set new entry into the vacated position and increast the list count

		list[newPosition] = newEntry;

		numberOfEntries++;

		return true;

	}

	@Override
	public T replace(int givenPosition, T newEntry) {

		if (!isInRange(givenPosition))
			return null;

		T result = list[givenPosition];

		list[givenPosition] = newEntry;

		return result;
	}

	@Override
	public ListIterator<T> getIterator() {
		// TODO Auto-generated method stub
		return new ListIteratorForAList();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return getIterator();
	}

	private class ListIteratorForAList implements ListIterator<T> {
		private int nextIndex; // Index of next entry in the iteration
		private boolean wasNextCalled; // Needed by remove

		private ListIteratorForAList() {
			nextIndex = 0; // Iteration begins at list's first entry
			wasNextCalled = false;
		} // end default constructor

		public boolean hasNext() {
			return nextIndex < size();
		} // end hasNext

		public T next() {
			
			if (hasNext()) {
				wasNextCalled = true;
				T nextEntry = getEntry(nextIndex);
				nextIndex++; // Advance iterator

				return nextEntry;
			} else
				throw new NoSuchElementException("Illegal call to next(); " + "iterator is after end of list.");
		} // end next

		public void remove() {
			if (wasNextCalled) {
				// nextIndex was incremented by the call to next, so it is
				// 1 larger than the position number of the entry to be removed
				if(AList.this.remove(nextIndex - 1) == null)
					throw new NoSuchElementException("Illegal call to next(); " + "iterator is after end of list.");
				nextIndex--; // Index of next entry in iteration
				wasNextCalled = false; // Reset flag
			} else
				AList.this.remove(nextIndex);
		} // end remove

		@Override
		public void add(T newEntry) {
			// TODO Auto-generated method stub
			AList.this.add(nextIndex, newEntry);
			nextIndex++;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return nextIndex > 0 && nextIndex <= size();
		}

		@Override
		public int nextIndex() {
			int result;

			if (hasNext())
				result = nextIndex; // Change to zero-based numbering of iterator
			else
				result = size(); // End-of-list flag

			return result;
		}

		@Override
		public T previous() {
			if (hasPrevious()) {
				wasNextCalled = false;
				T previousEntry = getEntry(nextIndex - 1);
				nextIndex--; // Move iterator back
				return previousEntry;
			} else
				return null;
		}

		@Override
		public int previousIndex() {
			int result;

			if (hasPrevious())
				result = nextIndex - 1; // Change to zero-based numbering of iterator
			else
				result = -1; // Beginning-of-list flag

			return result;
		} // end previousInd

		@Override
		public void set(T newEntry) {
			if(wasNextCalled) 
				replace(nextIndex - 1, newEntry);
			else replace(nextIndex, newEntry);
			
		}
		
	} 

} 
