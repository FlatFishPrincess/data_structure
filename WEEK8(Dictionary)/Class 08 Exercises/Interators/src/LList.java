/**
 * A linked implemention of the ADT list.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * modified to use a zero offset for position
 */
public class LList<T extends Comparable<? super T>> implements ListInterface<T> {
	private Node<T> firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public LList() {
		initializeDataFields();
	} // end default constructor

	public void clear() {
		initializeDataFields();
	} // end clear

	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}

	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		Node<T> newNode = new Node<>(newEntry);
	
		if (isEmpty())
			firstNode = newNode;
		else // Add to end of nonempty list
		{
			Node<T> lastNode = getNodeAt(numberOfEntries - 1);
			lastNode.setNextNode(newNode); // Make last node reference new node
		} // end if

		numberOfEntries++;

		return true;
	} // end add

	public boolean add(int givenPosition, T newEntry) // OutOfMemoryError possible
	{
		// add to the position before given position, so to add to the end allow for 
		// *before* the last last + 1 (or numberOfEntries)
		if (isInRange(givenPosition) || givenPosition == numberOfEntries) {

			Node<T> newNode = new Node<>(newEntry);
			if (givenPosition == 0) // Case 1
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else // Case 2: list is not empty
			{ // and givenPosition > 0
				Node<T> nodeBefore = getNodeAt(givenPosition - 1);
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
			
			// Assertion: !isEmpty()
			if (givenPosition == 0) // Case 1: Remove first entry
			{
				result = firstNode.getData(); // Save entry to be removed
				firstNode = firstNode.getNextNode(); // Remove entry
			} else // Case 2: Not first entry
			{
				Node<T> nodeBefore = getNodeAt(givenPosition - 1);
				Node<T> nodeToRemove = nodeBefore.getNextNode();

				result = nodeToRemove.getData(); // Save entry to be removed
				Node<T> nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter); // Remove entry
			} // end if
			numberOfEntries--; // Update count
			return result; // Return removed entry
		} else
			return null;
	} // end remove

	public T replace(int givenPosition, T newEntry) {
		if (isInRange(givenPosition)) {
			Node<T> desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} else
			return null;
	} // end replace

	public T getEntry(int givenPosition) {
		if (isInRange(givenPosition)) {
			// Assertion: !isEmpty()
			return getNodeAt(givenPosition).getData();
		} else
			return null;
	}

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Comparable[numberOfEntries];

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
		boolean found = false;
		Node<T> currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while

		return found;
	} // end contains
	
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

	public int size() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	public boolean isInRange(int givenPosition) {
		return (givenPosition >= 0) && (givenPosition < numberOfEntries) && (numberOfEntries > 0);
	}

	// Returns a reference to the Node<T> at a given position.
	// Precondition: The chain is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node<T> getNodeAt(int givenPosition) {
		// Assertion: (firstNode != null) &&
		// (1 <= givenPosition) && (givenPosition <= numberOfEntries)
		Node<T> currentNode = firstNode;

		// Traverse the chain to locate the desired node

		for (int counter = 0; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		// Assertion: currentNode != null
		return currentNode;
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

} // end LList
