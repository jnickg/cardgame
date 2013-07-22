public class Card {
	public enum Rank {	// Each element has a stored value
		ACE(11), KING(10), QUEEN(10), JACK(10), TEN(10), NINE(9), EIGHT(8),
		SEVEN(7), SIX(6), FIVE(5), FOUR(4), THREE(3), DEUCE(2);
		
		int value;	// The stored value.
		
		Rank(int value) {
			this.value = value;
		}
		
		int getValue() {	// Get stored value for the purpose of calcValue() [below]
			return value;
		}
	}
	
	public enum Suit {	// Each element has a stored value
		 HEARTS(4), DIAMONDS(3), CLUBS(2), SPADES(1);
		 
		 int value;	// The stored value.
		 
		 Suit(int value) {
			this.value = value; 
		 }
		 
		 int getValue() {	// Get stored value for the purpose of calcValue() [below]
			return value; 
		 }
	}
	
	private final Rank	rank;	// Each card needs an instance of its Rank...
	private final Suit	suit;	// ...and its Suit.
	
	Card(Rank rank, Suit suit) {
	    this.rank = rank;
	    this.suit = suit;
	}
	
	public Rank rank()          { return rank; }	// Deprecated?
	public Suit suit()          { return suit; }	// Deprecated?

	// Spits out the card's rank, suit, and value
	public String toString()    { return rank + " of " + suit + " (" + calcValue() + ")"; }
	public void print() 		{ System.out.println(toString()); }
	
	// Calculates the card's total value based on the above enum values
	public int calcValue() {	
		return rank.getValue() * suit.getValue();
	}
}
