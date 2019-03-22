import java.util.Scanner;

/**
 * A class of telephone directories.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class TelephoneDirectory {
	private DictionaryInterface<Name, String> phoneBook; // Sorted dictionary with distinct search keys

	public TelephoneDirectory() {
//		phoneBook = new SortedArrayDictionary<>();
		phoneBook = new SortedLinkedDictionary<>();
//		phoneBook = new SortedVectorDictionary<>();
	} // end default constructor

	// Segment 20.10
	/**
	 * Reads a text file of names and telephone numbers.
	 * 
	 * @param data A text scanner for the text file of data.
	 */
	public void readFile(Scanner data) {
		
		// get each token from a line in the file
		
		while (data.hasNext()) {
			String firstName = data.next();
			String lastName = data.next();
			String phoneNumber = data.next();

			Name fullName = new Name(firstName, lastName);
			phoneBook.add(fullName, phoneNumber);
		} // end while

	} // end readFile

	// Segment 20.11
	/** Gets the phone number of a given person. */
	public String getPhoneNumber(Name personName) {
		return phoneBook.getValue(personName);
	} // end getPhoneNumber

	public String getPhoneNumber(String firstName, String lastName) {
		Name fullName = new Name(firstName, lastName);
		return phoneBook.getValue(fullName);
	} // end getPhoneNumber

} // end TelephoneDirectory

