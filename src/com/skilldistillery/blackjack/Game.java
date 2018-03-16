package com.skilldistillery.blackjack;

import java.util.Scanner;

import common.Card;
import common.Deck;

public class Game {
	private static Player player = new Player();
	private static Player dealer = new Player("Dealer");
	private static Deck deck = new Deck();
	private static boolean bust;

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
			turns(scanner);
			newGame(scanner);
		}
	}

	private void turns(Scanner scanner) {
		int dealerScore = dealer.hand.getValueOfHand();
		int playerScore = playerTurn(scanner);
		if (playerScore <= 21) {
			dealerScore = dealerTurn(scanner);
		}
		checkForWinner(playerScore, dealerScore);
		printLines();
	}

	private void checkForWinner(int playerScore, int dealerScore) {
		if (dealerScore <= 21 && playerScore <= 21) {
			if (dealerScore > playerScore) {
				System.out.println("Dealer Wins!");
			}
			else if (playerScore > dealerScore) {
				System.out.println("Player Wins!");
			}
			else {
				System.out.println("The game is a draw!");
			}
		}
	}

	private int dealerTurn(Scanner scanner) {
		System.out.println("The dealer flips his face down card over, he is showing: " + dealer.hand.getCardsInHand());
		while (true) {
			if (dealer.hand.getValueOfHand() > 21) {
				System.out.println("Dealer busts. You win!");
				break;
			}
			else if (dealer.hand.getValueOfHand() > 17 && dealer.hand.getValueOfHand() < 22) {
				System.out.println("Dealer will stand. He has " + dealer.hand.getValueOfHand() + " points");
				break;
			}
			else {
				dealDealerCard();
			}
		}
		return dealer.hand.getValueOfHand();
	}

	private int playerTurn(Scanner scanner) {
		boolean hit = true;

		while (hit == true) {
			checkForBust(player.hand);
			if (player.hand.getValueOfHand() < 21) {
				hit = hitOrStand(scanner);
				if (hit == false) {
					System.out.println(player.name + "'s turn is over for the round. Your total is "
							+ player.hand.getValueOfHand());
					printLines();
					System.out.println("Dealers turn:");
				}
			}
			else if (player.hand.getValueOfHand() == 21) {
				System.out.println("You have 21, your turn is over.");
				return player.hand.getValueOfHand();
			}
			if (checkForBust(player.hand)) {
				break;
			}

		}
		return player.hand.getValueOfHand();
	}

	private void newGame(Scanner scanner) {
		System.out.println("Would you like to play again? Y/N");
		if (scanner.next().toLowerCase().charAt(0) == 'y') {
			deck = new Deck();
			player.hand = new Hand();
			dealer.hand = new Hand();
		}
		else {
			System.out.println("Thank you for playing! GoodBye!");
			System.exit(0);
		}
	}

	private boolean hitOrStand(Scanner scanner) {
		System.out.println("Would you like to hit or stand? h/s");
		while (true) {
			char entry = scanner.next().charAt(0);
			if (entry == 'h') {
				dealPlayerCard();
				return true;
			}
			else if (entry == 's') {
				return false;
			}
			else if (entry != 'h' && entry != 's') {
				System.out.println("Entry not recognized. Please try again.");
			}
		}

	}

	private void dealPlayerCard() {
		printLines();
		System.out.println("The dealer places another card face up in front of you, you now have: ");
		player.hand.addCard(deck.removeCard());
		System.out.println(player.hand.getCardsInHand());
		printLines();
	}

	private void dealDealerCard() {
		printLines();
		System.out.println("The dealer places another card face up in front of him, he now has: ");
		dealer.hand.addCard(deck.removeCard());
		System.out.println(dealer.hand.getCardsInHand());
		printLines();
	}

	private void printLines() {
		System.out.println("**************************************************************************");
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

		System.out.println("The dealer places another card face up in front of you, you now have: ");
		player.hand.addCard(deck.removeCard());
		System.out.println(player.hand.getCardsInHand());

		System.out.println("The dealer places a card face up in front of him, he is showing: ");
		Card dealerFaceUp = deck.removeCard();
		dealer.hand.addCard(dealerFaceUp);
		System.out.println("[Face Down, " + dealerFaceUp + "]");
	}

	private boolean checkForBust(Hand hand) {
		if (hand.getValueOfHand() <= 21) {
			return false;
		}
		else {
			System.out.println(player.name + " busts! Dealer wins this hand.");

			return true;
		}
	}

}
