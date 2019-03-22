/**
 * Customer class
 * For use in simulation of customers waiting in line.
 * 
 * Each customer has an arrival time, and the amount of time the transaction is to take
 * 
 * Each customer is identified by what should be a unique number, but this is not
 * enforced.
 * 
 * @author mhrybyk
 *
 */
public class Customer {
	private int arrivalTime;
	private int transactionTime;
	private int customerNumber;
	
	public Customer(int arrivalTime, int transactionTime, int customerNumber) {
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		this.customerNumber = customerNumber;
	}


	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getTransactionTime() {
		return transactionTime;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

}
