package com.skilldistillery.blackjack;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Dealing {
	private Deck deck = new Deck();

	public static void main(String[] args) {
		Dealing dealing = new Dealing();
		Scanner scanner = new Scanner(System.in);
		dealing.run(scanner);
		scanner.close();
	}

	private void run(Scanner scanner) {
		deck.shuffle();
		int totalValue = 0;
		while (true) {
			try {
				System.out.println("How many cards do you want?");
				int numCards = scanner.nextInt();
				if (numCards > 52) {
					InputMismatchException e = new InputMismatchException();
					throw e;
				}
				for (int i = 0; i < numCards; i++) {
					Card removed = deck.removeCard();
					System.out.println(removed);
					totalValue += removed.getValue();
				}
				System.out.println("Total card value = " + totalValue);
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter an integer between 1 and 52");
			}
		}
	}
}
