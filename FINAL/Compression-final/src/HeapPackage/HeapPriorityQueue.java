package HeapPackage;

/**
 * A class that implements the ADT priority queue by using a maxheap.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	private MinHeapInterface<T> pq;

	public HeapPriorityQueue() {
		pq = new MinHeap<>();
	} // end default constructor

	public void add(T newEntry) {
		pq.add(newEntry);
	} // end add

	@Override
	public T remove() {
		return pq.removeMin();
	}

	@Override
	public T peek() {
		return pq.getMin();
	}

	@Override
	public boolean isEmpty() {
		return pq.isEmpty();
	}

	@Override
	public int getSize() {
		return pq.getSize();
	}

	@Override
	public void clear() {
		pq.clear();
	}

}
