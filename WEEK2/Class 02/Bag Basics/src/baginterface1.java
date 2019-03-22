
public interface baginterface1<T> {
	public int getCurrentSize();

	public boolean isEmpty();

	public boolean add(T newEntry);

	public T remove();

	public boolean remove(T anEntry);

	/** Removes all entries from this bag. */
	public void clear();

	public int getFrequencyOf(T anEntry);

	
	public boolean contains(T anEntry);

	public T[] toArray();
}
