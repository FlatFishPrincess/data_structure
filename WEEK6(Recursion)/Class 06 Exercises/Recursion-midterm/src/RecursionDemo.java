/**
 * Show the result of iterative and recursive implementations of factorial and fibonacci sequences
 * 
 * @author your name here
 *
 */
public class RecursionDemo {

	public static void main(String[] args) {

		// numbers to feed into the sequences
		
		long[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15};
		
		// for each implementation, create and display using qthe numbers above.
		
		IterativeFactorial iterativeFactorial = new IterativeFactorial("Iterative Factorial");
		DisplaySequence(numbers, iterativeFactorial);

		RecursiveFactorial recursiveFactorial = new RecursiveFactorial("Recursive Factorial");
		DisplaySequence(numbers, recursiveFactorial);

		TailRecursiveFactorial tailRecursiveFactorial = new TailRecursiveFactorial("Tail Recursive Factorial");
		DisplaySequence(numbers, tailRecursiveFactorial);
		
		IterativeFibonacci iterativeFibonacci = new IterativeFibonacci("Iterative Fibonacci");
		DisplaySequence(numbers, iterativeFibonacci);
		
		RecursiveFibonacci recursiveFibonacci = new RecursiveFibonacci("Recursive Fibonacci");
		DisplaySequence(numbers, recursiveFibonacci);

		TailRecursiveFibonacci tailRecursiveFibonacci = new TailRecursiveFibonacci("Tail Recursive Fibonacci");
		DisplaySequence(numbers, tailRecursiveFibonacci);

	}
	
	/**
	 * Given an array of numbers, display the result of the sequence.
	 * Show the number of recursive calls as well.
	 * Note that iterative implementations will only have a call count of 1.
	 * @param numbers input array of numbers the sequence will operate on
	 * @param sequence object of class that implements the interface
	 */
	public static void DisplaySequence(long[] numbers, SequenceInterface sequence) {
		for(long number : numbers) {
			sequence.resetNumberOfCalls();
			System.out.println("======== " + sequence.getName() 
				+ "(" + number + ") = " 
				+ sequence.compute(number)
				+ ", total calls "
				+ sequence.getNumberOfCalls());
		}		
	}

}


