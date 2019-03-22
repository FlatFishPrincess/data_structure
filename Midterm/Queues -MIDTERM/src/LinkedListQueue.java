import java.util.LinkedList;

/**
 * This implements the Queue Interface using the java library LinkedList class
 * 
 * Note use of add/remove/element methods
 * @author mhrybyk
 *
 * @param <T>
 */
public class LinkedListQueue<T> implements QueueInterface<T> {

	// internal linked list of nodes
	
	private LinkedList<T> nodes;

	public LinkedListQueue() {
		nodes = new LinkedList<>();
	}

	@Override
	public void enqueue(T newEntry) {
		nodes.add(newEntry);
	}

	@Override
	public T dequeue() {
		return nodes.remove();
	}

	@Override
	public T getFront() {
		return nodes.element();
	}

	@Override
	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	@Override
	public void clear() {
		nodes.clear();

	}

}
