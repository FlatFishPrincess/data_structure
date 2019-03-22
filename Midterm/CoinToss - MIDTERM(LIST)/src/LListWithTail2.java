/**
 * A class that implements the ADT list by using a chain of nodes that has both
 * a head reference and a tail reference.
 * 
 * @author Jiweon Park
 */
public class LListWithTail2<T> implements ListInterface<T> {
	
	private Node firstNode; // Head reference to first node
	private Node lastNode; // Tail reference to last node
	private int numberOfEntries; // Number of entries in list
	
	public LListWithTail2() {
		initializeDataFields();
	} // end default constructor


	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	// Returns a reference to the node at a given position.
		// Precondition: List is not empty; 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		Node currentNode = firstNode;
		for(int i = 1; i< givenPosition; i++){
			currentNode = currentNode.getNextNode();
		}
		return currentNode;
	} // end getNodeAt


	@Override
	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if(isEmpty()){
			firstNode = newNode;
		} else{
			if(numberOfEntries == 1)
				firstNode.setNextNode(newNode);
			else
				lastNode.setNextNode(newNode);			
		}
		lastNode = newNode;
		numberOfEntries++;
	}


	@Override
	public void add(int newPosition, T newEntry) {
		Node newNode = new Node(newEntry);
		if(newPosition == 1){
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		} else if(newPosition == numberOfEntries){
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		} else {
			Node nodeBefore = getNodeAt(newPosition - 1);
			Node nodeAfter = nodeBefore.getNextNode();
			nodeBefore.setNextNode(newNode);
			newNode.setNextNode(nodeAfter);
		}
		numberOfEntries++;
	}



	@Override
	public T remove(int givenPosition) {
		T result = null;
		if(givenPosition == 1){
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
		} else {
			Node nodeBefore = getNodeAt(givenPosition);
			Node nodeToRemove = nodeBefore.getNextNode();
			Node nodeAfter = nodeToRemove.getNextNode();
			result= nodeToRemove.getData();
			nodeBefore.setNextNode(nodeAfter);
		}
		numberOfEntries--;
		return result;
	}



	@Override
	public void clear() {
		initializeDataFields();
	}



	@Override
	public T replace(int givenPosition, T newEntry) {
		Node nodeToReplace = getNodeAt(givenPosition);
		nodeToReplace.setData(newEntry);
		return nodeToReplace.getData();
	}



	@Override
	public T getEntry(int givenPosition) {
		return getNodeAt(givenPosition).getData();
	}



	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[numberOfEntries];
		Node currentNode = firstNode;
		for(int i = 0; i< numberOfEntries; i++){
			arr[i] = currentNode.getData();
			currentNode = currentNode.getNextNode();
		}
		return arr;
	}



	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		for(int i =0; i< numberOfEntries; i++){
			if(currentNode.getData().equals(anEntry)){
				found = true;
				break;
			}
			currentNode = currentNode.getNextNode();
		}
		return found;
	}



	@Override
	public int getLength() {
		return numberOfEntries;
	}



	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	
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

} // end LListWithTail
