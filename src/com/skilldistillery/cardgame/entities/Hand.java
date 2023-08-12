package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();;
	
	public Hand() {
		
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void clear() {
		hand.clear();
		
	}

	
	public Card getCardfromHand(int whichIndex) {
			return hand.get(whichIndex);
		
	}

	public abstract int getHandValue();

	@Override
	public String toString() {
		return  "Hand: " + hand;
	}
	
	
}
