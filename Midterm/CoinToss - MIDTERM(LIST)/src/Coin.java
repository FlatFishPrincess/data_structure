import java.util.Random;

/**
 * Defines a coin as a type (penny, dime, etc)
 * and whether after a toss it is heads or tails
 * @author mhrybyk
 *
 */
public class Coin {

	/**
	 * Define all types of Canadian coins and their informal names
	 * (loonie and twonie, for example).
	 * Each type has the number of cents for its value
	 * @author mhrybyk
	 *
	 */
	public enum CoinType {
		PENNY(1), NICKEL(5), DIME(10), QUARTER(25), LOONIE(100), TWONIE(200);
		
		// a place to keep the value
		
		private int coinTypeValue;
		
		// set the value of the enum list above when used
		
		private CoinType(int value) {
			coinTypeValue = value;
		}
		
		/**
		 * Allow access to the actual value of the coin type.
		 * For example, PENNY would return the value of the PENNY
		 * @return the associated value with the coin type
		 */
		public int getCoinTypeValue() {
			return coinTypeValue;
		}		
	}
	
	// every coin has a type and is either heads or tails
	private CoinType coinType;  
	private boolean heads = true;
	
	// set up the random number generator when the first coin is created.
	// defined as static so the same generator is used for all coins
	
	private static Random random = new Random();
	
	/**
	 * A coin must have a type in order to be created.
	 * Toss it right away (although this can be done separately as well)
	 * @param coinType
	 */
	public Coin(Coin.CoinType coinType) {
		this.coinType = coinType;
		toss();
	}
	
	/**
	 * Choose heads to be true or false depending on the random number
	 * generator. 
	 * Assume the generator was initialized properly.
	 */
	public void toss() {

		random.nextBoolean();	
		heads = random.nextBoolean();
	}
	
	/**
	 * Get status of coin flip
	 * @return true if the coin is heads
	 */
	public boolean isHeads() {
		return heads;
	}
	
	/**
	 * Get the monetary value in cents of the coin's type
	 * @return
	 */
	public int getValue() {
		return coinType.getCoinTypeValue();
	}
	
	/**
	 * Gets the coin's type
	 * @return coin type
	 */
	public CoinType getType() {
		return coinType;
	}
	
	/**
	 * Show the type and whether it is heads
	 */
	@Override
	public String toString() {
		return coinType.toString() + " heads: " + isHeads();
	}
	
}
