package practice;

public class OrderedPair<T> implements Pairable<T>{

	//fields 
	private T first, second; 
	
	// constructor 
	public OrderedPair(T first, T second){
		this.first = first;
		this.second = second; 
	}
	
	/**
	 * @return the first object of the pair 
	 * */
	@Override
	public T getFirst() {
		return first; 
	}

	/**
	 * @return the first object of the pair 
	 * */
	@Override
	public T getSecond() {
		return second; 
	}

	// this method is never called but how this works? 
	public String toString()
	   {
	      return "(" + first + ", " + second + ")";
	   } // end toString
	
	/**
	 * change the object pair 
	 * */
	@Override
	public void changeOrder() {
		T temp = first; 
		first = second; 
		second = temp; 
	}
	
	public void displayPair(){
		System.out.println("first: " + first + " second: " + second);
	}
	
	
}
