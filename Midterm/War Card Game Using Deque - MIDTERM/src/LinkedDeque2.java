/**
   A class that implements the ADT deque by using a doubly linked chain of nodes.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedDeque2<T> implements DequeInterface<T> {
	private DoublyLinkedNode firstNode; // References node at front of deque
	private DoublyLinkedNode lastNode; // References node at back of deque
	private int size;

	public LinkedDeque2() {
		firstNode = null;
		lastNode = null;
		size = 0;
	} // end default constructor


	@Override
	public void addToFront(T newEntry) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(null, newEntry, firstNode);
		if(firstNode == null){
			lastNode = newNode;
		}else {
			firstNode.setPreviousNode(firstNode);
		}
		firstNode = newNode;
		size++;
	}


	@Override
	public void addToBack(T newEntry) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(lastNode, newEntry, null);
		if(lastNode == null){
			firstNode = newNode;
		}else {
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;
		size++;
	}


	@Override
	public T removeFront() {
		T result = firstNode.getData();
		firstNode = firstNode.getNextNode();
		if(firstNode == null)
			lastNode = null;
		else 
			firstNode.setPreviousNode(null);
		size--;
		return result;
	}


	@Override
	public T removeBack() {
		T result = lastNode.getData();
		lastNode = lastNode.getPreviousNode();
		if(lastNode == null)
			firstNode = null;
		else
			lastNode.setNextNode(null);
		size--;
		return result;
		
	}


	@Override
	public T getFront() {
		return firstNode.getData();
	}


	@Override
	public T getBack() {
		return lastNode.getData();
	}


	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}


	@Override
	public int size() {
		return size;
	}
	/**
	 * Display all elements in a queue
	 * Begin with the title followed by the queue size.
	 * Then display each element using the toString() method 
	 * of the element.
	 * @param title title to display ahead of list of elements
	 */
	public void display(String title) {
		int queueSize = size();
		System.out.println("===================");
		System.out.println(title + " size " + queueSize);
		for(DoublyLinkedNode node = firstNode; node != null; node = node.getNextNode()) {
			System.out.println(node.getData());
		}
		System.out.println("===================");
	}
	
	private class DoublyLinkedNode {
		private T data; // Deque entry
		private DoublyLinkedNode next; // Link to next node
		private DoublyLinkedNode previous; // Link to previous node

		private DoublyLinkedNode(T dataPortion) {
			data = dataPortion;
			next = null;
			previous = null;
		} // end constructor

		private DoublyLinkedNode(DoublyLinkedNode previousNode, T dataPortion, DoublyLinkedNode nextNode) {
			data = dataPortion;
			next = nextNode;
			previous = previousNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		@SuppressWarnings("unused")
		private void setData(T newData) {
			data = newData;
		} // end setData

		private DoublyLinkedNode getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(DoublyLinkedNode nextNode) {
			next = nextNode;
		} // end setNextNode

		private DoublyLinkedNode getPreviousNode() {
			return previous;
		} // end getPreviousNode

		private void setPreviousNode(DoublyLinkedNode previousNode) {
			previous = previousNode;
		} // end setPreviousNode
	} // end DLNode

} // end LinkedDeque
