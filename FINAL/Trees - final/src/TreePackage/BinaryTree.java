package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import StackAndQueuePackage.*; // Needed by tree iterators

/**
 * A class that implements the ADT binary tree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {
	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	} // end default constructor

	/**
	 * Create the tree with a single root node from data
	 * @param rootData
	 */
	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	} // end constructor

	/**
	 * Create the tree from a new root node and two other trees that will now become subtrees from root.
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 */
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	} // end constructor

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		initializeTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
	} // end setTree

	/**
	 * Combine two subtrees into a single tree with a new root.
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 */
	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		// < FIRST DRAFT - See Segments 25.4 - 25.7 for improvements. >
		root = new BinaryNode<T>(rootData);

		if (leftTree != null)
			root.setLeftChild(leftTree.root);

		if (rightTree != null)
			root.setRightChild(rightTree.root);
	} // end initializeTree

	@Override
	public T getRootData() {
		T result = root.getData();
		return result;
	}

	/**
	 * @return the root
	 */
	public BinaryNode<T> getRootNode() {
		return root;
	}

	@Override
	public int getHeight() {
		return getHeight(root);
	}
	
	private int getHeight(BinaryNode<T> node){
		int height = 0;
		if (node != null){
			int leftHeight = 1 + getHeight(node.getLeftChild());
			int rightHeight = 1 + getHeight(node.getRightChild());
			height = Math.max(leftHeight, rightHeight);
		}
		return height; 
//		height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
//		return height;
//		if (node == null) return 0;
//		  return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
	}

	@Override
	public int getNumberOfNodes() {
		int numberOfNodes = 0;
	    if (root != null)
	       numberOfNodes = root.getNumberOfNodes();
	    return numberOfNodes;
	}

	@Override
	public boolean isEmpty() {
		  return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostIterator();
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		return new LevelOrderIterator();
	}

	@Override
	public void setRootData(T rootData) {
		root.setData(rootData);
	}

	/*
	 * Implementations of setRootData, getRootData, getHeight, getNumberOfNodes,
	 * isEmpty, clear, and the methods specified in TreeIteratorInterface are here.
	 * . . .
	 */
	
	private class InorderIterator implements Iterator<T>
	{
	   private StackInterface<BinaryNode<T>> nodeStack;
	   private BinaryNode<T> currentNode;

	   public InorderIterator()
	   {
	      nodeStack = new LinkedStack<>();
	      currentNode = root;
	   } // end default constructor

	   public boolean hasNext() 
	   {
	      return !nodeStack.isEmpty() || (currentNode != null);
	   } // end hasNext

	   public T next()
	   {
	      BinaryNode<T> nextNode = null;

	      // Find leftmost node with no left child
	      while (currentNode != null)
	      {
	         nodeStack.push(currentNode);
	         currentNode = currentNode.getLeftChild();
	      } // end while

	      // Get leftmost node, then move to its right subtree
	      if (!nodeStack.isEmpty())
	      {
	         nextNode = nodeStack.pop();
	         // Assertion: nextNode != null, since nodeStack was not empty
	         // before the pop
	         currentNode = nextNode.getRightChild();
	      }
	      else
	         throw new NoSuchElementException();

	      return nextNode.getData(); 
	   } // end next

	   public void remove()
	   {
	      throw new UnsupportedOperationException();
	   } // end remove
	} // end InorderIterator
	
	private class PreorderIterator implements Iterator<T>
	{
	   private StackInterface<BinaryNode<T>> nodeStack;

	   public PreorderIterator()
	   {
	      nodeStack = new LinkedStack<>();
	      if(root != null)
	    	  nodeStack.push(root);
	   } // end default constructor

	   public boolean hasNext() 
	   {
	      return !nodeStack.isEmpty();
	   } // end hasNext

	   public T next()
	   {
	      BinaryNode<T> nextNode = null;
	      if(hasNext()){
	    	  nextNode = nodeStack.pop();
	    	  BinaryNode leftChild = nextNode.getLeftChild();
	    	  BinaryNode rightChild = nextNode.getRightChild();
	    	  
	    	  if(rightChild != null)
	    		  nodeStack.push(rightChild);
	    	  if(leftChild != null)
	    		  nodeStack.push(leftChild);
	      }
	      return nextNode.getData(); 
	   } // end next

	   public void remove()
	   {
	      throw new UnsupportedOperationException();
	   } // end remove
	} // end Preporder
	
	private class PostIterator implements Iterator<T> {
	   private StackInterface<BinaryNode<T>> nodeStack;
	   private BinaryNode<T> currentNode;
	   
	   public PostIterator()
	   {
	      nodeStack = new LinkedStack<>();
	      currentNode = root;
	   } // end default constructor

	   public boolean hasNext() 
	   {
	      return !nodeStack.isEmpty() || currentNode != null;
	   } // end hasNext

	   public T next(){
	      BinaryNode<T> leftChild, rightChild, nextNode = null;
	      boolean foundNext = false;
	      
	      // find leftmost node
	      while (currentNode != null){
		    nodeStack.push(currentNode);
		    leftChild = currentNode.getLeftChild();
		    if (leftChild == null)	
		    	currentNode = currentNode.getRightChild();
		    else
		    	currentNode = leftChild;
		  } 
	      if (!nodeStack.isEmpty()){
		    nextNode = nodeStack.pop();
		    // nextNode != null since stack was not empty before pop
	    	BinaryNode<T> parent = nodeStack.peek();
		    if (parent != null && nextNode == parent.getLeftChild() && !parent.getLeftChild().getVisited()){
		    	currentNode = parent.getRightChild();	
		    	parent.getLeftChild().setVisited(true);
		    }	
		    else
		    	currentNode = null;
		  } else
			  throw new NoSuchElementException();
	      return nextNode.getData();
	   } // end next

	   public void remove()
	   {
	      throw new UnsupportedOperationException();
	   } // end remove
	} // end PostIterator

	private class LevelOrderIterator implements Iterator<T> {
		private QueueInterface<BinaryNode<T>> nodeQueue;
		public LevelOrderIterator(){
			nodeQueue = new LinkedQueue<BinaryNode<T>>();
			if (root != null)
			    nodeQueue.enqueue(root);
	    } // end default constructor
		
		public boolean hasNext() {
		    return !nodeQueue.isEmpty();
		} // end hasNext
		
		public T next(){
			BinaryNode<T> nextNode;
		    if (hasNext())
			{
			    nextNode = nodeQueue.dequeue();
			    BinaryNode<T> leftChild = nextNode.getLeftChild();
			    BinaryNode<T> rightChild = nextNode.getRightChild();

			    // add to queue in order of recursive calls
			    if (leftChild != null)
				nodeQueue.enqueue(leftChild);
	
			    if (rightChild != null)
				nodeQueue.enqueue(rightChild);
			}
		    else
			{
			    throw new NoSuchElementException();
			}
		    return nextNode.getData();
		} // end next
		
		public void remove(){
		    throw new UnsupportedOperationException();
		} // end remove
	 } // end LevelOrderIterator
} // end BinaryTree
