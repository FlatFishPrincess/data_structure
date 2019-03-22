/**
 * An enumeration of card suits.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
enum Suit {
	// set the ordinal values for the enum
	
	CLUBS("black", 10), DIAMONDS("red", 20), HEARTS("red", 30), SPADES("black", 40);

	private final String color;
	private final int position;

	private Suit(String suitColor, int suitPosition) {
		color = suitColor;
		position = suitPosition;
	} // end constructor

	public String getColor() {
		return color;
	} // end getColor
	
	public int getPosition() {
		return position;
	}
} // end Suit
