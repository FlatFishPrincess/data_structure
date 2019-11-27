package SearchTrees;
import java.util.Iterator;
import java.util.NoSuchElementException;

import StackAndQueuePackage.LinkedStack;
import StackAndQueuePackage.StackInterface;
import TreePackage.*;

/**
 * A class that implements the ADT binary search tree by extending BinaryTree.
 * Recursive version.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {
	public BinarySearchTree() {
		super();
	} // end default constructor

	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
	} // end constructor

	// Disable setTree (see Segment 26.6)
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	} // end setTree

	@Override
	public T getRootData() {
		 return getRootNode().getData();
	}

	@Override
	public int getHeight() {
		 return getHeight(getRootNode()); // Call private getHeight
	}
	
	private int getHeight(BinaryNode<T> node)
	{
	   int height = 0;
	  
	   if (node != null)
	      height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));                       
	   return height;
	} // end getHeight

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(T anEntry) {
		return getEntry(anEntry) != null;
	}

	@Override
	public T getEntry(T anEntry) {
		return findEntry(getRootNode(), anEntry);
	}
	
	private T findEntry(BinaryNode<T> rootNode, T anEntry){
		T result = null;
		if(rootNode != null){
			T rootEntry = rootNode.getData();
			if(anEntry.equals(rootEntry))
				result = rootEntry;
			else if (anEntry.compareTo(rootEntry) < 0) // rootEntry is greater 
				result = findEntry(rootNode.getLeftChild(), anEntry);
			else if (anEntry.compareTo(rootEntry) > 0) // rootEntry is less
				result = findEntry(rootNode.getRightChild(), anEntry);
		}
		return result;
	}
	

	@Override
	public T add(T newEntry) {
		T result = null;
		if(isEmpty())
			setRootNode(new BinaryNode<>(newEntry));
		else 
			result = addEntry(getRootNode(), newEntry);
		return result;
	}

	private T addEntry(BinaryNode<T> rootNode, T anEntry){
		if(rootNode == null || anEntry == null)
			return null;
		T result = null;
		int comparison = anEntry.compareTo(rootNode.getData());
		if(comparison == 0){
			result = rootNode.getData();
			rootNode.setData(anEntry); //replace the data
		} else if (comparison < 0){ // if rootNode's data is bigger, then anEntry goes to left
			if(rootNode.hasLeftChild())
				result = addEntry(rootNode.getLeftChild(), anEntry);
			else 
				rootNode.setLeftChild(new BinaryNode<>(anEntry));
		} else { // rootNode's data is smaller, then an entry goes to right
			if(rootNode.hasRightChild())
				result = addEntry(rootNode.getRightChild(), anEntry);
			else 
				rootNode.setRightChild(new BinaryNode<>(anEntry));
		}
		return result;
	}
	@Override
	public T remove(T anEntry) {
		BinaryNode<T> oldEntry =  new BinaryNode<>(null);
		BinaryNode<T> newRoot = removeEntry(getRootNode(), anEntry, oldEntry);
		setRootNode(newRoot);
		return oldEntry.getData();
	}
	
	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T anEntry, BinaryNode<T> oldEntryObj){
		if(rootNode != null){
			T rootData = rootNode.getData();
			int comparison = anEntry.compareTo(rootNode.getData());
			if(comparison == 0){ // anEntry == rootNode's data
				oldEntryObj.setData(rootData);
				rootNode = removeFromRoot(rootNode);
			} else if(comparison < 0){ // root entry is bigger than an entry
				BinaryNode<T> leftChild = rootNode.getLeftChild();
				BinaryNode<T> subtreeRoot = removeEntry(leftChild, anEntry, oldEntryObj);
				rootNode.setLeftChild(subtreeRoot);
			} else { // anEntry > root entry
				BinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, anEntry, oldEntryObj));
			}
		}
		return rootNode;
	}
	
	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode){
		// if rootNode has two children, find the largest data from the left subtree
		// then set the subtree that the largest number has been removed to root
		
		// Q. then the assertion is the rootNode has at least one child? 
		// case 1 : has left and right child? 
		if(rootNode.hasLeftChild() && rootNode.hasRightChild()){
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
			
			// replace entry in root
			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		} 
		// case 2: has one child? 
		else if (rootNode.hasRightChild()) // 
			rootNode = rootNode.getRightChild();
		else 
			rootNode = rootNode.getLeftChild();
		return rootNode;
	}
	
	private BinaryNode<T> findLargest(BinaryNode<T> rootNode){
		if(rootNode.hasRightChild())
			rootNode = findLargest(rootNode.getRightChild());
		return rootNode;
	}
	
	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode){
		if(rootNode.hasRightChild()){
			BinaryNode<T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		} else
			rootNode = rootNode.getLeftChild();
		return rootNode;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		 return new InorderIterator();
	}
	
	private class InorderIterator implements Iterator<T>
	{
	   private StackInterface<BinaryNode<T>> nodeStack;
	   private BinaryNode<T> currentNode;

	   public InorderIterator()
	   {
	      nodeStack = new LinkedStack<>();
	      currentNode = getRootNode();
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

}
