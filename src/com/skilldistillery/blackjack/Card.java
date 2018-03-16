package com.skilldistillery.blackjack;


public class Card {
	// Create a class called Card.
	//
	// A card has a Suit and Rank. Set these in the constructor.
	// Generate the methods hashCode and equals
	// Add a toString which says rank + " of " + suit.
	// Add a method getValue to return the card's numeric value.

	private Suit suit;
	private Integer rank;

	Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank.getValue();

	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	public int getValue() {
		return rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
}
