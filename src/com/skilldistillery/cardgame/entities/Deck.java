package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = new ArrayList<>(52);
		// create 13 cards for each suit
		for (Rank rank : Rank.values())
			for (Suit suit : Suit.values()) {
				deck.add(new Card(suit, rank));
			}

	}

	public int checkDeckSize() {
		return deck.size();
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void dealCard(Hand hand) {
		
	}


}
