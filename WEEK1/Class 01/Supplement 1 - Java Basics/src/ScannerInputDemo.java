import java.util.Scanner;

/**
 * ScannerInputDemo
 * 
 * Shows use of scanner input
 * Note need for import statement
 * @author mhrybyk
 *
 */
public class ScannerInputDemo {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter age: ");
		
		System.out.println("Age is " + keyboard.nextInt());
		
		// keyboard.nextLine();
		
		// if the above is commented out, program will read everything after the int to the new line char!!
		
		System.out.println("Enter name: ");
		
		String myName = keyboard.nextLine();
		
		System.out.println("Your name is: " + myName);
		
		keyboard.close();
		

	}

}
