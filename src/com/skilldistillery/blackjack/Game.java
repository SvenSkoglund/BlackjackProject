package com.skilldistillery.blackjack;

import java.util.Scanner;

public class Game {
	private static Player player = new Player();
	private static Player dealer = new Player("Dealer");
	private static Deck deck = new Deck();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();
		game.run(scanner);
	}

	private void run(Scanner scanner) {
		welcomeMessage();
		player.name = scanner.nextLine();
		dealCards();

	}

	private void welcomeMessage() {

		System.out.println("******************************************");
		System.out.println("*Welcome to BlackJack! What is your name?*");
		System.out.println("******************************************");

	}
	
	private void dealCards() {
		deck.shuffle();
		player.hand.addCard(deck.removeCard());
		dealer.hand.addCard(deck.removeCard());
		player.hand.addCard(deck.removeCard());
		dealer.hand.addCard(deck.removeCard());
	}

}
