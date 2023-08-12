package com.skilldistillery.cardgame.blackjack.app;

import com.skilldistillery.cardgame.entities.Card;
import com.skilldistillery.cardgame.entities.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}
	


	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		return handValue;
	}

	public boolean isBlackjack() {
		if (this.getHandValue() == 21) {
			return true;

		} else
			return false;

	}

	public boolean isBust() {
		if (this.getHandValue() > 21) {
			return true;
		} else
			return false;

	}

}
