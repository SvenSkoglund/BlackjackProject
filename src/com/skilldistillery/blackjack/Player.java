package com.skilldistillery.blackjack;

public class Player {
	public String name;
	public Hand hand;
	public Wallet wallet;
	Player(){
		hand = new Hand();
		wallet = new Wallet(100);
	}
	
	Player(String name){
		this.name = name;
		hand = new Hand();
	}
	
	public void placeWager(int wager) {
		
	}
}
