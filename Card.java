		// 1. Card Class:
		//		Create a class called Card to represent a standard playing card. 
		//		Fields:   The Card class should have the following fields:
		// 			a. name field
		//			b. suit field
		//			c. value field for comparing against other cards.
		//
		//		Methods:  This class can have any useful method.
		//			a. describe() to display the card information to the Console.
		//			b. Getters & Setters 
		//
package week05;

public class Card {
		private String name;
		private String suit;
		private int suitValue;
		private int value;
		
		public Card(int value, String suit) {
			setValue(value);
			setSuit(suit);
			setName();
		}
		public Card() {
			
		}
		
		public void setName() {
			if (this.getValue() == 2) {
				this.name = "Two";
			} else if (this.getValue() == 3) {
				this.name = "Three";
			} else if (this.getValue() == 4) {
				this.name = "Four";
			} else if (this.getValue() == 5) {
				this.name = "Five";
			} else if (this.getValue() == 6) {
				this.name = "Six";
			} else if (this.getValue() == 7) {
				this.name = "Seven";
			} else if (this.getValue() == 8) {
				this.name = "Eight";
			} else if (this.getValue() == 9) {
				this.name = "Nine";
			} else if (this.getValue() == 10) {
				this.name = "Ten";
			} else if (this.getValue() == 11) {
				this.name = "Jack";
			} else if (this.getValue() == 12) {
				this.name = "Queen";
			} else if (this.getValue() == 13) {
				this.name = "King";
			} else if (this.getValue() == 14) {
				this.name = "Ace";
			} else {
				this.name = "Mystery Card";
			}
			
		}
		
		
		public String getName() {
			return name;
		}
		
		public void setSuit(String suit) {
			this.suit = suit;
			suit = suit.toLowerCase();
			switch (suit) {
			case ("clubs"):
				suitValue = 1;
			break;
			case ("diamonds"):
				suitValue = 2;
			break;
			case ("hearts"):
				suitValue = 3;
			break;
			case ("spades"):
				suitValue = 4;
			}
		}
		
		public String getSuit() {
			return suit;
		}
		
		public void setValue(int value) {
			if (value < 15 && value > 1) {
				this.value = value;
			} else {
				this.value = 0;
				System.out.println("invalid card value");
			}
		}
		
		public int getValue() {
			return value;
		}
		/*
		 * I had to make separate static and non-static methods to return value. I'm not sure if this is a good practice, or if there's something I don't understand yet.
		 */
		public int returnValue() {
			return value;
		}
		
		public int getSuitValue() {
			return suitValue;
		}
		
		public String cardInfo() {
			return name + " of " + suit;
		}
}
