/**
 * A linked implemention of the ADT list.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class LList<T> implements ListInterface<T> {
	private Node firstNode; // Reference to first node of chain
	private int numberOfEntries;

	public LList() {
		initializeDataFields();
	} // end default constructor

	public void clear() {
		initializeDataFields();
	} // end clear

	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	// Returns a reference to the node at a given position.
	// Precondition: The chain is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		// Assertion: (firstNode != null) &&
		// (1 <= givenPosition) && (givenPosition <= numberOfEntries)
		Node currentNode = firstNode;

		// Traverse the chain to locate the desired node
		// (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		// Assertion: currentNode != null
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

	/*
	 * < Implementations of the public methods add, remove, replace, getEntry,
	 * contains, getLength, isEmpty, and toArray go here. > . . .
	 */

	@Override
	public void add(T newEntry) {
		// create a new node
		Node newNode = new Node(newEntry);
		if(isEmpty())
			firstNode = newNode;
		else {
			Node lastNode = getNodeAt(numberOfEntries);
			lastNode.setNextNode(newNode);
		}
		numberOfEntries++;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		Node newNode = new Node(newEntry);
		// get beforeNode
		if(newPosition > 0 && newPosition <= numberOfEntries + 1){
			if(isEmpty())
				firstNode = newNode;
			else if(newPosition == 1){
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else if(newPosition == numberOfEntries + 1){
				Node lastNode = getNodeAt(newPosition -1);
				lastNode.setNextNode(newNode);
			} else {
				Node nodeBefore = getNodeAt(newPosition-1);
				Node nodeAfter = nodeBefore.getNextNode();
				nodeBefore.setNextNode(newNode);
				newNode.setNextNode(nodeAfter);
			}
		} else 
			throw new IndexOutOfBoundsException("out of boundary");
		numberOfEntries++;
	}

	@Override
	public T remove(int givenPosition) {
		T result = null;
		if(givenPosition  > 0 && givenPosition <= numberOfEntries ){
			if(givenPosition == 1){
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
			} else if(givenPosition == 2) {
				result = getNodeAt(givenPosition).getData();
				firstNode.setNextNode(null);
			} else if(givenPosition == numberOfEntries){
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData();
				nodeBefore.setNextNode(null);
			}else {
				Node NodeBefore = getNodeAt(givenPosition -1);
				Node NodeToRemove = NodeBefore.getNextNode();
				Node NodeAfter = NodeToRemove.getNextNode();
				result = NodeToRemove.getData();
				NodeBefore.setNextNode(NodeAfter);
			}
		} else 
			throw new IndexOutOfBoundsException("out of boundary");
		numberOfEntries--;
		return result;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		T result = null;
		Node nodeToReplace = getNodeAt(givenPosition);
		nodeToReplace.setData(newEntry);
		result = nodeToReplace.getData();
		return result;
	}

	@Override
	public T getEntry(int givenPosition) {
		T result = null;
		if(givenPosition > 0 && givenPosition <= numberOfEntries){
			Node currentNode = getNodeAt(givenPosition);
			result = currentNode.getData();
		}
		return result;
	}

	@Override
	public T[] toArray() {
		T[] nodeArr = (T[]) new Object[numberOfEntries];
		Node currentNode = firstNode;
		for(int i = 0; i< nodeArr.length; i++){
			nodeArr[i] = currentNode.getData();
			currentNode = currentNode.getNextNode();
		}
		return nodeArr;
	}

//	@Override
//	public boolean <T extends Comparable<T>> contains(T anEntry) {
//		boolean found = false;
//		Node currentNode = firstNode;
//		T data;
//		while(!found && currentNode != null){
//			data = (T) currentNode.getData();
//			if(data.compareTo(anEntry) == 1)
//				isContains = true;
//		}
//		return found;
//	}
//	
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (currentNode.getData().equals(anEntry)) 
				found = true;
			else
				currentNode = currentNode.getNextNode(); 
		} // end while
		return found;
	} // end contains


	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
} // end LList
