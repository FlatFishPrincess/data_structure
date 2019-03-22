/**
 * A class that represents a circle.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class Circle implements Comparable<Circle>, Measurable {
	private double radius;

	// needs constructor here
	public Circle(){
		radius = 1;
	}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public int compareTo(Circle other) {
		int result;
		if (this.equals(other))
			result = 0;
		else if (radius < other.radius)
			result = -1;
		else
			result = 1;

		return result;
	} // compareTo

	// other methods here
	@Override
	public double getPerimeter() {
		double perimeter = radius * Math.PI * 2;
		return perimeter;
	}

	@Override
	public double getArea() {
		double area = radius * radius * Math.PI;
		return area;
	}
} // end Circle
