package com.skilldistillery.blackjack;

public class Player {
	public String name;
	public Hand hand;
	public double wallet;

	Player(){
		hand = new Hand();
	}
	
	Player(String name){
		this.name = name;
		hand = new Hand();
	}
	
	public void placeWager(int wager) {
		
	}
}
