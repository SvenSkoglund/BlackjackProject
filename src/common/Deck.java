package common;


import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	// Create a class Deck. It will hold a List of Cards.
	// In the constructor, initialize the List with all 52 cards.
	// Add a method checkDeckSize which returns the number of cards still in the
	// deck.
	// Add a method dealCard that removes a Card from the deck.
	// Add a method shuffle to shuffle the deck.
	List <Card> cards = new ArrayList<>();
	
	public Deck(){
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 0; j < Rank.values().length; j++) {
				cards.add(new Card(Suit.values()[i],Rank.values()[j]));
			}
		}
	}
	
	public Card removeCard() {
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
}
