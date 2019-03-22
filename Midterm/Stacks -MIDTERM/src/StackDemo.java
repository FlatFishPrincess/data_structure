import java.util.Stack;

/**
   A driver that demonstrates the class VectorStack.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class StackDemo {
	public static void main(String[] args) {
		testStackOperations();
		System.out.println("\n\nDone.");
	} // end main

	public static void testStackOperations() {
		System.out.println("Create a stack: ");

		// Uncomment out one of the following to test your implementation

		StackInterface<String> myStack = new VectorStack2<>();
//		StackInterface<String> myStack = new ArrayStack<>();
//		StackInterface<String> myStack = new LinkedStack2<>();

		// comment this out to test the above
//		Stack<String> myStack = new Stack<>();

		System.out.println("isEmpty() returns " + myStack.isEmpty());

		System.out.println("\nAdd to stack to get\n" + "Joe Jane Jill Jess Jim");
		myStack.push("Jim");
		myStack.push("Jess");
		myStack.push("Jill");
		myStack.push("Jane");
		myStack.push("Joe");

		System.out.println("\nisEmpty() returns " + myStack.isEmpty());

		System.out.println("\nTesting peek and pop:");
		while (!myStack.isEmpty()) {
			String top = myStack.peek();
			System.out.println("\n" + top + " is at the top of the stack.");

			top = myStack.pop();
			System.out.println(top + " is removed from the stack.");
		} // end while

		System.out.print("\nThe stack should be empty: ");
		System.out.println("isEmpty() returns " + myStack.isEmpty());

		System.out.println("\nAdd to stack to get\n" + "Jim Jess Joe\n");
		myStack.push("Joe");
		myStack.push("Jess");
		myStack.push("Jim");

		System.out.println("\nTesting clear:");
		myStack.clear();

		System.out.println("The stack should be empty: ");
		System.out.println("\nisEmpty() returns " + myStack.isEmpty());

		System.out.println("\n myStack.peek() returns ");
		try {
			System.out.println(myStack.peek());
		}
		catch(Exception e) {
			System.out.println("Oooops peeking in an empty stack: " + e);
		}
		System.out.println("\n myStack.pop()  returns ");
		System.out.println(myStack.pop());
	} // end testStackOperations
} 

/*
 Create a stack:
 isEmpty() returns true
 
 Add to stack to get
 Joe Jane Jill Jess Jim
 
 isEmpty() returns false
 
 Testing peek and pop:
 
 Joe is at the top of the stack.
 Joe is removed from the stack.
 
 Jane is at the top of the stack.
 Jane is removed from the stack.
 
 Jill is at the top of the stack.
 Jill is removed from the stack.
 
 Jess is at the top of the stack.
 Jess is removed from the stack.
 
 Jim is at the top of the stack.
 Jim is removed from the stack.
 
 The stack should be empty: isEmpty() returns true
 
 Add to stack to get
 Jim Jess Joe
 
 
 Testing clear:
 The stack should be empty:
 
 isEmpty() returns true
 
 myStack.peek() returns
 Exception in thread "main" java.util.EmptyStackException
 at VectorStack.peek(VectorStack.java:41)
 at Driver.testStackOperations(Driver.java:58)
 at Driver.main(Driver.java:12)
        */
