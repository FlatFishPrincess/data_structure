import java.util.*;
import java.io.*;

public class AnagramsUsingDictionaryInterface2 {
	public static void main(String[] args) throws IOException {
		
		// comment out one of these lines to test
		
//		--- I cannot solve hashedDictionaty, with contains. whenever I put contains function, it loops infinitely--
		DictionaryInterface<String, ArrayList<String>> anagrams = new HashedDictionary<String, ArrayList<String>>();
//		DictionaryInterface<String, ArrayList<String>> anagrams = new HashMapDictionary<String, ArrayList<String>>();
		
		String[] testWords = {
				"thesis",
				"server",
				"sublet",
				"reverse",
				"retraced",
				"stripes",
				"evils",
				"nailset",
				"reliant",
				"demo",
				"deer",
				"rifles",
				"bariton",
				"pointer",
				"cobra",
				"strip",
				"sterling",
				"earliest",
				"rowths",
				"reshoots",
				"presplit",
				"teach",
				"scare",
				"bread"
		};

		// get all anagrams for all words in the file.
		createAnagrams("dictionary.txt", anagrams);

		// display all anagrams for the list of test words to the console
		
		System.out.println("******** Showing anagrams for test words");
		
		// insert your code here to display the anagrams for the test words above.
		// the output should match anagramsTestWordsOutput.txt exactly
		
		Iterator<ArrayList<String>> valueList = anagrams.getValueIterator();
		for(String key : testWords){
			System.out.println("Anagrams for " + key + anagrams.getValue(sortString(key)));
		}
		// write all keys and values to the anagrams.txt file.
		// use the iterators to do this.
		
		// open the output file
		
		PrintWriter outputFile = new PrintWriter("anagrams-hashed.txt");
		
		
		outputFile.println("********* Showing all keys and anagrams - total = " + anagrams.getSize());
		
		// insert your code here to write all keys and values of the anagrams hash table to the file
		// the output should match the anagramsAssignmentOutput.txt file exactly
		Iterator<String> keyList = anagrams.getKeyIterator();
		while(keyList.hasNext()){
			String key = keyList.next();
			outputFile.println(key + ": " + anagrams.getValue(key));
		}
		
		outputFile.close();

	}

	/**
	 * Sorts a word by its characters and places them in the output string
	 * @param word
	 * @return string of sorted letters based on the input
	 */
	private static String sortString(String word) {
		char[] wordCharacters = word.toCharArray();
		Arrays.sort(wordCharacters);
		return new String(wordCharacters);
	}

	/**
	 * Create a list of anagrams from a dictionary file and place into a Dictionary. An anagram has key which is a set
	 * of sorted characters, and a value consisting of an array of strings that are legal words in the dictionary that match
	 * the characters in the key.
	 * 
	 * anagramsMap for this assignment must use a hash table.
	 * @param fileName for dictionary words. Each word in the file should be on a separate line.
	 * @param anagramsMap resulting anagrams table
	 * @throws IOException
	 */
	private static void createAnagrams(String fileName, DictionaryInterface<String, ArrayList<String>> anagramsMap)
			throws IOException {
		
		// read file
	    File file =  new File(fileName); 
	    Scanner sc = new Scanner(file); 
	    ArrayList valueList;
	    // this while loop keeps continue whenever I put contains function. 
	    // I couldn't figure it out 
	    while (sc.hasNextLine()) {
	    	// list for values 
	    	valueList = new ArrayList<String>();
	    	String value = sc.nextLine();
	    	String key = sortString(value);
//	    	System.out.println("key: " + key + " value: " + value);
	    	if(anagramsMap.contains(key)){
	    		valueList = anagramsMap.getValue(key);
//	    		System.out.println("key found! with values == " + valueList);
	    	} 
	    	valueList.add(value);
	    	anagramsMap.add(key, valueList);

	    }
	}

}
