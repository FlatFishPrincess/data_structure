// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0

package TreePackage;

import java.util.Iterator;

/**
 * An interface for a node in a general tree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
interface GeneralNodeInterface<T> {
	/**
	 * Get the data from a node
	 * @return
	 */
	public T getData();

	/**
	 * Set the data in a node
	 * @param newData
	 */
	public void setData(T newData);

	/**
	 * Tests to see if this node is a leaf node
	 * @return true if a leaf node with no children
	 */
	public boolean isLeaf();

	/**
	 * Gets and iterator to traverse all child nodes
	 * @return
	 */
	public Iterator<GeneralNodeInterface<T>> getChildrenIterator();

	/**
	 * Adds a child to this node
	 * @param newChild
	 */
	public void addChild(GeneralNodeInterface<T> newChild);
} // end GeneralNodeInterface
