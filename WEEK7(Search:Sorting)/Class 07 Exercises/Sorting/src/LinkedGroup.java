/**
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * made this implement ListInterface just so demo programs work with it easily.
 * Note that not all methods are implemented.
 * 
 * This just shows how to implement a sort in a class
 */
public class LinkedGroup<T extends Comparable<? super T>> implements ListInterface<T>{
	private Node<T> firstNode;
	int numberOfEntries; // Number of objects in the group

	public LinkedGroup() {
		initializeDataFields();
	} // end default constructor

	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	public void clear() {
		initializeDataFields();
	} // end clear

	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		// Add new entry to beginning of chain:
		// Create a new node that references the current first node of the chain
		Node<T> newNode = new Node<>(newEntry, firstNode);
		firstNode = newNode; // Make chain begin at new node

		numberOfEntries++;
		return true;
	} // end add

	public int size() {
		return numberOfEntries;
	} // end getLength

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // Warning: unchecked cast

		int index = 0;
		Node<T> currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} // end while

		return result;
	} // end toArray

	public void sort() {
		insertionSort(firstNode);
	} // end sort

	private void insertionSort(Node<T> firstNode) {
		// If fewer than two items are in the list, there is nothing to do
		if (numberOfEntries > 1) {
			// Assertion: firstNode != null

			// Break chain into 2 pieces: sorted and unsorted
			Node<T> unsortedPart = firstNode.getNextNode();
			// Assertion: unsortedPart != null
			firstNode.setNextNode(null);

			while (unsortedPart != null) {
				Node<T> nodeToInsert = unsortedPart;
				unsortedPart = unsortedPart.getNextNode();
				insertInOrder(nodeToInsert);
			} // end while
		} // end if
	} // end insertionSort

	private void insertInOrder(Node<T> nodeToInsert) {
		T item = nodeToInsert.getData();
		Node<T> currentNode = firstNode;
		Node<T> previousNode = null;

		// Locate insertion point
		while ((currentNode != null) && (item.compareTo(currentNode.getData()) > 0)) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		} // end while

		// Make the insertion
		if (previousNode != null) { // Insert between previousNode and currentNode
			previousNode.setNextNode(nodeToInsert);
			nodeToInsert.setNextNode(currentNode);
		} else // Insert at beginning
		{
			nodeToInsert.setNextNode(firstNode);
			firstNode = nodeToInsert;
		} // end if
	} // end insertInOrder

	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	// Returns a reference to the node at a given position.
	// Precondition: The chain is not empty;
	// 1 <= givenPosition <= length.
	private Node<T> getNodeAt(int givenPosition) {
		// Assertion: (firstNode != null) &&
		// (1 <= givenPosition) && (givenPosition <= length)
		Node<T> currentNode = firstNode;

		// Traverse the chain to locate the desired node
		// (skipped if givenPosition is 1)
		for (int counter = 0; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		// Assertion: currentNode != null
		return currentNode;
	} // end getNodeAt

	@Override
	public boolean add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeEntry(T anEntry) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findEntry(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

} // end LinkedChainList
