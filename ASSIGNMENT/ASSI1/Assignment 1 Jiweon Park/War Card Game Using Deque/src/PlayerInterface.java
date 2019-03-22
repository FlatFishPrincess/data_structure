
public interface PlayerInterface {

	/**
	 * Add a card to the cards to play deck. This is used when the main deck is being
	 * dealt.
	 * @param card
	 */
	void addCardToPlay(Card card);

	/**
	 * Return the next card to play from the deck and remove it from the deck
	 * @return
	 */
	Card getCardToPlay();

	/**
	 * Add a card to the won deck
	 * @param card
	 */
	void addWonCard(Card card);

	/**
	 * Put the playedCard and the next three cards into the war deck
	 * @param playedCard
	 * @return
	 */
	boolean declareWar(Card playedCard);

	/**
	 * Lost the ward, so move all of the war deck to the other player's won deck.
	 * @param otherPlayer
	 */
	void lostWarTo(Player otherPlayer);

	/**
	 * Won the war, so move all of our war deck to won deck.
	 */
	void wonWar();

	/**
	 * Display all cards in the to be played deck
	 */
	void displayCardsToPlay();

	/**
	 * Display all cards in the won deck
	 */
	void displayCardsWon();

	/**
	 * Display all cards in the war deck
	 */
	void displayWar();

}