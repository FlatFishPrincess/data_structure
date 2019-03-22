/**
 * Example using the SortInterface. Note that we require the type of list to be Comparable.
 * 
 * InsertionSort uses our AList implementation of the ListInterface
 * @author mhrybyk
 *
 * @param <T> must implement Comparable
 */
public class InsertionSortAList<T extends Comparable<? super T>> extends AList<T> implements SortInterface<T>{

	@Override
	public void swap(int first, int second) {

		if (first == second)
			return;

		T firstEntry = getEntry(first);
		T secondEntry = getEntry(second);

		replace(first, secondEntry);
		replace(second, firstEntry);
		
	}

	/**
	 * Insertion sort
	 * 
	 * Get the next entry in a list. A sub list then exists of all prior entries.
	 * 
	 * Iterate through the sub list of prior entries, and then insert the current entry in
	 * the correct sorted position in the sub list.
	 * 
	 * Then iteratively get the next entry.
	 * 
	 */
	@Override
	public void sort(int first, int last) {
		for (int unsorted = first + 1; unsorted <= last; unsorted++) {
			T next = getEntry(unsorted);
			insertInOrder(next, first, unsorted - 1);
		}	
	}
	
	/**
	 * Compare an item to each list entry and insert it in the proper position. 
	 * 
	 * 
	 * @param item
	 * @param first
	 * @param last
	 */
	private void insertInOrder(T item, int first, int last) {
		int index = last;

		for (; index >= first; index--) {
			T current = getEntry(index);
			if (current.compareTo(item) > 0)
				replace(index + 1, current);
			else
				break;
		}

		replace(index + 1, item);

	}

}
