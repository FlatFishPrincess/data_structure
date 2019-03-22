/**
 * A class that implements the ADT sorted list by using a chain of linked nodes.
 * Duplicate entries are allowed. Iterative version.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * changed offset to zero, and some methods renamed
 */
public class IterativeSortedLList<T extends Comparable<? super T>> implements ListInterface<T> {
	private Node<T> firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public IterativeSortedLList() {
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	/**
	 * This changes the interface behaviour, as we add a node in sorted order after the previous one.
	 */
	public boolean add(T newEntry) {
		Node<T> newNode = new Node<>(newEntry);
		Node<T> nodeBefore = findNodeBefore(newEntry);

		if (isEmpty() || (nodeBefore == null)) {
			// Add at beginning
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		} else {
			// Add after nodeBefore
			Node<T> nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		} // end if

		numberOfEntries++;

		return true;
	} // end add

	public boolean removeEntry(T anEntry) {
		boolean found = false;

		if (numberOfEntries > 0) {
			Node<T> nodeToRemove;
			Node<T> nodeBefore = findNodeBefore(anEntry);

			if (nodeBefore == null)
				nodeToRemove = firstNode;
			else
				nodeToRemove = nodeBefore.getNextNode();

			if ((nodeToRemove != null) && anEntry.equals(nodeToRemove.getData())) {
				found = true;

				if (nodeBefore == null)
					firstNode = nodeToRemove.getNextNode();
				else {
					Node<T> nodeAfter = nodeToRemove.getNextNode();
					nodeBefore.setNextNode(nodeAfter);
				} // end if

				numberOfEntries--;
			} // end if
		} // end if

		return found;
	} // end remove

	public int findEntryPosition(T anEntry) {
		int position = 0;
		Node<T> currentNode = firstNode;

		while ((currentNode != null) && (anEntry.compareTo((T) currentNode.getData()) > 0)) {
			currentNode = currentNode.getNextNode();
			position++;
		} // end while

		if ((currentNode == null) || anEntry.compareTo((T) currentNode.getData()) != 0)
			position = -1;

		return position;
	} // end getPosition

	// List operations
	public T getEntry(int givenPosition) {
		T result = null; // Result to return

		if (isInRange(givenPosition)) {
			// Assertion: !isEmpty()
			result = getNodeAt(givenPosition).getData();
		} // end if

		return result;
	} // end getEntry

	@Override
	public T remove(int givenPosition) {
		T result = null; // Return value

		if (isInRange(givenPosition)) {
			// Assertion: !isEmpty()

			if (givenPosition == 0) // Case 1: remove first entry
			{
				result = (T) firstNode.getData(); // Save entry to be removed
				firstNode = firstNode.getNextNode();
			} else // Case 2: givenPosition > 1
			{
				Node<T> nodeBefore = getNodeAt(givenPosition - 1);
				Node<T> nodeToRemove = nodeBefore.getNextNode();
				Node<T> nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter); // Disconnect the node to be removed
				result = (T) nodeToRemove.getData(); // Save entry to be removed
			} // end if

			numberOfEntries--;
		} // end if

		return result; // Return removed entry, or
						// null if operation fails
	} // end remove

	public final void clear() {
		firstNode = null;
		numberOfEntries = 0;
	} // end clear

	public boolean contains(T anEntry) {
		return findEntryPosition(anEntry) >= 0;
	} // end contains

	public int size() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty
	
	public boolean isInRange(int givenPosition) {
		return (givenPosition >= 0) && (givenPosition < numberOfEntries);
	}

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries]; // Warning: unchecked cast

		int index = 0;
		Node<T> currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = (T) currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} // end while

		return result;
	} // end toArray

	// Finds the node that is before the node that should or does
	// contain a given entry.
	// Returns either a reference to the node that is before the node
	// that contains--or should contain--anEntry, or null if no prior node exists
	// (that is, if anEntry is or belongs at the beginning of the list).
	private Node<T> findNodeBefore(T anEntry) {
		Node<T> currentNode = firstNode;
		Node<T> nodeBefore = null;

		while ((currentNode != null) && (anEntry.compareTo((T) currentNode.getData()) > 0)) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		} 

		return nodeBefore;
	} 

	private Node<T> getNodeAt(int givenPosition) {
		// Assertion: !isEmpty() && (1 <= givenPosition) && (givenPosition <=
		// numberOfEntries)
		Node<T> currentNode = firstNode;

		// Traverse the list to locate the desired node
		for (int counter = 0; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		// Assertion: currentNode != null
		return currentNode;
	} // end getNodeAt

	// these are not implemented
	
	@Override
	public boolean add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findEntry(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

} // end LinkedSortedList
