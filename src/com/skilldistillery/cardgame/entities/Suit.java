package com.skilldistillery.cardgame.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String name;
	
	private Suit(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	public String toString() {
		return name;
	}
	
}
