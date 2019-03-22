/**
 * A player in the game of war.
 * The player is initialized with a name, which is used to identify the player in output 
 * @author mhrybyk
 *
 */
public class Player implements PlayerInterface {

	private static final int PLAYER_CARDS = 26;

	private String name;  // name of the player
	
	// each player has three decks
	// cardsToPlay - the cards to be used to play war, chosen one at a time
	// cardsWon - storage for all cards won in each battle
	
	private Deck cardsToPlay = new Deck("[CardsToPlay]");
	private Deck cardsWon = new Deck("[CardsWon]");
	private Deck war = new Deck("[War]");
	
	public Player(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + " " + cardsToPlay.size() + 
				"-" + cardsWon.size() +
				"-" + war.size();
	}


	@Override
	public void addCardToPlay(Card card) {
		cardsToPlay.push(card);
	}


	@Override
	public Card getCardToPlay() {
		// if cardsToPlay is empty, then move all cardsWon to cardsToPlay 
		// but if cardsWon is empty, lose 
		if(cardsToPlay.isEmpty()){
			System.out.println("move cards won to cardstoplay");
			for(int i =0; i<cardsWon.size(); i++)
				cardsToPlay.push(cardsWon.pop());
		}
		return cardsToPlay.pop();
	}


	@Override
	public void addWonCard(Card card) {
		cardsWon.push(card);
	}


	@Override
	public boolean declareWar(Card playedCard) {
		// Put the playedCard and the next three cards into the war deck
				boolean isDone = true;
				if(cardsToPlay.size() < 4){
					restartCard();
					if(cardsToPlay.size() < 4){
						isDone = false;
						return isDone;
					}
				}
				war.push(playedCard);
				for(int i = 0; i<3; i++){
					if(!cardsToPlay.isEmpty())
						war.push(cardsToPlay.pop());
				}
				return isDone;
	}


	@Override
	public void lostWarTo(Player otherPlayer) {
		while(!war.isEmpty()){
			otherPlayer.addWonCard(war.pop());
		}
	}


	@Override
	public void wonWar() {
		while(!war.isEmpty()){
			addWonCard(war.pop());
		}
	}


	@Override
	public void displayCardsToPlay() {
		cardsToPlay.display(name);
	}


	@Override
	public void displayCardsWon() {
		while(!cardsWon.isEmpty()){
			cardsWon.display(name);
		}
	}


	@Override
	public void displayWar() {
		war.display(name);
	}
	public boolean restartCard(){
		// move all cards in cardsWon to cardsToPlay
		boolean canRestart = true;
		if(cardsWon.size() == 0){
			canRestart = false;
			return canRestart;
		}
		System.out.println(name + " restarting with " + cardsWon.size());
		while(!cardsWon.isEmpty()){
			cardsToPlay.push(cardsWon.pop());
		}
		return canRestart;
	}

}
