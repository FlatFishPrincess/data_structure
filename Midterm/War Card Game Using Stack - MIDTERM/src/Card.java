/**
 * Card class
 * 
 * A card from a playing deck that has a suit, is a number or face card, and 
 * has a rank.
 * 
 * Suits are defined by the Suit enum, and face card or numbered cards are defined by the
 * CardType enum.
 * 
 * Note the rank of a card is its value. The rank of a numbered card is the number, and 
 * the rank of a face card is 10 + its value.
 * @author mhrybyk
 *
 */
public class Card implements Comparable<Card>{

	private Suit suit;
	private CardType cardType;
	private int cardRank;
	private int cardNumber;

	/**
	 * Initialize a card with a suit, type, and number.
	 * @param suit
	 * @param cardType
	 * @param cardNumber should be between 2 and 10, but not required
	 */
	public Card(Suit suit, CardType cardType, int cardNumber) {
		this.suit = suit;
		this.cardType = cardType;
		this.cardNumber = cardNumber;

		if (this.cardType.getCardTypeValue() > 0)
			cardRank = this.cardType.getCardTypeValue() + 10;
		else cardRank = cardNumber;

	}

	/**
	 * @return the cardRank
	 */
	public int getCardRank() {
		return cardRank;
	}

	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @return the number
	 */
	public int getCardNumber() {
		return cardNumber;
	}

	@Override
	public String toString() {
		return suit + " " + cardType + " " + cardRank;
	}

	@Override
	public int compareTo(Card other) {

		return(cardRank - other.cardRank);
	}

}
