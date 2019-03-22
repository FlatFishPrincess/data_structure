/**
 * Simple iterative factorial
 * @author mhrybyk
 *
 */
public class IterativeFactorial implements SequenceInterface {
	
	private String name;
	private int numberOfCalls = 0;
	
	// set the name of the sequence 
	public IterativeFactorial(String name) {
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
	 * Compute the factorial using iteration
	 * @param n
	 * @return factorial
	 */
	@Override
	public long compute(long n) {
		numberOfCalls++;
		long result = 1;
		while( n > 1){
			result *= n;
			n--;
		}
		return result;
	}

	@Override
	public void resetNumberOfCalls() {
		
		numberOfCalls = 0;
	}

	@Override
	public int getNumberOfCalls() {
		return numberOfCalls;
	}

}
