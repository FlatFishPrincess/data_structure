import java.util.Random;

/**
 * A deck of cards using a deque
 *
 */

public class Deck extends LinkedDeque3<Card> {

	private String name;
	private final int NUMBER = 14;

	public Deck(String name) {
		this.name = name;
	}	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Using the Suit and CardType enums, create a full deck of cards.
	 * For each suit and card type, add the card to the queue
	 */
	public void createStandardCardDeck() {
		CardType cardType;
		
		
		// create Card deck 
		for(Suit suit : Suit.values()){
			for(int i = 2; i<= NUMBER; i++){
				switch(i){
					case(11):
						cardType = CardType.Jack;
						addToFront(new Card(suit, cardType, i));
						break;
					case(12):
						cardType = CardType.Queen;
						addToFront(new Card(suit, cardType, i));
						break;
					case(13):
						cardType = CardType.King;
						addToFront(new Card(suit, cardType, i));
						break;
					case(14):
						cardType = CardType.Ace;
						addToFront(new Card(suit, cardType, i));
						break;
					default:
						cardType = CardType.Number;
						addToFront(new Card(suit, cardType, i));
						break;
				}
			}
		}
	}
	
	/**
	 * Shuffle the deck by removing each element from the queue and adding them
	 * to an array.
	 * Then shuffle the array.
	 * Finally add each array element back onto the queue.
	 */
	public void shuffle() {
		
		// create an array of cards the same size as the queue
		int deckSize = size();
		Card[] cards = new Card[deckSize];
		
		// copy over the elements to the array, removing them from the queue
		
		for (int i = 0; i < cards.length && !isEmpty(); i++) {
			cards[i] = removeFront();			
		}
		
		// initialize the random number generator
		Random random = new Random();
		random.nextInt();

		// shuffle by picking a random card from the remaining
		// cards and trading places with the selected card
		int newLocation; // place in the array to swap
		Card temp;  // temp storage for the swap
		
		for (int i = 0; i < deckSize; i++) {
			
			// the new location is the current card plus a random selection 
			// from all remaining cards
			newLocation = i + random.nextInt(deckSize - i);
			// now swap the current card to the new location
			temp = cards[i];
			cards[i] = cards[newLocation];
			cards[newLocation] = temp;
		}	

		// now put the shuffled array back onto the queue
		// NOTE: This is inefficient, and shows the deficiency of using a 
		// stack or queue for sorting/shuffling without additional methods.
		//
		// Java's Collections has a shuffle method that applies to any collection,
		// but that is rather complex to implement, so we'll keep it basic
		// here and promote data hiding.
		for (int i = 0; i < cards.length; i++) {
			addToBack(cards[i]);			
		}
		
	}
	
	/**
	 * Display all elements in the deck using the title
	 * @param title title to be displayed before the list of elements are shown
	 */
	public void display(String title) {

		super.display(name + " " + title);

	}
}
