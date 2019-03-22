import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT dictionary by using a fixed size array. The
 * dictionary is unsorted and has distinct search keys. Search keys and
 * associated values are not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * Entry<K,V> class is provided, as are iterator methods.
 * 
 * All other Dictionary methods need to be completed.
 */
public class ArrayDictionary<K, V> implements DictionaryInterface<K, V> {
	private Entry<K, V>[] dictionary; // Array of unsorted entries
	private int numberOfEntries;

	private final static int DEFAULT_CAPACITY = 25; // 6 is for testing

	public ArrayDictionary() {
		this(DEFAULT_CAPACITY); // Call next constructor
	} // end default constructor

	public ArrayDictionary(int initialCapacity) {

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
		dictionary = tempDictionary;
		numberOfEntries = 0;
	} // end constructor


	// Returns the array index of the entry that contains key, or
	// returns numberOfEntries if no such entry exists.
	// Precondition: key is not null.
	private int locateIndex(K key) {
		// Sequential search
		int index = 0;
		while ((index < numberOfEntries) && !key.equals(dictionary[index].getKey()))
			index++;
		return index;
	} // end locateIndex

	@Override
	public V add(K key, V value) {
		if ((key == null) || (value == null))
		      throw new IllegalArgumentException("Cannot add null to this dictionary.");
		else {
	       V result = null;
	       int keyIndex = locateIndex(key);
	       if (keyIndex < numberOfEntries) {
	         // Key found, return and replace entry's value
	         result = dictionary[keyIndex].getValue(); // Get old value
	         dictionary[keyIndex].setValue(value); 		// Replace value
	       } else { // Key not found; add new entry to dictionary 
	         // Add at end of array
	         dictionary[numberOfEntries] = new Entry<>(key, value);
	         numberOfEntries++;
	       } // end if
	      return result;
	    } // end if
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
// Since iterators implement Iterator, methods must be public.
// Same as SortedArrayDictionary.
	private class KeyIterator implements Iterator<K> {
		private int currentIndex;

		private KeyIterator() {
			currentIndex = 0;
		} // end default constructor

		public boolean hasNext() {
			return currentIndex < numberOfEntries;
		} // end hasNext

		public K next() {
			K result = null;

			if (hasNext()) {
				Entry<K, V> currentEntry = dictionary[currentIndex];
				result = currentEntry.getKey();
				currentIndex++;
			} else {
				throw new NoSuchElementException();
			} // end if

			return result;
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end KeyIterator

	private class ValueIterator implements Iterator<V> {
		private int currentIndex;

		private ValueIterator() {
			currentIndex = 0;
		} // end default constructor

		public boolean hasNext() {
			return currentIndex < numberOfEntries;
		} // end hasNext

		public V next() {
			V result = null;

			if (hasNext()) {
				Entry<K, V> currentEntry = dictionary[currentIndex];
				result = currentEntry.getValue();
				currentIndex++;
			} else {
				throw new NoSuchElementException();
			} // end if

			return result;
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end getValueIterator

	private class Entry<S, T> {
		private S key;
		private T value;

		private Entry(S searchKey, T dataValue) {
			key = searchKey;
			value = dataValue;
		} // end constructor

		private S getKey() {
			return key;
		} // end getKey

		private T getValue() {
			return value;
		} // end getValue

		private void setValue(T dataValue) {
			value = dataValue;
		} // end setValue

		// No setKey method
	} // end Entry

} // end ArrayDictionary
