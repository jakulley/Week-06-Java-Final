

package week05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Deck {

private List<Card> Cards = new ArrayList<Card>(); 

public Deck() {
	deckBuilder();
}

	private List<Card> deckBuilder() {
	
		for (int i = 2; i < 15; i++) {
			Card newCard1 = new Card(i, "Clubs");
			Card newCard2 = new Card(i, "Diamonds");
			Card newCard3 = new Card(i, "Hearts");
			Card newCard4 = new Card(i, "Spades");
			Cards.add(newCard1);
			Cards.add(newCard2);
			Cards.add(newCard3);
			Cards.add(newCard4);
		}
		return Cards;
	}


	public void describe() {
		System.out.println("Your deck contains the following cards:");
		for (int i = 0; i < Cards.size(); i++) {
			System.out.println(Cards.get(i).getName() + " of " + Cards.get(i).getSuit());
		}
	}
	
	public void shuffle() {
		List<Card> shuffledCards = new ArrayList<Card>();
		for (int i = Cards.size()-1; i >= 0; i--) {
			Random rand = new Random();
			int x = rand.nextInt(i + 1);
			shuffledCards.add(Cards.get(x));
			Cards.remove(x);
		}
		for (int i = 0; i < shuffledCards.size(); i++) {
			Cards.add(shuffledCards.get(i));
		}
	}
	
	public List<Card> getDeck(){
		return Cards;
	}

	public Card drawCard() {
		if (Cards.size() > 0) {
			Card draw = Cards.get(0);
			Cards.remove(0);
			return draw;
		} else {
			Card token = new Card(8, "This token indicates an empty deck; please start a new game.");
			return token;
		}

		
	}

}