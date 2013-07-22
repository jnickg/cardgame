import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card>  cards;
	
	Hand() {
		cards = new ArrayList<Card>();
	}
	
	Hand(List<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	/**
	 * Removes a single card from the top of the hand, and returns it.
	 * 
	 * @return		The instance of Card which was removed.
	 */
	public Card removeCard() {
		return cards.remove(0);
	}
	
	/** 
	 * Empties the hand and returns it as an ArrayList of Cards.
	 * 
	 * @return	An ArrayList of Card instances which populated the Hand.
	 */
	public List<Card> removeAll() {
		List<Card> oldHand = new ArrayList<Card>();	// Creates an empty ArrayList to return.
		while(!(cards.isEmpty())) {
			oldHand.add(cards.remove(0));
		}
		return oldHand;
	}
	
	/**
	 * Calculates the total value of the hand.
	 * 
	 * @return		The sum of each Card's value.
	 */
	public int calculateScore() {
		int score = 0;
		for(Card c : cards) {
			score += c.calcValue();
		}
		return score;
	}
	
	/**
	 * Creates a String containing each card in the Hand, using the
	 * StringBuilder class.
	 * 
	 * @param cpl		The number of cards to be written per line
	 * @return 			The string containing the Hand. 
	 */
	public String toString(int cpl) {
		StringBuilder handString = new StringBuilder();
    	int i = 1;
		for (Card c: cards) {
			handString.append(c.toString());
			if((cards.indexOf(c) < cards.size()-1)) handString.append(", ");
			if(i % cpl == 0) handString.append("\n");
			i++;
		}
		handString.append("\n");
		return handString.toString();
	}
	
	/**
	 * Prints out the Hand and its score.
	 */
	public void print(int cpl) {
		System.out.print(toString(cpl) + "score = " + calculateScore() + "\n\n");
	}
}
