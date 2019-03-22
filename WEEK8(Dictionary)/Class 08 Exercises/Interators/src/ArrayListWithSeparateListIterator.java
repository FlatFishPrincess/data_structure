import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;


/**
 * A class that implements the ADT list by using an array. The list has entries
 * that are numbered beginning at 1. The list has an iterator that implements
 * the interface ListIterator. Iterator positions (indexes) are numbered
 * beginning at 0.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class ArrayListWithSeparateListIterator<T extends Comparable<? super T>> implements ListWithIteratorInterface<T> {
	private T[] list; // Array of list entries
	private int numberOfEntries;

	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public ArrayListWithSeparateListIterator() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public ArrayListWithSeparateListIterator(int initialCapacity) {

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
		return new ListIteratorForLists<T>(this);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return getIterator();
	}


} // end ArrayListWithListIterator
