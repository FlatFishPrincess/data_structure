/**
 * Compute factorial using tail recursion
 * @author mhrybyk
 * 
 */
public class TailRecursiveFactorial implements SequenceInterface {
	private String name;
	private int numberOfCalls = 0; 	// counter to keep number of recursive calls
	
	// set the name of the sequence 
	public TailRecursiveFactorial(String name) {
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
	 * The tail recursive version of factorial.
	 * 
	 * @param n The number to compute factorial of.
	 * @return n factorial.
	 */
	public long compute(long n) {
		return computeHelper(n , 1);
	}
	
	private long computeHelper(long n, long a){
		numberOfCalls++;
		  if (n < 0)
		    return 0;
		  else if (n == 0)
		    return 1;
		  else if (n == 1)
		    return a;
		  else
		    return computeHelper(n - 1, n * a);
		 /* answer in class
		  numberOfCalls++;
		  long result = 0;
		  if(n <= 1)
			  result = a; // a is partial
		  else 
			  result = computeHelper(n-1, n* a);
		  return result;*/ 
	}



}
