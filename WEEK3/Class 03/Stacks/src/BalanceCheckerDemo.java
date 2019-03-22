import java.util.Scanner;

/**
 * Demonstrates the use of a stack for checking balanced parentheses
 * @author mhrybyk
 *
 */
public class BalanceCheckerDemo {

	public static void main(String[] args) {
		
		// get the expression to be evaluated.
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter string expression:");
		
		String input = keyboard.nextLine();
		
		// now check it
		
		if(BalanceChecker2.checkBalance(input))
			System.out.println("OK: " + input);
		else System.out.println("FAILED: " + input);

		keyboard.close();

	}

}
