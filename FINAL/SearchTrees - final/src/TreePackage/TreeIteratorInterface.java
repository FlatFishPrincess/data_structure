package TreePackage;

import java.util.Iterator;

/**
 * An interface of iterators for the ADT tree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Not sure why we need separate iterators for these, could just have a single
 * iterator in the tree interface.
 */
public interface TreeIteratorInterface<T> {
	public Iterator<T> getPreorderIterator();

	public Iterator<T> getPostorderIterator();

	public Iterator<T> getInorderIterator();

	public Iterator<T> getLevelOrderIterator();
} 
