import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A driver that demonstrates the class TelephoneDirectory.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Cleaned up code a bit and reformatted
 */
public class TelephoneDirectoryDemo {
	
	// special Names that match on error or quit for user input
	private static final Name INPUT_ERROR = new Name("error", "error");
	private static final Name QUIT = new Name("quit", "quit");

	public static void main(String[] args) {
		TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
		String fileName = "TelephoneDirectoryData.txt"; // Or file name could be read

		try {
			// read all of the names and phone numbers from the file
			Scanner data = new Scanner(new File(fileName));
			telephoneDirectory.readFile(data);
			data.close(); // no longer needed, close it up
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}

		
		Name nextName = getName(); // Get name for search from user
		while (!nextName.equals(QUIT)) {
			if (nextName.equals(INPUT_ERROR))
				System.out.println("Error in entering name. Try again.");
			else {
				// look up the phone number for the name
				String phoneNumber = telephoneDirectory.getPhoneNumber(nextName);
				if (phoneNumber == null)
					System.out.println(nextName + " is not in the directory.");
				else
					System.out.println("The phone number for " + nextName + " is " + phoneNumber);
			} // end if

			nextName = getName();
		} // end while

		System.out.println("Bye!");
	} // end main

	/**
	 * Returns either the name read from user, INPUT_ERROR, or QUIT.
	 * @return Name 
	 */
	private static Name getName() {
		Name result = null;  // sentinel not set until we have a name
		
		// open and close the keyboard every time.
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter first name and last name, " + "or quit to end: ");
		String line = keyboard.nextLine();

		// is this a quit command?
		if (line.trim().toLowerCase().equals("quit"))
			result = QUIT;
		else {
			String firstName = null;
			String lastName = null;
			
			// tokenize the line
			Scanner scan = new Scanner(line);

			// make sure we have two tokens otherwise error
			if (scan.hasNext()) {
				firstName = scan.next();
				if (scan.hasNext())
					lastName = scan.next();
				else
					result = INPUT_ERROR;
			} else
				result = INPUT_ERROR;

			if (result == null) {
				// First and last names have been read
				// set the successful result
				result = new Name(firstName, lastName);
			} // end if
			scan.close();
		} // end if

		return result;
	} // end getName
} // end Driver

