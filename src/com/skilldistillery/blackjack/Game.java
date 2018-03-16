package com.skilldistillery.blackjack;

import java.util.Scanner;

import Cards.Card;
import Cards.Deck;

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

		while (true) {
			dealCards();

			break;
		}
	}

	private void welcomeMessage() {

		System.out.println("******************************************");
		System.out.println("*Welcome to BlackJack! What is your name?*");
		System.out.println("******************************************");

	}

	private void dealCards() {
		deck.shuffle();
		System.out.print("The dealer places one card face up in front of you, you have: ");
		player.hand.addCard(deck.removeCard());
		System.out.println(player.hand.getCardsInHand());

		System.out.println("The dealer places one card face down in front of him");
		dealer.hand.addCard(deck.removeCard());

		System.out.print("The dealer places another card face up in front of you, you now have: ");
		player.hand.addCard(deck.removeCard());
		System.out.println(player.hand.getCardsInHand());

		System.out.print("The dealer places a card face up in front of him, he is showing: ");
		Card dealerFaceUp = deck.removeCard();
		dealer.hand.addCard(dealerFaceUp);
		System.out.println("[Face Down, " + dealerFaceUp + "]");
	}

}
