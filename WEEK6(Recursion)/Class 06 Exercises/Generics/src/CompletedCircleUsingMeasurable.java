/**
   A class that represents a circle.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class CompletedCircleUsingMeasurable implements Comparable<CompletedCircleUsingMeasurable>, Measurable
{
   private double radius;

   public CompletedCircleUsingMeasurable()
   {
   } // end default constructor

   public CompletedCircleUsingMeasurable(double newRadius)
   {
      radius = newRadius;
   } // end constructor

   public void setRadius(double newRadius)
   {
      radius = newRadius;
   } // end setRadius	

   public double getRadius()
   {
      return radius;
   } // end getRadius

   public double getCircumference()
   {
      return 2.0 * Math.PI * radius;
   } // end getCircumference

   public double getPerimeter() // Measurable interface
   {
      return getCircumference();
   } // end getPerimeter

   public double getArea()      // Measurable interface
   {
      return Math.PI * radius * radius;
   } // end getArea

   public String toString()
   {
      return radius + " ";
   } // end toString

   public int compareTo(CompletedCircleUsingMeasurable other)
   {
      int result;
//      if (this.equals(other))
//         result = 0;
      if(this.radius == other.radius)
    	  result = 0;
      else if (radius < other.radius)
         result = -1;
      else 
         result = 1;

      return result;
   } // compareTo

   public boolean equals(Object other)
   {
      boolean result;
      if ((other == null) || (getClass() != other.getClass()))
         result = false;
      else
      {
         CompletedCircleUsingMeasurable otherCircle = (CompletedCircleUsingMeasurable)other;
         result = (radius == otherCircle.radius);
      } // end if

      return result;
   } // end equals
} // end Circle
