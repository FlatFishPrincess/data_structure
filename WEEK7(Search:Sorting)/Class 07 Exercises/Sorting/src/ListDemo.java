/**
 * demonstrates revised AList and LList classes
 * 
 * @author mhrybyk
 *
 */

public class ListDemo {

	public static void main(String[] args) {

		ListInterface<String> listOfIntegers = new LList<>();
//		ListInterface<String> listOfIntegers = new AList<>();
		ListInterface<String> anotherListOfIntegers = new AList<>();

		// first generate a list of integers, and display them
		
		DemoUtilities.generateListOfNumbers(listOfIntegers, 10, 20);
		DemoUtilities.display(listOfIntegers, "Original List of random Integers");
		
		// make a copy
		
		DemoUtilities.copyListOfNumbers(listOfIntegers, anotherListOfIntegers);
		DemoUtilities.display(anotherListOfIntegers, "Copy of List of random Integers");
		

		listOfIntegers.add(listOfIntegers.size(), "21");  // adds to last position, but it needs to be the next available
		listOfIntegers.add(0, "21");  // adds to the front
		listOfIntegers.add(3, "23");  // then to position 3 but including the new item at position 0
		listOfIntegers.add(25, "30"); // this will not be allowed to add

		DemoUtilities.display(listOfIntegers, "Integers with 21 added to front and end, 23 added to position 3");

		listOfIntegers.replace(3, "24");
		listOfIntegers.remove(5);
		listOfIntegers.remove(0); // first removed
		listOfIntegers.remove(listOfIntegers.size() - 1); // removes the end

		DemoUtilities.display(listOfIntegers,
				"Integers position 3 changed to 24, then position 5 and front/back removed");

		listOfIntegers.removeEntry("24");
		SortUtilities.swap(listOfIntegers, 0, 1);

		DemoUtilities.display(listOfIntegers, "First integer entry with value of 24 removed and positions 0 1 swapped");
		

	}

}
