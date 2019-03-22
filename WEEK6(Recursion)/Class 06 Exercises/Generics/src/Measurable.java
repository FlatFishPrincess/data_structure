/**
 * An interface for methods that return the perimeter and area of an object.
 * (Listing P-1 in Segment P.14 of the Prelude.)
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public interface Measurable {
	/**
	 * Gets the perimeter.
	 * 
	 * @return The perimeter.
	 */
	public double getPerimeter();

	/**
	 * Gets the area.
	 * 
	 * @return The area.
	 */
	public double getArea();
} // end Measurable
