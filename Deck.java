import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck
{
	private List<Card>  cards;
    private static final List<Card> protoDeck = new ArrayList<Card>();

    // Initialize an ordered, prototype deck. This is an unopened
    // deck of cards.
    static {
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                protoDeck.add(new Card(rank, suit));
    }
    
    /**
     * Creates a new ArrayList of Card instances, using a copy of
     * the protoDeck. 
     */
    public Deck() {
    	cards = new ArrayList<>(protoDeck);
	}
    
    /**
     * Uses the built-in Collections.shuffle() method to shuffle
     * the ArrayList of Cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);	
	}
    
    /**
     * Resorts the deck.
     */
    public void resort() {
    	int i = 0;
    	for(Card c: protoDeck) {
    		cards.set(i, c);
    		i++;
    	}
    }
    
    /**
     * Removes a Card from the deck and returns its instance.
     * 
     * @return		the instance of card which was removed.
     */
    public Card removeCard() {
    	return cards.remove(0);
    }
    
    /* Add removeCards() method */
    
    /**
     * Adds a card to the bottom of the deck
     * 
     * @param card		The card to be added.
     */
    public void addCard(Card card) {
    	cards.add(card);
    }
    
    /** Adds multiple cards to the bottom of the deck
     * 
     * @param cards		A List of Cards to be added.
     */
    public void addCards(List<Card> cards) {
    	cards.addAll(cards);
    }
    
    public String toString(int cpl) {
    	StringBuilder deckString = new StringBuilder();
    	int i = 1;
    	for(Card c: cards) {
    		deckString.append(c.toString());
    		if((cards.indexOf(c) < cards.size()-1)) deckString.append(", ");
    		if(i % cpl == 0) deckString.append("\n");
    		i++;
    	}
    	deckString.append("\n");
    	return deckString.toString();
    }
    
    /**
     * Prints each card in the deck.
     */
    public void print(int cpl) {
    	System.out.print(toString(cpl));
    }
}
