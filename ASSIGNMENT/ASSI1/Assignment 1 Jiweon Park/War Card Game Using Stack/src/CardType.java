/**
 * Define the types of cards
 * Either a number or a face card. Note Ace is the highest.
 * @author mhrybyk
 *
 */
public enum CardType {
	Number(0), Jack(1), Queen(2), King(3), Ace(4);

	private int cardTypeValue;

	/**
	 * 
	 * @param n
	 */
	private CardType(int n) {
		cardTypeValue = n;
	}

	/**
	 * @return the cardTypeValue
	 */
	public int getCardTypeValue() {
		return cardTypeValue;
	}
};