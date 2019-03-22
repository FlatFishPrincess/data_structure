
public class NameDemo {

	public static void main(String[] args) {
		Name jamie = new Name();
		jamie.setFirst("Jamie");
		jamie.setLast("Jones");
		Name jane = new Name();
		jane.setFirst("Jane");
		jane.setLast("Doe");
		
		System.out.println(jamie);
		System.out.println(jane);
		
		jamie.giveLastNameTo(jane);
		System.out.println(jane);
	}

}
