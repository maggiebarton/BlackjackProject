package com.skilldistillery.cardgame.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.entities.Dealer;
import com.skilldistillery.cardgame.entities.Player;

public class BlackjackApp {
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		BlackjackApp app = new BlackjackApp();
		app.run();

	}

	public void run() {

		System.out.println("Welcome to Blackjack!");
		System.out.println("Press '1' to play or '2' to quit.");
		int gameChoice = sc.nextInt();
		sc.nextLine(); // flush

		switch (gameChoice) {
		case 1:
			playBlackjack();
			break;
		case 2:
			System.out.println("Thanks for stopping by the table. Goodbye!");
			break;
		default:
			System.out.println("Invalid Input. Please try again.");
			run();
			break;

		}
	}

	public void playBlackjack() {
		startGame();
		playerTurn();
		displayWinner();
	}

	public void startGame() {

		// dealer gets a new deck and shuffles
		dealer.setupGame();

		// dealer deals initial cards to respective hands and players add them to hands
		player.addCard(dealer.dealCard(player.getHand()));
		dealer.addCard(dealer.dealCard(player.getHand()));
		player.addCard(dealer.dealCard(player.getHand()));
		dealer.addCard(dealer.dealCard(player.getHand()));
		checkBlackjack(player);

	}

	public void playerTurn() {
		System.out.println("Dealer showing " + dealer.initialShow() + "\t Value: " + dealer.initialShow().getValue());
		System.out.println();
		System.out.println("Player " + player.getHand() + "\t Value: " + player.getHand().getHandValue());

		while (player.getHand().getHandValue() < 21) {
			System.out.println("Would you like to HIT or STAND?");
			String userChoice = sc.nextLine();
			if (userChoice.toUpperCase().equals("HIT")) {
				hit(player);
				System.out.println("Player " + player.getHand() + "\t Value: " + player.getHand().getHandValue());
				checkBlackjack(player);
				checkBust(player);
			}
			if (userChoice.toUpperCase().equals("STAND")) {
				dealerTurn();
				break;
			}
		}
	}

	public void dealerTurn() {
		System.out.println("Dealer " + dealer.getHand() + "\t Value: " + dealer.getHand().getHandValue());
		while (dealer.getHand().getHandValue() < 17) {
			System.out.println("Dealer hits.");
			hit(dealer);
			System.out.println("Dealer " + dealer.getHand() + "\t Value: " + dealer.getHand().getHandValue());
			checkBlackjack(dealer);
			checkBust(dealer);
			if (dealer.getHand().getHandValue() >= 17 && dealer.getHand().getHandValue() <= 20) {
				System.out.println("Dealer stands.");
			}
		}

	}

	public void displayWinner() {
		System.out.println();
		System.out.println("RESULTS:");
		System.out.println("Dealer " + dealer.getHand() + "\t Value: " + dealer.getHand().getHandValue());
		System.out.println("Player " + player.getHand() + "\t Value: " + player.getHand().getHandValue());

		if (dealer.getHand().getHandValue() > player.getHand().getHandValue() && dealer.getHand().getHandValue() < 22) {
			System.out.println("Dealer wins!");

		} else if (dealer.getHand().getHandValue() < 22 && player.getHand().getHandValue() >= 22) {
			System.out.println("Dealer wins!");

		} else if (dealer.getHand().getHandValue() < player.getHand().getHandValue()
				&& player.getHand().getHandValue() < 22) {
			System.out.println("Player wins!");

		} else if (dealer.getHand().getHandValue() >= 22 && player.getHand().getHandValue() < 22) {
			System.out.println("Player wins!");

		} else if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println("Push!");
		}


	}



	public void checkBlackjack(Player player) {
		if (((BlackjackHand) player.getHand()).isBlackjack()) {
			System.out.println("Blackjack!");

		}

	}

	public void checkBust(Player player) {
		if (((BlackjackHand) player.getHand()).isBust()) {
			System.out.println("BUST!");
		}
	}

	public void hit(Player player) {
		player.addCard(dealer.dealCard(player.getHand()));
	}

}
