package Compression;

/**
 * This is a multifunctional class which contains
 * a character, its frequency in a document, and its huffman code.
 * 
 * It also has children, which means it can be used to construct a binary tree.
 * 
 * Since the huffman code algorithm requires us to have frequency table and then
 * a tree structure, this allows us to do both.
 * @author mhrybyk
 *
 */
public class CharNode implements Comparable<CharNode> {
	// we use Character instead of char as this can be null if it is a parent in the
	// tree with children that might have real character data.
	private Character c;
	private Integer frequency;  // number of times this character appears in the file.
	private int code;  // huffman code, with MSB as a 1
	private CharNode leftChild; // Reference to left child
	private CharNode rightChild; // Reference to right child

	public CharNode() {
		this(null, 0);
	}

	/**
	 * Use this to initially create a node with just the character and its frequency.
	 * @param c character from the stream
	 * @param frequency number of times the character appears
	 */
	public CharNode(Character c, Integer frequency) {
		this(c, frequency, null, null); // Call next constructor
	} 

	/**
	 * Use this to initially create a node with just the character and its frequency,
	 * and can also set children.
	 * @param c character from the stream
	 * @param frequency number of times the character appears
	 * @param newLeftChild
	 * @param newRightChild
	 */
	public CharNode(Character c, Integer frequency, CharNode newLeftChild, CharNode newRightChild) {
		this.c = c;
		this.frequency = frequency;
		code = 0;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}

	/**
	 * Get the huffman code
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * set the huffman code
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the character for this node
	 */
	public Character getCharacter() {
		return c;
	}

	/**
	 * @param c the character to set
	 */
	public void setCharacter(Character c) {
		this.c = c;
	}

	/**
	 * @return the frequency
	 */
	public Integer getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	/**
	 * Retrieves the left child of this node.
	 * 
	 * @return A reference to this node's left child.
	 */
	public CharNode getLeftChild() {
		return leftChild;
	}

	/**
	 * Sets this node’s left child to a given node.
	 * 
	 * @param newLeftChild A node that will be the left child.
	 */
	public void setLeftChild(CharNode newLeftChild) {
		leftChild = newLeftChild;
	}

	/**
	 * Detects whether this node has a left child.
	 * 
	 * @return True if the node has a left child.
	 */
	public boolean hasLeftChild() {
		return leftChild != null;
	}

	/**
	 * Retrieves the right child of this node.
	 * 
	 * @return A reference to this node's right child.
	 */
	public CharNode getRightChild() {
		return rightChild;
	}

	/**
	 * Sets this node’s right child to a given node.
	 * 
	 * @param newRightChild A node that will be the right child.
	 */
	public void setRightChild(CharNode newRightChild) {
		rightChild = newRightChild;
	}

	/**
	 * Detects whether this node has a right child.
	 * 
	 * @return True if the node has a right child.
	 */
	public boolean hasRightChild() {
		return rightChild != null;
	}

	/**
	 * Detects whether this node is a leaf.
	 * 
	 * @return True if the node is a leaf.
	 */
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}

	@Override
	public String toString() {
		String s;  // output string
		
		// c can be null, or white space. if it
		// is, set the output string to something appropriate.

		if (c == null)
			s = "null";
		else
			switch (c) {
			case '\n':
				s = "newline";
				break;
			case '\r':
				s = "return";
				break;
			case '\t':
				s = "tab";
				break;
			case ' ':
				s = "space";
				break;
			default:
				// just set the output to the character
				s = Character.toString(c);
				break;
			}

		// convert the huffman code to a binary string
		// for example, 4 would be converted to 100
		
		String bitCode = Integer.toBinaryString(code);
		
		// finally output the character, frequency, and code
		
		return "[ " + s + ", " + frequency + " code: " + bitCode  + "]";			
	}

	@Override
	public int compareTo(CharNode other) {
		return this.frequency.compareTo(other.frequency);
	}
} 
