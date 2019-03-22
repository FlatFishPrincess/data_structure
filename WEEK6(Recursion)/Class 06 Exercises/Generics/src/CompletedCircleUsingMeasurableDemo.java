/**
 * A driver that demonstrates the class CompletedCircleUsingMeasurable.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class CompletedCircleUsingMeasurableDemo {
	public static void main(String[] args) {
		CompletedCircleUsingMeasurable c1 = new CompletedCircleUsingMeasurable(5.0);
		CompletedCircleUsingMeasurable c2 = new CompletedCircleUsingMeasurable(5.0);
		CompletedCircleUsingMeasurable c3 = new CompletedCircleUsingMeasurable(9.0);

		System.out.println("c1 and c2 are equal:");
		System.out.println("c1.equals(c2): " + c1.equals(c2));
		System.out.println("c1.compareTo(c2): " + c1.compareTo(c2));
		System.out.println();

		System.out.println("c1 and c3 are not equal:");
		System.out.println("c1.equals(c3): " + c1.equals(c3));
		System.out.println("c1 < c3: ");
		System.out.println("c1.compareTo(c3): " + c1.compareTo(c3));
		System.out.println();

		System.out.print("Calling aMethod(c3); result should be > 0 : ");
		aMethod(c3);

		Measurable c4 = new CompletedCircleUsingMeasurable(9.0);
		System.out.println("c4, whose radius is 9, has a circumference of " + c4.getPerimeter());
		System.out.println(" and an area of " + c4.getArea());

		System.out.println("\nDone.");
	} // end main

	public static void aMethod(Comparable<CompletedCircleUsingMeasurable> item) {
		System.out.println(item.compareTo(new CompletedCircleUsingMeasurable(6.0)));
	} // end aMethod
} // end Driver

/*
 * c1 and c2 are equal: c1.equals(c2): true c1.compareTo(c2): 0
 * 
 * c1 and c3 are not equal: c1.equals(c3): false c1 < c3: c1.compareTo(c3): -1
 * 
 * Calling aMethod(c3); result should be > 0 : 1 c4, whose radius is 9, has a
 * circumference of 56.548667764616276 and an area of 254.46900494077323
 * 
 * Done.
 * 
 */