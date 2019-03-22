/**
 * The card game of war
 *
 */


public class WarCardGame {

	public static void main(String[] args) {

		// create and display the deck of cards
		
		Deck deck = new Deck("Card Deck");
		deck.createStandardCardDeck();
		deck.display("Unshuffled");
		deck.shuffle();
		deck.display("Shuffled");
		
		// create the two players
		
		Player player1 = new Player("Brother");
		Player player2 = new Player("Sister");

		// deal cards to each player and display their hands
		int deckSize = deck.size() / 2;
		for (int i = 0; i < deckSize; i++)
			player1.addCardToPlay(deck.removeFront());

		for (int i = 0; i < deckSize; i++)
			player2.addCardToPlay(deck.removeFront());

		// INSERT CODE HERE TO DEAL THE CARDS TO EACH PLAYER
		player1.displayCardsToPlay();
		player2.displayCardsToPlay();
		
		// starts war game
		Card p1Card, p2Card;
		boolean isEndgame = false;
		boolean isWarDeclared = false;
		int round = 1;
		
		// game start until one of players loses
		while (!isEndgame) {
			System.out.println("Round " + round);
			
			// display current players' status
			System.out.println(player1.toString() + "\n" + player2.toString());

			// get cards from the cardsToPlay deck
			p1Card = player1.getCardToPlay();
			p2Card = player2.getCardToPlay();
			
			// check if cardsToPlay deck is empty.
			if (p1Card == null) {
				// check if player can restart from their won deck
//				System.out.println(player1.toString());
				if (!player1.restartCard()) {
					isEndgame = true;
					System.out.println(player1.toString() + " loses");
					break;
				} else {
					p1Card = player1.getCardToPlay();
				}
			}
			if (p2Card == null) {
				if (!player2.restartCard()) {
					isEndgame = true;
					System.out.println(player2.toString() + " loses");
					break;
				} else {
					p2Card = player2.getCardToPlay();
				}
			}

			// display the match (player1 vs player2)
			System.out.println("Player1 card [" + p1Card.toString() + "] vs Player2 card [" + p2Card.toString() + "]");

			// compare each player card
			if (p1Card.compareTo(p2Card) > 0) {
				// p1 card won
				player1.addWonCard(p1Card);
				player1.addWonCard(p2Card);
				// check if war is declared
				if (isWarDeclared) {
					player1.wonWar();
					player2.lostWarTo(player1);
					isWarDeclared = false;
				}
				System.out.println(player1.toString() + " wins round");
			} else if (p1Card.compareTo(p2Card) < 0) {
				// p2 card won
				player2.addWonCard(p1Card);
				player2.addWonCard(p2Card);
				// check if war is declared
				if (isWarDeclared) {
					player2.wonWar();
					player1.lostWarTo(player2);
					isWarDeclared = false;
				}
				System.out.println(player2.toString() + " wins round");
			} else if (p1Card.compareTo(p2Card) == 0) {
				// war declared
				isWarDeclared = true;
				if (!player1.declareWar(p1Card)) {
					System.out.println(player1.toString() + " loses");
					isEndgame = true;
					break;
				}
				if (!player2.declareWar(p2Card)) {
					System.out.println(player2.toString() + " loses");
					isEndgame = true;
					break;
				}
				System.out.println("xxxxx War declared xxxxx");
				player1.displayWar();
				player2.displayWar();
			}
			System.out.println("*******************");
			round++;
		}

		// the rest of the code to implement the game goes here

	}
}
