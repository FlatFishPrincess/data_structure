
/**
 * Compute factorial using basic recursion
 * @author mhrybyk
 *  
 */
public class RecursiveFactorial implements SequenceInterface {
	private String name;
	private int numberOfCalls = 0; 	// counter to keep number of recursive calls
	
	// set the name of the sequence 
	public RecursiveFactorial(String name) {
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
	
	@Override
	public void resetNumberOfCalls() {
		numberOfCalls = 0;
		
	}

	@Override
	public int getNumberOfCalls() {
		return numberOfCalls;
	}
	
	/**
	 * Compute factorial using basic recursion
	 * 
	 * @param n The number to compute factorial of.
	 * @return n factorial.
	 */
	public long compute(long n) {
		// this code, total calls is wrong when (0). because of if statement
		if (n == 0) 
			return 1; 
		else {
			numberOfCalls++;
			return n*compute(n-1); 
		}
		/* answer in class
		numberOfCalls++;
		long result = 1;
		if(n > 1)
			result = n * compute(n-1);
		return result; */
        
	}

}
