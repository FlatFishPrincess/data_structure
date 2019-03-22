import java.util.Iterator;

/**
 * A linked implementation of the ADT list that includes iterator operations as
 * ADT operations.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class ListWithTraversal<T> implements ListInterface<T>, Iterator<T> {
	private Node firstNode;
	private int numberOfEntries;
	private Node nextNode; // Node containing next entry in iteration

	public ListWithTraversal() {
		initializeDataFields();
	} // end default constructor

	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
		nextNode = null;
	} // end initializeDataFields

	/**
	 * Sets the traversal to the beginning of the list. This method is NOT in the
	 * interface Iterator.
	 */
	public void resetTraversal() {
		nextNode = firstNode;
	} // end resetTraversal

	// Returns a reference to the node at a given position.
	// Precondition: List is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;

		// Traverse the chain to locate the desired node (skipped
		// if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		assert currentNode != null;

		return currentNode;
	} // end getNodeAt

	private class Node {
		private T data; // Entry in list
		private Node next; // Link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub

	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
} // end ListWithTraversal
