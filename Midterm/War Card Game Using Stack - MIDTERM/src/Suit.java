/**
 * Define the four suits for a card deck
 * @author mhrybyk
 *
 */
public enum Suit {
	Hearts(0), Diamonds(1), Clubs(2), Spades(3);

	private int suitValue;

	private Suit(int n) {
		suitValue = n;
	}

	/**
	 * @return the suitValue
	 */
	public int getSuitValue() {
		return suitValue;
	}

};