import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheck {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		// Infinite loop. User must terminate program to exit
		
		while(true) {
			System.out.print("Enter string: ");
			String inputString = keyboard.nextLine();
			
			String not = "not ";			
			if(CheckPalindrome(inputString))
				not = "";
			
			System.out.println(inputString + " is " + not + "a palindrome.");
		}
	}
	
	/**
	 * Check to see if a string is a palindrome by comparing input to its reverse
	 * @param s input string to check
	 * @return true if it is a palindrome
	 */
	static boolean CheckPalindrome(String s) {
		
		if(s == null) {
			System.out.println("Null string in CheckPalindrome()");
			return false;
		}
		
		String reversedString = ReverseString(s);

		return s.equals(reversedString);
	}
	
	/**
	 * Reverse a string using a stack
	 * @param s input string
	 * @return reversed string
	 */
	static String ReverseString(String s) {
		Stack<Character> charStack = new Stack<>();
		
		// push each character in the string onto the stack
		
		for (int i = 0; i < s.length(); i++) {
			charStack.push(s.charAt(i));			
		}
		
		// popping each char will reverse the string
		
		String reversedString = new String();
		while(charStack.isEmpty() == false) {
			reversedString = reversedString + charStack.pop();
		}
		
		return reversedString;
	}
	
	/**
	 * Check to see if a string is a palindrome recursively by checking
	 * first and last letters
	 * @param s input string to check
	 * @return true if it is a palindrome
	 */
	static boolean CheckPalindromeUsingRecursion(String s) {
		
		// we are in the middle (1 or 0 chars left) so it is good
		
		if(s.length() <= 1)
			return true;
		
		// compare start and end letters. 
		// if the same, call recursively on a string without those two letters
		// if not, we are done
		
		char start = s.charAt(0);
		char end = s.charAt(s.length() - 1);
		
		if(start == end) {
			// remember substring end is really endindex - 1!!
			return CheckPalindromeUsingRecursion(s.substring(1, s.length() - 1));
		}
		else return false;
		
	}

}
