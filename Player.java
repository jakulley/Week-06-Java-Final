package week05;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Card> hand = new ArrayList<Card>();
	private String name;
	private int score;
	

	
	public Player() {
		System.out.print("Input Player name:");
		this.name = IO.getScanner().next();
		this.score = 0;
	}
	
	public void describe() {
		System.out.println("Player name is " + name);
		System.out.println(name + "'s hand contains the following cards:");
		for (Card card : hand) {
			System.out.println(card.getName());
		}
		System.out.println(name + "'s score is: " + score);
	}
	
	public String getName() {
		return name;
	}
	
	public void draw(Deck deck) {
		hand.add(deck.drawCard());
		//System.out.println(name + " drew " + hand.get(hand.size() - 1).getName());
	}
	
	/*
	 * Originally, I had included the hand management system inside Deck, but this meant the Player class had to call Deck to use their hand. While not unworkable, this was not in keeping with SOLID principles of OOP. It also violates our intuition based on real world experiences with playing cards, in which the hand is something separate from the deck, and more closely associated with the player using it.
	 */
	
	public Card flip() {
		Card warrior = hand.get(0);
		hand.remove(0);
		return warrior;
	}
	
	public void incrementScore() {
		score++;
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public int getScore() {
		return score;
	}
}
