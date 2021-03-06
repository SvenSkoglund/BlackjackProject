package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import common.Card;

public class Hand {

	List<Card> hand = new ArrayList<>();

	public void addCard(Card card) {
		hand.add(card);
	}

	public List<Card> getCardsInHand() {
		return this.hand;
	}
	
	public int getValueOfHand() {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}

}
