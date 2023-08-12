package com.skilldistillery.cardgame.entities;

import com.skilldistillery.cardgame.blackjack.app.BlackjackHand;

public class Player {
	protected Hand hand;
	
	public Player() {
	this.hand = new BlackjackHand();
	}
	
	public void addCard(Card card) {
		hand.addCard(card);
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	

}
