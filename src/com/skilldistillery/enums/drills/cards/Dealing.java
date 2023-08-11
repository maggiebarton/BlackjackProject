package com.skilldistillery.enums.drills.cards;

import com.skilldistillery.cardgame.entities.Deck;

public class Dealing {

	public static void main(String[] args) {
		int howMany = 52;
		
		Deck deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < howMany; i++) {
		System.out.println("Your card is: " + deck.dealCard() + "\t Cards left in deck: " + deck.checkDeckSize());
		}
	}

}
