/**
 * Using inheritance and polymorphism, an AList class that inserts items in the list
 * in sorted order.
 * 
 * @author mhrybyk
 *
 * @param <T>
 */
public class SortedAList<T extends Comparable<? super T>> extends AList<T> {

	public SortedAList() {
		super();
	}

	public SortedAList(int initialCapacity) {
		super(initialCapacity);
	}
	
	/**
	 * This inserts an entry into a list in sorted order (ascending)
	 */
	@Override
	final public boolean add(T entry) {
	
		// find the position in sorted order that the entry precedes
		
		int position = findEntryPosition(entry);
		
		// if it is not found, simply add it to the end.
		
		if (position < 0) {
			return(super.add(entry));
		}

		// otherwise add it into the slot found
		
		return(super.add(position, entry));

	}

	/**
	 * Finds a position in the list that an entry precedes in sorted order (ascending).
	 * @param entry
	 * @return -1 if not found
	 */
	public int findEntryPosition(T entry) {
		
		int found = -1;

		for(int i = 0; i < size(); i++) {
			if(entry.compareTo(getEntry(i)) < 0) {
				found = i;
				break;
			}
		}
		return found;
	}
	/**
	 * This is not allowed, or list will be unsorted.
	 */
	@Override
	final public boolean add(int position, T entry)  {
		return false;
	}
}
