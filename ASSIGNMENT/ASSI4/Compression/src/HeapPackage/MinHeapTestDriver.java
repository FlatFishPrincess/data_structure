package HeapPackage;

/**
 * A driver that demonstrates the class MinHeap.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk adapted from MaxHeapTestDriver
 */
public class MinHeapTestDriver {
	public static void main(String[] args) {
		String jared = "Jared";
		String brittany = "Brittany";
		String jazmin = "Jazmin";
		String doug = "Doug";
		String megan = "Megan";
		String tia = "Tia";
		String jada = "Jada";
		String jamal = "Jamal";
		String regis = "Regis";
		String zeke = "Zeke";

		// create a heap of the names above
		
		MinHeap<String> aHeap = new MinHeap<>();
//		CompletedMinHeap<String> aHeap = new CompletedMinHeap<>();
		
		aHeap.add(jared);
		aHeap.add(brittany);
		aHeap.add(jazmin);
		aHeap.add(doug);
		aHeap.add(megan);
		aHeap.add(tia);
		aHeap.add(jada);
		aHeap.add(jamal);
		aHeap.add(regis);

		if (aHeap.isEmpty())
			System.out.println("The heap is empty - INCORRECT");
		else
			System.out.println("The heap is not empty; it contains " + aHeap.getSize() + " entries.");

		System.out.println("The smallest entry is " + aHeap.getMin());
		
		aHeap.display();

		System.out.println("\n\nRemoving entries in descending order:");
		while (!aHeap.isEmpty())
			System.out.println("Removing " + aHeap.removeMin());

		System.out.println("\n\nTesting constructor with array parameter:\n");

		// now test the array constructor
		
		String[] nameArray = { jared, jazmin, doug, tia, megan, jada, jamal, brittany, regis, zeke };
		
		MinHeap<String> anotherHeap = new MinHeap<>(nameArray);
//		CompletedMinHeap<String> anotherHeap = new CompletedMinHeap<>(nameArray);

		if (anotherHeap.isEmpty())
			System.out.println("The heap is empty - INCORRECT");
		else
			System.out.println("The heap is not empty; it contains " + anotherHeap.getSize() + " entries.");

		System.out.println("The smallest entry is " + anotherHeap.getMin());

		anotherHeap.display();
		System.out.println("\n\nRemoving entries in descending order:");
		while (!anotherHeap.isEmpty())
			System.out.println("Removing " + anotherHeap.removeMin());
	} 
} 

/*
The heap is not empty; it contains 9 entries.
The smallest entry is Brittany
PARENT: Brittany LEFT CHILD: Doug RIGHT CHILD:Jada
PARENT: Doug LEFT CHILD: Jamal RIGHT CHILD:Megan
PARENT: Jada LEFT CHILD: Tia RIGHT CHILD:Jazmin
PARENT: Jamal LEFT CHILD: Jared RIGHT CHILD:Regis


Removing entries in descending order:
Removing Brittany
Removing Doug
Removing Jada
Removing Jamal
Removing Jared
Removing Jazmin
Removing Megan
Removing Regis
Removing Tia


Testing constructor with array parameter:

The heap is not empty; it contains 10 entries.
The smallest entry is Brittany
PARENT: Brittany LEFT CHILD: Jared RIGHT CHILD:Doug
PARENT: Jared LEFT CHILD: Jazmin RIGHT CHILD:Megan
PARENT: Doug LEFT CHILD: Jada RIGHT CHILD:Jamal
PARENT: Jazmin LEFT CHILD: Tia RIGHT CHILD:Regis
PARENT: Megan LEFT CHILD: Zeke


Removing entries in descending order:
Removing Brittany
Removing Doug
Removing Jada
Removing Jamal
Removing Jared
Removing Jazmin
Removing Megan
Removing Regis
Removing Tia
Removing Zeke

 */
