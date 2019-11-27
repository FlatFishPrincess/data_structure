package Compression;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import HeapPackage.*;

/**
 * Huffman code, as per P.706 Carrano Project #10
 * 
 * From a file, read in each character and calculate its frequency.
 * 	Similar to FrequencyCounter example covered in class
 * 
 * Store this in a HashMap (from java library). Key is the character, and value is 
 * 	CharNode, which includes all information about the character including its frequency and eventual code.
 * 	This avoids having to have two separate classes.
 * 
 * Take the hashmap, and put it in a priority queue, with low frequency letters at the head of the queue.
 * 
 * Convert this priority queue to a tree using the steps described in the project.
 * 
 * Finally, traverse the tree, and set each node's huffman code.
 *
 */
public class HuffmanCodingDemo {
	public static void main(String[] args) {
		
		// this is where we keep each character found in the file, and its associated information
		
		HashMap<Character, CharNode> characterFrequencies = null;

		// test file to generate codes. replace this with others as you see fit
		
		String fileName = "dictionary.txt"; 
//		String fileName = "FrequencyCounterData.txt"; 

		// open the file and get the frequences for all characters in the file
		
		try {
			InputStream data = new FileInputStream(new File(fileName));
			Reader reader = new InputStreamReader(data);
			characterFrequencies = readFile(reader);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}

		// display the character map. All of the codes will be zero.
		displayCharacterMap(characterFrequencies);

		// convert the character map to a priority queue
		
		PriorityQueueInterface<CharNode> pq = toPQ(characterFrequencies);
		
		// convert the priority queue to a tree. The last node in the queue will be the root of the tree
		
		CharNode root = toTree(pq);
		
		// set the root's code to 1
		// the code will be bit shifted to the left for each set of children
		
		root.setCode(1);

		// set the codes for all other nodes in the tree
		
		setCodes(root);
		
		// display the tree
		
		System.out.println("\nDisplayTree, letter frequencies and codes\n");
		displayTree(root);
		
		// display the character map again. this time all of the codes should also appear.
		
		displayCharacterMap(characterFrequencies);
	

	} 

	/**
	 * Using a Reader, read a character at a time until the end of the stream.
	 * 
	 * Add this character to the HashMap if it is not there,
	 * otherwise simply update the frequency in CharNode.
	 * 
	 * Note the hashmap has a Character as a key, and a CharNode as a value.
	 * CharNode contains frequency that must be updated.
	 * @param reader
	 * @return HashMap of characters and their frequencies
	 */
	static public HashMap<Character, CharNode> readFile(Reader reader) {

		HashMap<Character, CharNode> characterFrequencies = new HashMap<>();
		// for each letter see if it is in the word table
		// if not, add it with a value of 1, otherwise simply update the frequency

		int nextChar;

		try {
			while ((nextChar = reader.read()) != -1) {
				Character c = (char) nextChar;
				if(characterFrequencies.containsKey(c)){ // if character is in the word table
					int frequency = characterFrequencies.get(c).getFrequency();
					 characterFrequencies.get(c).setFrequency(frequency + 1);
				} else { // update frequency
					//(Character c, Integer frequency, CharNode newLeftChild, CharNode newRightChild)
					CharNode newNode = new CharNode(c, 1);
					characterFrequencies.put(c, newNode);
				}
				// your code goes here
				// add the character to the HashMap
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(1);
		} // end while
		return characterFrequencies;

	} 
	

	
	/**
	 * Display the HashMap of characters and their frequencies.
	 * 
	 * Simply iterate through the HashMap by using keySet() to get the set of keys,
	 * then an iterator for the Set. See the example in the Dictionaries exercises.
	 * @param characterFrequencies
	 */
	static void displayCharacterMap(HashMap<Character, CharNode> characterFrequencies) {

		// your code goes here
		
		Set<Character> keys = characterFrequencies.keySet();
		Iterator<Character> keysIterator = keys.iterator();
		
		System.out.println("\nCharacter Map, letter frequencies, size " + keys.size() + "\n");

		while (keysIterator.hasNext()) {

			// iterate through each key, then each value, as they match up

			Character c = keysIterator.next();

			System.out.println(characterFrequencies.get(c));

		} // end while
	}
	
	/**
	 * Take the hashmap of characters and their frequencies, and convert it into
	 * a priority queue.
	 * 
	 * You MUST create a HeapPriorityQueue (which you implemented as the first part of the
	 * assignment), then enqueue each CharNode. 
	 * 
	 * Note that CharNode's compareTo() method will be used by the MinHeap implementation.
	 * @param table
	 * @return
	 */
	static PriorityQueueInterface<CharNode> toPQ(HashMap<Character, CharNode> table) {

		// your code goes here
		Set<Character> keyIterator = table.keySet();
		Iterator<CharNode> valueIterator =  table.values().iterator();
		
		// PriorityQueueInterface 
		PriorityQueueInterface<CharNode> result = new HeapPriorityQueue<>();
		
		while(valueIterator.hasNext()){
			CharNode currentNode = valueIterator.next();
			result.add(currentNode);
		}
		return result;
	}

	/**
	 * Convert the priority queue to a tree. The last node in the priority queue
	 * will be the root of the tree.
	 * 
	 * The algorithm is to remove two nodes from the queue, then create a new
	 * CharNode whose Character is null, and whose frequency is the sum of the
	 * frequencies of the two nodes removed.
	 * 
	 * Make this new node the parent of the two nodes just removed, then put the 
	 * this parent node back on priority queue.
	 * 
	 * Do this until the queue size is 1. Then return the last queue element, which will be the 
	 * root of the tree.
	 * 
	 * For more explanation, see Carrano Chapter 25 Project 10, page 706.
	 * @param pq
	 * @return
	 */
	static CharNode toTree(PriorityQueueInterface<CharNode> pq) {

		CharNode parentTree = new CharNode();
		CharNode grandParentTree = new CharNode();
		// your code goes here
		while(!pq.isEmpty()){
			CharNode newTree = pq.remove();
			if(parentTree.getFrequency() == 0){ // create first node tree
				CharNode secondTree = pq.remove(); // assume that pq has at least two elements
				if(newTree.getFrequency().compareTo(secondTree.getFrequency()) < 0){ 
					int parentTreeInt = newTree.getFrequency() + secondTree.getFrequency(); // get total frequency
					parentTree.setFrequency(parentTreeInt);
					parentTree.setLeftChild(newTree);
					parentTree.setRightChild(secondTree);
				}
			} else {
				int parentTreeInt = newTree.getFrequency() + parentTree.getFrequency();
				grandParentTree.setFrequency(parentTreeInt);
				grandParentTree.setLeftChild(parentTree);
				grandParentTree.setRightChild(newTree);
			}
		}
		
		return grandParentTree;

	}

	/**
	 * Display the tree by using recursive pre-order traversal.
	 * @param root
	 */
	public static void displayTree(CharNode root) {
		// root -> left -> right
//		Root: [ null, 2005363 code: 1]
//	     > left child: Root: [ null, 813838 code: 10]
//	    		 Parent: [ g, 44849 code: 100000]
//	    				 > right child: Root: [ m, 46506 code: 100001]
		System.out.println("Root:  [" + root.getCharacter() +  ", " + root.getFrequency() + ", code: " + root.getCode() + "]");
		if(root.hasLeftChild()){
			System.out.println(" > left child Root:[" + root.getCharacter() +  ", " + root.getFrequency() + ", code: " + root.getCode() + "]");
			displayTree(root.getLeftChild());
		}
		if(root.hasRightChild()){
			System.out.println(" > right child: Root:[" + root.getCharacter() +  ", " + root.getFrequency() + ", code: " + root.getCode() + "]");
			displayTree(root.getRightChild());
		}
	}
	
	
	/**
	 * Set the huffman code for each character in the tree.
	 * 
	 * We do this by shifting the code bits to the left by one. This
	 * becomes the code for the left child. It will end in zero.
	 * 
	 * We then take the same code and add 1 to it for the right child
	 * 
	 * Visit each node using recursive pre-order traversal
	 * 
	 * @param root
	 */
    static void setCodes(CharNode root) {
    	
    	// shift the code to the left by one bit
    	// this leaves a zero in the LSB
    	// for example, if the code for root is binary 11, 
    	// shifting it by one to the left will be 110.
    	
    	int code = root.getCode() << 1;

    	// your code for preorder traversal goes here.

     
    }

}