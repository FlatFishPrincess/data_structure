/**
 * An example of adding sort capabilities to a list
 * @author mhrybyk
 *
 * @param <T>
 */
public interface SortInterface<T> extends ListInterface<T> {
	/**
	 * Swap the values of the items in the list in each position
	 * @param first
	 * @param second
	 */
	public void swap(int first, int second);
	
	/**
	 * Sort the values of each item in the list
	 * @param first position of first item, must be > 0
	 * @param last position of the last item, must be < size()
	 */
	public void sort(int first, int last);

}
