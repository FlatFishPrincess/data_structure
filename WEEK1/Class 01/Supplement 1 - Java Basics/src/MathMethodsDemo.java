/**
 * MathMethodsDemo
 * 
 * Demonstrates use of random numbers, powers, and PI
 * @author mhrybyk
 *
 */

public class MathMethodsDemo {

	public static void main(String[] args) {

		// pick a random number (between 0 and 1) then multiply by 100
		// then round it to make an integer. could use floor or ceiling as well here
		
		for(int i = 0; i < 10; i++ ) {
			System.out.println("Random number between 0 and 100: " + Math.round(Math.random() * 100));
		}

		// show the value of pi
		
		System.out.println("PI: " + Math.PI);
		
		// show 3^4 which is 81
		System.out.println("3 raised to 4th power: " + Math.pow(3, 4));
		

	}

}
