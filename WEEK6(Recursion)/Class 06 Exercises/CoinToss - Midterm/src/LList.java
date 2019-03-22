
/**
 * A linked implemention of the ADT list. This uses a single link (no tail is to be used).
 * 
 * @author Jiweon Park
 */

public class LList<T> implements ListInterface<T> {
	
	// data fields
	private Node firstNode;
	private int numberOfEntries;
	
	public LList() {
		initializeDataFields();
	} // end default constructor

	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	// get node at the position
	private Node getNodeAt(int givenPosition) {
		// make sure givenPosition is within index bounds
		if(firstNode != null && givenPosition >= 1 && givenPosition <= numberOfEntries){
			Node currentNode = firstNode;
			for(int counter = 1; counter < givenPosition; counter++){
				currentNode = currentNode.getNextNode();
			}
			return currentNode;
		} else {
			throw new IndexOutOfBoundsException("out of boundary");
		}
	} // end getNodeAt
	
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
		if(newPosition > 0 && newPosition <= numberOfEntries + 1){
			if(isEmpty())
				firstNode = newNode;
			else{
				Node beforeNode = getNodeAt(newPosition);
				Node afterNode = beforeNode.getNextNode();
				beforeNode.setNextNode(newNode);
				newNode.setNextNode(afterNode);
			}
			numberOfEntries++;
		} else {
			throw new IndexOutOfBoundsException("out of boundary" + newPosition);
		}
	}

	@Override
	public T remove(int givenPosition) {
		
		if(givenPosition  >= 1 && givenPosition <= numberOfEntries ){
			T result = null;
			if(givenPosition == 1){
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
			} else {
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData(); // Save entry to be removed 
				Node nodeAfter = nodeToRemove.getNextNode(); 
				nodeBefore.setNextNode(nodeAfter); // Remove entry
			}
			numberOfEntries--;
			return result;
		} else 
			throw new IndexOutOfBoundsException("out of boundary");
	}

	@Override
	public void clear() {
		initializeDataFields(); //firstNode = null and numberOfEntries = 0
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if(givenPosition >= 1 && givenPosition < numberOfEntries + 1){
			T result;
			Node nodeToReplace = getNodeAt(givenPosition);
			nodeToReplace.setData(newEntry);
			result = nodeToReplace.getData();
			return result;
		} else {
			throw new IndexOutOfBoundsException("Out of bounds given position at: " + givenPosition);
		}
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
		int counter = 0;
		Node currentNode = firstNode;
		while(currentNode != null && counter < numberOfEntries){
			nodeArr[counter] =  currentNode.getData();
			currentNode = currentNode.getNextNode();
			counter++;
		}
		return nodeArr;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		int counter = 0;
		while(currentNode != null && counter< numberOfEntries ){
			T currentData = currentNode.getData();
			if(currentData.equals(anEntry))
				found = true;
			counter++;
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

	// This Node class is for LList
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
	
} // end LList


