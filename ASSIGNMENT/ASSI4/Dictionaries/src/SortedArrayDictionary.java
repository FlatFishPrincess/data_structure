import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT dictionary by using a resizable array. The
 * dictionary is sorted and has distinct search keys. Search keys and associated
 * values are not null.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * Entry<K,V> class is provided, as are iterator methods.
 * 
 * All other Dictionary methods need to be completed.
 */
public class SortedArrayDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {
	private Entry<K, V>[] dictionary; // Array of entries sorted by search key
	private int numberOfEntries;

	private final static int DEFAULT_CAPACITY = 25; // 6 is for testing
	public SortedArrayDictionary() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public SortedArrayDictionary(int initialCapacity) {

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
		dictionary = tempDictionary;
		numberOfEntries = 0;
	} // end constructor

	@Override
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		return null;
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

	// Returns the index of either the entry that contains key or
	// the location that should contain key, if no such entry exists.
	private int locateIndex(K key) {
		// Search until you either find an entry containing key or
		// pass the point where it should be
		int index = 0;
		while ((index < numberOfEntries) && key.compareTo(dictionary[index].getKey()) > 0) {
			index++;
		} // end while

		return index;
	} // end locateIndex



// Since iterators implement Iterator, methods must be public
// Same as ArrayDictionary
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


} // end SortedArrayDictionary
