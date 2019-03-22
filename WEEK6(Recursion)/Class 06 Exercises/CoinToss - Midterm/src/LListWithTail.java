/**
 * A class that implements the ADT list by using a chain of nodes that has both
 * a head reference and a tail reference.
 * 
 * @author Jiweon Park
 */
public class LListWithTail<T> implements ListInterface<T> {
	
	private Node firstNode; // Head reference to first node
	private Node lastNode; // Tail reference to last node
	private int numberOfEntries; // Number of entries in list
	
	public LListWithTail() {
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
			assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
			Node currentNode = firstNode;
			if (givenPosition == numberOfEntries)
				currentNode = lastNode;
			else if (givenPosition > 1) {
				assert givenPosition < numberOfEntries;
				// Traverse the chain to locate the desired node
				for (int counter = 1; counter < givenPosition; counter++)
					currentNode = currentNode.getNextNode();
			} // end if

			assert currentNode != null;
			return currentNode;
		} // end getNodeAt


	@Override
	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if(isEmpty())
			firstNode = newNode;
		 else {
			 if(numberOfEntries == 1)
				 firstNode.setNextNode(newNode);
			 else 
				 lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
		numberOfEntries++;
	}



	@Override
	public void add(int newPosition, T newEntry) {
		if(newPosition > 0 && newPosition <= numberOfEntries + 1){
			Node newNode = new Node(newEntry);
			if(isEmpty()){
				firstNode = newNode;
				lastNode = newNode;
			} else if(newPosition == 1){
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else if(newPosition == numberOfEntries + 1){
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			} else {
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				nodeBefore.setNextNode(newNode);
				newNode.setNextNode(nodeAfter);
			}
			numberOfEntries++;
		} else 
			throw new IndexOutOfBoundsException("out of boundary");
	}



	@Override
	public T remove(int givenPosition) {
		T result = null;
		if(givenPosition > 0 && givenPosition <= numberOfEntries){
			if(givenPosition == 1){
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
			} else if(givenPosition == numberOfEntries){
				result = lastNode.getData();
				Node nodeBefore = getNodeAt(givenPosition - 1);
				lastNode = nodeBefore;
			} else {
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeToRemove.getNextNode();
				result = nodeToRemove.getData();
				nodeBefore.setNextNode(nodeAfter);
			}
			numberOfEntries--;
		} else 
			throw new IndexOutOfBoundsException("out of boundary");
		return result;
	}



	@Override
	public void clear() {
		initializeDataFields();
	}



	@Override
	public T replace(int givenPosition, T newEntry) {
		T result = null;
		if(givenPosition > 0 && givenPosition <= numberOfEntries ){
			Node nodeToReplace = getNodeAt(givenPosition);
			nodeToReplace.setData(newEntry);
			result = nodeToReplace.getData();
		} else 
			throw new IndexOutOfBoundsException("out of boundary");
		return result;
	}



	@Override
	public T getEntry(int givenPosition) {
		T result = null;
		if(givenPosition > 0 && givenPosition <= numberOfEntries){
			result = getNodeAt(givenPosition).getData();
		}
		return result;
	}



	@Override
	public T[] toArray() {
		T[] nodeArr = (T[]) new Object[numberOfEntries];
		Node currentNode = firstNode;
		int i = 0;
		while(currentNode != null && i < numberOfEntries){
			nodeArr[i] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			i++;
		}
		return nodeArr;
	}



	@Override
	public boolean contains(T anEntry) {
		boolean isFound = false;
		Node currentNode = firstNode;
		while(!isFound && currentNode != null){
			T data = currentNode.getData();
			if(data.equals(anEntry))
				isFound = true;
			currentNode = currentNode.getNextNode();
				
		}
		return isFound;
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
