
public class ComparisonsDemo {

	public static void main(String[] args) {
		
		// Strings are immutable and refer to the same memory
		String first = "First";
		String second = "First";
		
		if(first == second)
			System.out.println("first and second are equal");
		else System.out.println("first and second are not equal");
		
		// this looks at the content of the object (string) and does a bytewise compare
		if(first.equals(second))
			System.out.println("first and second strings are the same");
		else System.out.println("first and second are not the same");
		
		// but now we are making a copy of the strings and storing them in different places!
		first = new String("First");
		second = new String("First");
		
		if(first == second)
			System.out.println("first and second are equal");
		else System.out.println("first and second are not equal");
	}

}
