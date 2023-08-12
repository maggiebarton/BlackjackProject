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

	public void dealerTurn() {
		System.out.println("Dealer " + dealer.getHand() + "\t Value: " + dealer.getHand().getHandValue());
		while (dealer.getHand().getHandValue() < 17) {
			System.out.println("Dealer hits.");
			hit(dealer);
			System.out.println("Dealer " + dealer.getHand() + "\t Value: " + dealer.getHand().getHandValue());
		}
		if (dealer.getHand().getHandValue() >= 17 && dealer.getHand().getHandValue() <= 20) {
			System.out.println("Dealer stands.");
		}

		if (dealer.getHand().getHandValue() > 21) {
			System.out.println("BUST!");
		}
	}

	public void displayWinner() {

	}

}
