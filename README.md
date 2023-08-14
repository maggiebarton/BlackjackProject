# Blackjack Project

## Overview
Welcome to the Blackjack Table! Upon start of the program, users are prompted with two options:
1. Play Blackjack
2. Quit.

If users decide they want to play, the Dealer will get a new deck of cards, shuffle, and deal cards per the rules of Blackjack. On the players turn, they are able to see only the second card from the dealer's hand, and both cards in their hand. The user can choose to 'HIT' or 'STAND'. If users decide to 'HIT,' a new card is dealt and added to their hand. Users can 'HIT' as many times as they wish as long as they don't BUST (the total value of their hand exceeds 21). When a users decides to 'STAND,' the dealer gets a turn. The dealer will always 'HIT' so long as the total value of their hand is less than 17. The dealer will automatically stand when the value of their hand is between 17-21. If the dealer 'BUSTS,' the player automatically wins.

The winner of each round is determined by the hand values. Whichever player is closest to 21, without going over, is the winner! If the player and the dealer's hands are equal, it's a 'Push' (tie). If a player is initially dealt an Ace, and any other card with a value of 10, this is a 'Blackjack' hand. The player will automatically win unless the dealer was also dealt a 'Blackjack' hand.

At the end of each game, the user is prompted to play again. The user can play as many times as they'd like until they choose option '2' to quit. Good luck!

## Lessons Learned
This Blackjack project has a significant amount of moving parts; much more than meets the eye. I found myself asking the question "who does this" often, where the *who* was really "which class."
*Who* holds the deck and shuffles the cards? The Dealer Class.
*Who* holds the hand during gameplay? The Player Class.
*Who* deals a card? The Dealer Class.
*Who* adds a card to their hand? The Player Class.

This kind of thinking is becoming very important when designing projects on larger scales. How can the dealer hold a hand if the Player Class holds hands? Well, the dealer *is-a* kind of player, and each player *has-a* hand. If I am able to verbalize this kind of logic, syntactically accessing data at the appropriate time is much easier.

The Blackjack app only needs to know who is playing - a Player and a Dealer. The Dealer Class handles any behaviors related to the deck of cards, as well as shares the behaviors of a player. How can the dealer shuffle and deal cards? You guessed it! The dealer *has-a* deck. The deck *has-a* data structure of cards, in this case a List of type Card.

Creating the deck of cards required two enum Types: Rank and Suit. Enum data types were necessary because a deck of cards is made up of 52 single Card objects (organized into a List) each with two predefined constants. A "SEVEN of Hearts," for example, will *always* have a value(Rank) of '7' in the Suit of 'Hearts,' whereas a "JACK of Clubs" will *always* have a value(Rank) of '10' in the Suit of 'Clubs.'

## Technologies Used
- Java
- Eclipse
- Git
- GitHub