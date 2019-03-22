import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A linked implementation of the ADT list that includes iterator operations as
 * ADT operations.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */

public class LinkedListWithTraversal<T extends Comparable<? super T>> implements ListInterface<T>, Iterator<T> {
	private Node<T> firstNode;
	private int numberOfEntries;
	private Node<T> nextNode; // Node containing next entry in iteration

	public LinkedListWithTraversal() {
		initializeDataFields();
	} // end default constructor

	public void clear() {
		initializeDataFields();
	} // end clear

	private void initializeDataFields() {
		firstNode = null;
		nextNode = null;
		numberOfEntries = 0;
	}

	public boolean isInRange(int givenPosition) {
		return (givenPosition >= 0) && (givenPosition < numberOfEntries) && (numberOfEntries > 0);
	}

	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		Node<T> newNode = new Node<T>(newEntry);

		if (isEmpty())
			firstNode = newNode;
		else // Add to end of non-empty list
		{
			Node<T> lastNode = getNodeAt(numberOfEntries - 1);
			lastNode.setNextNode(newNode); // Make last node reference new node
		} // end if

		numberOfEntries++;

		return true;
	} // end add

	public boolean add(int newPosition, T newEntry) // OutOfMemoryError possible
	{
		if (isInRange(newPosition) || newPosition == numberOfEntries) {
			Node<T> newNode = new Node<T>(newEntry);

			if (newPosition == 0) // Case 1
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else // Case 2: list is not empty
			{ // and newPosition > 0
				Node<T> nodeBefore = getNodeAt(newPosition - 1);
				Node<T> nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} // end if

			numberOfEntries++;
			return true;
		} else
			return false;
	} // end add

	public T remove(int givenPosition) {
		T result = null; // Return value

		if (isInRange(givenPosition)) {

			if (givenPosition == 0) // Case 1: remove first entry
			{
				result = firstNode.getData(); // Save entry to be removed
				firstNode = firstNode.getNextNode();
			} else // Case 2: not first entry
			{
				Node<T> nodeBefore = getNodeAt(givenPosition - 1);
				Node<T> nodeToRemove = nodeBefore.getNextNode();
				Node<T> nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
				result = nodeToRemove.getData(); // Save entry to be removed
			} // end if

			numberOfEntries--;
			return result; // Return removed entry
		} else
			return null;
	} // end remove

	public T replace(int givenPosition, T newEntry) {
		if (isInRange(givenPosition) && !isEmpty()) {

			Node<T> desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} else
			return null;
	} // end replace

	public T getEntry(int givenPosition) {
		if (isInRange(givenPosition)) {
			return getNodeAt(givenPosition).getData();
		} else
			return null;
	} // end getEntry

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		int index = 0;
		Node<T> currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} // end while

		return result;
	} // end toArray

	public boolean contains(T anEntry) {
		// find the entry, then remove it if it exists
		int position = findEntry(anEntry);

		return position < 0;
	} // end contains

	public int size() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		boolean result;

		if (numberOfEntries == 0) // or getLength() == 0
		{
			assert firstNode == null;
			result = true;
		} else {
			assert firstNode != null;
			result = false;
		} // end if

		return result;
	} // end isEmpty

// Methods in the interface Iterator:
	public boolean hasNext() {
		return nextNode != null;
	} // end hasNext

	public T next() {
		if (hasNext()) {
			Node<T> returnNode = nextNode; // Get next node
			nextNode = nextNode.getNextNode(); // Advance iterator

			return returnNode.getData(); // Return next entry in iteration
		} else
			throw new NoSuchElementException("Illegal call to next(); " + "iterator is after end of list.");
	} // end next

	public void remove() {
		throw new UnsupportedOperationException("remove() is not " + "supported by this iterator");
	} // end remove

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
	private Node<T> getNodeAt(int givenPosition) {
		if (isInRange(givenPosition)) {
			Node<T> currentNode = firstNode;

			// Traverse the chain to locate the desired node (skipped
			// if givenPosition is 0)
			for (int counter = 0; counter < givenPosition; counter++)
				currentNode = currentNode.getNextNode();

			assert currentNode != null;

			return currentNode;
		} else
			return null;
	} // end getNodeAt

	@Override
	public boolean removeEntry(T anEntry) {
		
		// find the entry, then remove it if it exists
		int position = findEntry(anEntry);

		if(position < 0)
			return false;
		else {
			if(remove(position) != null)
				return true;
			else return false;		
		}
	}

	@Override
	public int findEntry(T anEntry) {
		boolean found = false;
		
		int position = 0;
		Node<T> currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else {
				currentNode = currentNode.getNextNode();
				position++;
			}
		} // end while

		if(found == true)
			return position;
		else return -1;
	} 

} // end LinkedListWithTraversal
