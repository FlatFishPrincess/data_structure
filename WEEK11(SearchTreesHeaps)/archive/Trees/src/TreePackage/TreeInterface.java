package TreePackage;

/**
 * An interface of basic methods for the ADT tree.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public interface TreeInterface<T> {

	/**
	 * Gets the data at the root node of the tree
	 * @return data of type T in the node
	 */
	public T getRootData();

	/**
	 * Get the height of the tree
	 * @return tree height
	 */
	public int getHeight();

	/**
	 * Get the number of nodes in the tree from the root
	 * @return number of nodes
	 */
	public int getNumberOfNodes();

	/**
	 * Checks to see if the tree has any nodes
	 * @return true if there are no nodes in the tree
	 */
	public boolean isEmpty();

	/**
	 * Clears all nodes in the tree, leaving it empty
	 */
	public void clear();
}
