/**
 * A class that implements the a deque of objects by using a chain of doubly
 * linked nodes.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedDeque2<T> implements DequeInterface<T> {
	private DLNode firstNode; // References node at front of deque
	private DLNode lastNode; // References node at back of deque

	public LinkedDeque2() {
		firstNode = null;
		lastNode = null;
	} // end default constructor

//  < Implementations of the deque operations go here. >
//  . . .

	private class DLNode {
		private T data; // Deque entry
		private DLNode next; // Link to next node
		private DLNode previous; // Link to previous node

		DLNode(T data){
			this.data = data;
			next = null;
			previous = null;
		}

		DLNode(DLNode previous, T data, DLNode next){
			this.data = data;
			this.previous = previous;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public DLNode getNextNode() {
			return next;
		}

		public void setPreviousNode(DLNode previous) {
			this.previous = previous;
		}

		public DLNode getPreviousNode() {
			return previous;
		}

		public void setNextNode(DLNode next) {
			this.next = next;
		}

		//    < Constructors and the methods getData, setData, getNextNode, setNextNode,
//      getPreviousNode, and setPreviousNode are here. >
//    . . .

	} // end DLNode

	@Override
	public void addToFront(T newEntry) {
		DLNode newNode = new DLNode(null, newEntry, firstNode);
		// if the queue is empty, lastNode points to the firstNode, which is the newNode
		if(firstNode == null)
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);
		firstNode = newNode;

	}

	@Override
	public void addToBack(T newEntry) {
		// last node should be null
		DLNode newNode = new DLNode(lastNode, newEntry, null);

		if(lastNode == null)
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
	}

	@Override
	public T removeFront() {
		T front = null;
		if(firstNode != null){
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			// set previous node to null
			firstNode.setPreviousNode(null);
		}
		return front;
	}

	@Override
	public T removeBack() {
		T back = null;
		if(lastNode != null){
			back = lastNode.getData();
			lastNode = lastNode.getPreviousNode();
			lastNode.setNextNode(null);
		}
		return back;
	}

	@Override
	public T getFront() {
		T front = null;
		if(firstNode != null)
			front = firstNode.getData();
		return front;
	}

	@Override
	public T getBack() {
		T back = null;
		if(lastNode != null)
			back = lastNode.getData();
		return back;
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null && lastNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}
} // end LinkedDeque