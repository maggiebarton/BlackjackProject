package com.skilldistillery.cardgame.entities;

public class Dealer extends Player {
	private Deck deck;

	public Dealer() {
		deck = new Deck();

	}
	
	public void setupGame () {
		deck.shuffle();
	}

	public Card dealCard(Hand hand) {
		
		return deck.dealCard();
	}
	
	public Card initialShow() {
	//show only one card from first deal (2nd index)
	return hand.getCardfromHand(1);	
	}
	
	public void showHand() {
		
	}

}
