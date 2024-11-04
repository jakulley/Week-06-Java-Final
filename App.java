package week05;

import java.util.Scanner;

public class App {

	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		

		System.out.print("Would you like to break numerical ties with suit value? Type '1' for yes, any other number for no: ");
		int tiebreak = IO.getScanner().nextInt();
		boolean tiebreaker = tiebreak == 1;
		
		Deck deck = new Deck();
		deck.shuffle();
		
		Player player1 = new Player();
		System.out.println("Welcome " + player1.getName() + ".");
		Player player2 = new Player();
		System.out.println("Welcome " + player2.getName() + ".");
		
		while (deck.getDeck().size() > 0) {
			player1.draw(deck);
			player2.draw(deck);
		}
		
		for (int i = 0; i < 26; i++) {
			Card warrior1 = player1.flip();
			Card warrior2 = player2.flip();
			System.out.println("\n******** " + warrior1.cardInfo() + " does battle with " + warrior2.cardInfo() + " ********\n");
			if (tiebreaker) {
				if (warrior1.returnValue() > warrior2.returnValue()) {
					player1.incrementScore();
					System.out.println(player1.getName() + "'s " + warrior1.cardInfo() + " conquered " + player2.getName() + "'s " + warrior2.cardInfo() + ". The score is now " + player1.getScore() + " to " + player2.getScore() + ".");
				} else if (warrior2.returnValue() > warrior1.returnValue()) {
					player2.incrementScore();
					System.out.println(player2.getName() + "'s " + warrior2.cardInfo() + " ate the heart of " + player1.getName() + "'s " + warrior1.cardInfo() + ". The score is now " + player1.getScore() + " to " + player2.getScore() + ".");
				} else if (warrior1.returnValue() == warrior2.returnValue() && warrior1.getSuitValue() > warrior2.getSuitValue()) {
					player1.incrementScore();
					System.out.println(player1.getName() + "'s " + warrior1.cardInfo() + " dominated " + player2.getName() + "'s " + warrior2.cardInfo() + ". The score is now " + player1.getScore() + " to " + player2.getScore() + ".");
					//I incorporated a suitValue field to settle ties. 
				} else if (warrior1.returnValue() == warrior2.returnValue() && warrior2.getSuitValue() > warrior1.getSuitValue()) {
					player2.incrementScore();
					System.out.println(player2.getName() + "'s " + warrior2.cardInfo() + " burned " + player1.getName() + "'s " + warrior1.cardInfo() + " to a crisp. The score is now " + player1.getScore() + " to " + player2.getScore() + ".");
				}
			} else if (warrior1.returnValue() > warrior2.returnValue()) {
				player1.incrementScore();
				System.out.println(player1.getName() + "'s " + warrior1.cardInfo() + " stabbed " + player2.getName() + "'s " + warrior2.cardInfo() + " in the stomach. The score is now " + player1.getScore() + " to " + player2.getScore() + ".");
			} else if (warrior2.returnValue() > warrior1.returnValue()) {
				player2.incrementScore();
				System.out.println(player2.getName() + "'s " + warrior2.cardInfo() + " mogged " + player1.getName() + "'s " + warrior1.cardInfo() + ". The score is now " + player1.getScore() + " to " + player2.getScore() + ".");
			} else {
				System.out.println(player1.getName() + "'s " + warrior1.cardInfo() + " failed to defeat " + player2.getName() + "'s " + warrior2.cardInfo() + ", but also did not die. No point has been award.");
			}
			
		}
		
		if (player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName() + " stands alone, glorious, dreched in blood.");
		} else if (player1.getScore() < player2.getScore()) {
			System.out.println(player2.getName() + " has purged the Earth of great sin, but in so doing has committed greater blasphemy.");
		} else {
			System.out.println(player1.getName() + " and "+ player2.getName() + " strove and bled, but in the end neither could kill the other. Will their rivalry last unto eternity, when the great leviathan comes to cleanse the world of their bloody sins?");

		}
	}

}
