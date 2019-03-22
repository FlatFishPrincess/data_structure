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

	
	@Override
	public void addToFront(T newEntry) {
		DLNode newNode = new DLNode(null, newEntry, firstNode);
		if(firstNode == null)
			// if queue is empty, then set newNode to last Node
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);
		firstNode = newNode;
	}

	@Override
	public void addToBack(T newEntry) {
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		if(lastNode == null)
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;	
	}

	@Override
	public T removeFront() {
		T result = firstNode.getData();
		firstNode = firstNode.getNextNode();
		if(firstNode == null)
			lastNode = null;
		else
			firstNode.setPreviousNode(null);
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
		return firstNode == null && lastNode == null;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}
	
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
} // end LinkedDeque
