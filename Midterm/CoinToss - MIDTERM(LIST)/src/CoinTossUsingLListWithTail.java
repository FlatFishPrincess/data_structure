
/**
 * Create a list of coins, which are tossed and are either randomly heads or tails.
 * Show the coin list, then move all of the coins which are heads to a new list, leaving the rest (tails)
 * in the original list.
 * 
 * Then display each list, and the summary statistics including
 * number of coins in each list, and their total value (in cents).
 * 
 * Implement using Alist.
 * 
 * @author your name goes here
 *
 */
public class CoinTossUsingLListWithTail {

	public static void main(String[] args) {

		// replace the below with an AList or an LList
		System.out.println("ConinTossUsingLList");
		ListInterface<Coin> coins = new LListWithTail2<>();
		ListInterface<Coin> headsCoins = new LListWithTail2<>();
		
		// place to keep the total coin value of the two lists

		int coinsTotalValue = 0;
		int headsCoinsTotalValue = 0;

		// create a number of coins, and then display them
		initializeCoins(coins, 100);
		showCoins(coins, "Initial set of coins");

		// get the total value of the original list of coins, and display the summary
		// stats

		coinsTotalValue = getTotalValue(coins);
		System.out.println("All coins count: " + coins.getLength() + " Total Value: " + coinsTotalValue);

		// move all of the coins that are heads to the heads list

		moveCoins(coins, headsCoins);

		// original list is now only tails, so show and get their total value

		showCoins(coins, "Tails (Original list)");
		coinsTotalValue = getTotalValue(coins);

		// show all of the coins that are heads and their total value

		showCoins(headsCoins, "Heads (New list)");
		headsCoinsTotalValue = getTotalValue(coins);

		// display summary statistics
		System.out.println("==== Summary ====");
		System.out.println("Tails coins count: " + coins.getLength() + " Total Value: " + coinsTotalValue);
		System.out.println("Heads coins count: " + headsCoins.getLength() + " Total Value: " + headsCoinsTotalValue);
	}

	/**
	 * Create a list of coins. Loop through the number of coin types a set amount of
	 * iterations.
	 * 
	 * If there are n coin types and m loops, then there are n x m coins in total.
	 * 
	 * For 6 coin types, and 100 iterations, there will be 600 coins.
	 * 
	 * Each time a coin is created, it is tossed, although we could also do this
	 * here within the loop.
	 * 
	 * @param coins List holding created coins
	 * @param count number of iterations to create the coins
	 */
	public static void initializeCoins(ListInterface<Coin> coins, int count) {
		// create a list of coins
		for(int i = 0; i<count; i++){
			for (Coin.CoinType coinType : Coin.CoinType.values()) {
				coins.add(new Coin(coinType));
			}
		}
	}

	/**
	 * Move the coins that are heads from the coins list to the heads list
	 * 
	 * @param coins list of coins
	 * @param headsCoins list containing only coins tossed as heads
	 */
	public static void moveCoins(ListInterface<Coin> coins, ListInterface<Coin> headsCoins) {
		// compare coin type, then if it is header, then remove it and move to the headCoins

		ListInterface<Coin> copiedCoins = coins;
		for(int i = 1; i<= copiedCoins.getLength(); i++){
			if(copiedCoins.getEntry(i).isHeads()){
				headsCoins.add(coins.remove(i));
			} 
		}
	}

	/**
	 * Display all of the coins in a list
	 * 
	 * @param coins
	 * @param header Message header to be included
	 */
	public static void showCoins(ListInterface<Coin> coins, String header) {
		// show header with number of coins
		System.out.println("===== " + header + " - getLength(): " + coins.getLength() + " ====");
		// main loop to display each coin
		for (int i = 0; i < coins.getLength(); i++) {
			System.out.println(coins.getEntry(i + 1));
		}
		System.out.println();
	}

	/**
	 * Add up the total value of all coins in a list
	 * 
	 * @param coins list of coins
	 * @return total value of all coins
	 */
	public static int getTotalValue(ListInterface<Coin> coins) {
		int totalValue = 0;
		for(int i = 0; i < coins.getLength(); i++)
			totalValue += coins.getEntry(i + 1).getValue();
		return totalValue;
	}

}
