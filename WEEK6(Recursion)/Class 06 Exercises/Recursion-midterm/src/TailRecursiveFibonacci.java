
/**
 * @author mhrybyk
 * 
 * A class computing a fibonacci number using tail recursion 
 *  
 * A fibonacci number of any sequence is the sum of the previous two fibonacci numbers
 * 
 * Assumptions
 * f(0) = 0
 * f(1) = 1
 * 
 * and therefore f(2) = 1, f(3) = 2, f(4) = 3, f(5) = 5, f(6) = 8 etc.
 * 
 * For the sequence 0..10
 * n: 0, 1, 2, 3, 4, 5, 6,  7,  8,  9, 10
 * 
 * f: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 * 
 * So the fibonacci number of 10 is 55.
 * 
 */
public class TailRecursiveFibonacci implements SequenceInterface {
	
	private String name;            // the name of this sequence
	private int numberOfCalls = 0; 	// counter to keep number of recursive calls
	
	// set the name of the sequence 
	public TailRecursiveFibonacci(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}


	/**
	 * Reset the number of calls. This can be done before
	 * every compute() call if desired. Otherwise the tally keeps increasing
	 * across calls.
	 * @param numberOfCalls
	 */
	public void resetNumberOfCalls() {
		this.numberOfCalls = 0;
	}

	/**
	 * return the number of times compute() is called
	 * @return
	 */
	public int getNumberOfCalls() {
		return numberOfCalls;
	}
	
	/**
	 * compute fibonacci number using tail recursion
	 * 
	 * @param n A positive integer.
	 * @return the nth fibonacci number.
	 */
	
	
	
	public long compute(long n) {
		return computeHelper(n, 0, 1);
	}
     
	private long computeHelper(long n, long previous, long result ) 
    {  
		numberOfCalls++;
		if(n == 0)
			return previous;
		else if(n == 1)
			return result;
		else 
			return computeHelper(n-1, result, result + previous);
    } 


}
