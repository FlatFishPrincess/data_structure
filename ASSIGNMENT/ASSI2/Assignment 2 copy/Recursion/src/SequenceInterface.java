/**
 * This interface is used for fibonacci and factorial sequences, but can be used 
 * for others as well.
 * 
 * 
 * @author mhrybyk
 *
 */
public interface SequenceInterface {
	
	/**
	 * Compute result of sequence.
	 * The number of recursive calls for this operation must be kept.
	 * @param number 
	 * @return result of the sequence computation
	 */
	long compute(long number);
	
	/**
	 * get the name of this sequence. EG, Fibonacci
	 * @return
	 */
	String getName();
	
	/**
	 * set the name of this sequence. EG, Fibonacci
	 * @param name
	 */
	void setName(String name);
	
	/**
	 * A count of the number of recursive calls is kept. This resets the count
	 * to zero.
	 */
	void resetNumberOfCalls();
	
	/**
	 * A count of the number of recursive calls is kept.
	 * @return the number of recursive calls
	 */
	int getNumberOfCalls();

}
