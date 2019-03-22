/**
 * A driver that demonstrates the class LinkedListWithTraversal.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class LinkedListWithTraversalDemo{
	public static void main(String[] args) {
		testIteratorOperations();
		System.out.println("\n\nDone.");
	} // end main

	public static void testIteratorOperations() {
		LinkedListWithTraversal<String> myList = new LinkedListWithTraversal<>();
		System.out.println("Creating a list by adding to end: Add 15, 25, 35, 45, 55, 65, 75, 85, 95");
		myList.add("15");
		myList.add("25");
		myList.add("35");
		myList.add("45");
		myList.add("55");
		myList.add("65");
		myList.add("75");
		myList.add("85");
		myList.add("95");

		System.out.println("------------------------");
		System.out.println("Testing Iterator's hasNext and next methods:");

		System.out.println("List should contain 15 25 35 45 55 65 75 85 95");
		displayList(myList);

		System.out.println("Using Iterator methods, the list contains");
		myList.resetTraversal();

		while (myList.hasNext())
			System.out.print(myList.next() + " ");
		System.out.println();

		System.out.println("Return iterator to beginning of list");
		myList.resetTraversal(); // Reset iterator to beginning

		// Advance through list
		System.out.println("next() should return 15 : " + myList.next());
		System.out.println("next() should return 25 : " + myList.next());
		System.out.println("next() should return 35 : " + myList.next());
		System.out.println("next() should return 45 : " + myList.next());
		System.out.println("next() should return 55 : " + myList.next());
		System.out.println("next() should return 65 : " + myList.next());
		System.out.println("next() should return 75 : " + myList.next());
		System.out.println("next() should return 85 : " + myList.next());
		System.out.println("next() should return 95 : " + myList.next());

		System.out.println("hasNext() should return false : " + myList.hasNext());
		System.out.println("----------------------");
	} // end testIteratorOperations

	public static void displayList(ListInterface<String> list) {
		int numberOfEntries = list.size();

		System.out.println("Using ADT, the list contains " + numberOfEntries + " entries, as follows:");
		for (int position = 0; position < numberOfEntries; position++)
			System.out.println(list.getEntry(position) + " is entry " + position);
		System.out.println();
	} // end displayList
} // end Driver

/*
Creating a list by adding to end: Add 15, 25, 35, 45, 55, 65, 75, 85, 95
------------------------
Testing Iterator's hasNext and next methods:
List should contain 15 25 35 45 55 65 75 85 95
Using ADT, the list contains 9 entries, as follows:
15 is entry 0
25 is entry 1
35 is entry 2
45 is entry 3
55 is entry 4
65 is entry 5
75 is entry 6
85 is entry 7
95 is entry 8

Using Iterator methods, the list contains
15 25 35 45 55 65 75 85 95 
Return iterator to beginning of list
next() should return 15 : 15
next() should return 25 : 25
next() should return 35 : 35
next() should return 45 : 45
next() should return 55 : 55
next() should return 65 : 65
next() should return 75 : 75
next() should return 85 : 85
next() should return 95 : 95
hasNext() should return false : false
----------------------
 Done.
*/
