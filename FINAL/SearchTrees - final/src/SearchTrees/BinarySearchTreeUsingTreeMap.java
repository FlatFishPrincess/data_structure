package SearchTrees;
import java.util.Iterator;
import TreePackage.*;
import java.util.TreeSet;

/**
 * A class that implements the ADT binary search tree by extending BinaryTree.
 * Recursive version.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class BinarySearchTreeUsingTreeMap<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {
	
	TreeSet<T> tree = new TreeSet<>();
	public BinarySearchTreeUsingTreeMap() {
		super();
	} // end default constructor

	public BinarySearchTreeUsingTreeMap(T rootEntry) {
		super();
		
		tree.add(rootEntry);
	} // end constructor

	// Disable setTree (see Segment 26.6)
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	} // end setTree

	@Override
	public T getRootData() {
		return tree.first();
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		return tree.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tree.isEmpty();
	}

	@Override
	public void clear() {
		tree.clear();

	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return tree.contains(anEntry);
	}

	@Override
	public T getEntry(T anEntry) {
		if(tree.contains(anEntry))
			return anEntry;
		return null;
	}

	@Override
	public T add(T anEntry) {
		// TODO Auto-generated method stub
		
		if(tree.add(anEntry))
			return null;
		return anEntry;
	}

	@Override
	public T remove(T anEntry) {
		if(tree.remove(anEntry))
			return anEntry;
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return tree.iterator();
	}

}
