import java.util.Scanner;

/**
 * Demonstrates the use of a stack for checking balanced parentheses
 * @author mhrybyk
 *
 */
public class LinkedStackDemo {

	public static void main(String[] args) {

		LinkedStack<Integer> linkedStack = new LinkedStack<>();
		linkedStack.push(3);
		linkedStack.push(5);
		linkedStack.push(7);
		linkedStack.push(8);
		linkedStack.push(9);
		linkedStack.push(20);

	}

}
