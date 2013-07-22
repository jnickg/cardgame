import java.util.List;

public class Dealer {
	private 	Deck	loadedDeck;	// Definitely not a loaded deck
	private		String	name;	// Entirely useless, but fun.
	
	/* Add a null constructor */
	
	/**
	 * Constructs a new dealer and initializes his (definitely not) loadedDeck
	 * 
	 * @param dealerName		The name of the dealer. We recommend Penn Jillette.
	 */
	Dealer(String dealerName) {
		name = dealerName;
		loadedDeck = new Deck();
	}
	
	/** 
	 * Returns the Dealer's name
	 * 
	 * @return 		His or ner name.
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * Deals a single game of cards, using the Dealer's Deck.
	 * 
	 * @param hands		The number of hands to be dealt
	 * @param cph		The number of cards to be dealt to each hand
	 * @param shuffle	Whether the dealer will shuffle the deck before playing
	 * @param cpl		The number of cards to be printed per line, when printing the deck
	 */
	public void playGame(int hands, int cph, boolean shuffle, int cpl) {
		// Shuffle the deck if told to do so.
		if (shuffle) shuffleDeck();

		// Each Hand to be dealt will be part of an array.
		Hand hand[] = new Hand[hands];
		for(int j=0; j<hands; j++) hand[j] = new Hand();	//initialize Hand for each space in array
		
		// Deal the cards
		for (int k=0; k<cph; k++) {	//	Draw cph cards total, one at a time...
			for(int j=0; j<hands; j++) {	// ...for each hand.
				hand[j].addCard(drawCard());
			}
		}

		// Show the hands and return them to the dealer's deck
		for(int i=0; i<hand.length; i++) {
			System.out.print("--- Hand " + (i+1) + "---\n\n");
			hand[i].print(cpl);
			
			// The dealer can take the whole hand at once and put it on the bottom
			// of the deck.
			replaceCards(hand[i].removeAll());
		}
	}
	
	/**
	 * Plays multiple games and formats them by game.
	 * 
	 * @param games		The number of games to play
	 * @param hands		The number of hands to be dealt
	 * @param cph		The number of cards to be dealt to each hand
	 * @param shuffle	Whether the dealer will shuffle the deck before playing
	 * @param cpl		The number of cards to be printed per line, when printing the deck
	 */
	public void playGames(int games, int hands, int cph, boolean shuffle, int cpl) {
		for (int i=0; i<games; i++) {
        	System.out.print("=== Game " + (i+1) + "===\n\n");
        	playGame(hands, cph, shuffle, cpl);
        }
		System.out.println("=== Games Complete ===");
	}
	
	/** 
	 * Dealer shuffles the deck by having the deck call the
	 * collections framework's build-in shuffle() method.
	 */
	public void shuffleDeck() {
		loadedDeck.shuffle();
	}
	
	/** 
	 * Dealer removes a card from their deck and returns it.
	 * 
	 * @return an instance of card, after calling the Deck's removeCard() method.
	 */
	public Card drawCard() {
		return loadedDeck.removeCard();
	}
	
	/**
	 * Dealer puts a card on the bottom of his or her deck.
	 * 
	 * @param card		The instance of Card to be added.
	 */
	public void replaceCard(Card card) {
		loadedDeck.addCard(card);
	}
	
	/**
	 * Dealer puts multiple cards on the bottom of his or her deck.
	 * 
	 * @param cards		A List interface of Card instances.
	 */
	public void replaceCards(List<Card> cards) {
		for(Card c: cards) {
			replaceCard(c);
		}
	}
	
	/** 
	 * Allows the dealer to sort his or her deck.
	 */
	public void sortDeck() {
		loadedDeck.resort();
	}
	
	/**
	 * Dealer shows their deck, in its current state, to the user
	 * by calling the Deck's built-in print() method.
	 */
	public void showDeck(int cpl) {
		System.out.println("deck:");
		loadedDeck.print(cpl);
	}
}
