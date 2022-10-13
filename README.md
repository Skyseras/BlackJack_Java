# BlackJack_Java
Creating a java console application -BlackJack-

## Context of the project
You are a digital mediator and you are asked to give gaming workshops to YouCode learner profiles.

The pedagogical team decides to create a card game that helps learners have fun.

​In a card game, a card is characterized by its height (1 for the ace, 2 to 10 for the corresponding cards, 11 for the jack, 12 for the queen, 13 for the king), and by its color (1 for diamonds, 2 for hearts, 3 for spades, and 4 for clubs).

​

### Example :

​(12 3)) -> (Queen Spades)
(5 1) -> (5 Diamond)

​We want to create a deck of 52 cards defined as a list of cards. For this, we will define a method that builds a list of cards according to a given first card, and we will then use to create the deck of cards from the ace of diamonds. For this you must use:

​
### A method
#### 1

which builds the list of the following cards of a card given in parameter. This list must respect the order of suits (diamonds, hearts, spades, clubs); thus the last card corresponds to the king of clubs. (13 4) -> () (8 4) -> (9 4) (10 4) (11 4) (12 4) (13 4) (12 3) -> ((13 3) (1 4) ( 2 4) (3 4) (4 4) (5 4) (6 4) (7 4) (8 4) (9 4) (10 4) (11 4) (12 4) (13 4))

#### 2

a method that creates a deck of 52 cards defined as a list of pairs of values. Example : (create_cartes) -> ((1 1) (2 1) … (12 4) (13 4))
​
#### 3

To write a method that shuffles a deck of cards, we will proceed in several steps. To shuffle, you must be able to draw a card at random to make it the first card of the new shuffled deck. For this, the index i of the card to be drawn will be chosen at random, in order to then extract the card with index i from the game. Here are three methods that allow you to program this method.

#### 4

The extraction_ieme_card method which extracts the ith card from a list of cards given as a parameter. This method returns a list consisting of the extracted card and the list of remaining cards (extract_ieme_card '((1 1) (12 3) (14 4)) 2) -> ((12 3) ((1 1) (14 4)))

#### 5

The draw_a_card method which draws a card at random from among the cards in a list of cards given as a parameter. This function returns a list consisting of the card drawn, and the list of cards remaining after the draw. To write this method, use random n which returns a random number between 0 (inclusive) and n (excluded), as well as the extract_ieme_carte method. (draw_a_card '((1 2) (13 4) (5 3) (1 1) (6 3))) -> ((6 3) ((1 2) (13 4) (5 3) (1 1) ))

#### 6

Write the method melange_jeu_cartes which allows to mix the cards of a list of cards given in parameter. This method returns the list of shuffled cards. Note that this method uses the fmethod draw_a_card. (shuffle_card_game '((10 1) (4 4) (5 2)) -> ((10 1) (5 2) (4 4))
​
#### 7

Drawing cards is different from drawing cards at random: the draw pile is a deck of cards. When you draw cards, you take the cards that are on top of the draw pile. When discarding, put the cards back on the bottom of the draw pile.

#### 8

The draw_n_cards method which lets you draw the first n cards from a list of cards given as a parameter. This method returns a list consisting of the list of cards drawn, and the list of cards remaining in the draw pile. (draw_n_cards '((13 4) (5 3) (1 1) (6 3)) 2) -> (((13 4) (5 3)) ((1 1) (6 3)))

#### 9

The discard_cards method which takes two lists of cards as parameters (a list of cards corresponding to the draw pile and a list of cards to discard) and which returns the list of these cards from the draw pile, whose cards to discard have been put in the end. (discard_cards '((1 1)(1 2)) '((3 4)(4 3))) -> ((1 1)(1 2)(3 4)(4 3)
​



### Gameplay

A game of blackjack will oppose the player to the bank. The bank begins by drawing a card and then gives the player two. The goal of this game is to approach or reach the number 21 without exceeding it. The value of the cards is established as follows: the cards from 2 to 10 keep their values, the face cards are worth 10 and the ace is worth 1.

The player can request as many cards as he wishes. If he exceeds 21, he loses. If he stops before, the bank draws cards until exceeding 17 so as not to take any risk. If the bank makes less than the player, or goes over 21, the player wins. If he makes less than the bank, the player loses. Otherwise, there is a tie.

In this project, a blackjack game will be considered as a list of 3 sub-lists: the list of bank cards, the list of player cards and the list of cards remaining in the deck.


The create_blackjack method prepares the blackjack game by initializing the list corresponding to the game. This method thus returns a list made up of the list of player cards (empty at the start), the list of bank cards (empty at the start), and the draw pile (composed at the start of the 52 shuffled cards of the game)

Methods provide access to the list of player, bank and draw cards, respectively, from a list defining the game of blackjack.

Methods provide access to the list of player, bank and draw cards respectively from a list defining the game of blackjack

The bank_draw_n method that updates the blackjack game after the bank draws n cards

The player_draw_n method that updates the blackjack game after the player draws n cards.

A method total_cartes which returns the points corresponding to a list of cards given in parameter. As a reminder, an ace counts as one point; tricks count for ten points; cards from 2 to 10 retain their values. (total_cards '((1 3) (13 4) (5 4))) -> 16

A faire_jouer_banque method that makes the bank play until it reaches at least a total of 17 points. This method returns the updated blackjack list

A display_game method is used to display the state of the game.

A make_play_player method that returns the updated blackjack hand after the player has played (after 0, one or more draws). If the player reaches 21 points, there is no point in continuing to play. Otherwise this method must give the choice to the player to play again or not.

A method all_discard makes it possible to discard all the cards in order to start playing again. This method thus returns the game of blackjack whose cards of the bank and those of the player have been put in the draw pile.

The turn_of_game method simulates a game turn: the bank draws a card, then the player draws 2 cards, and continues to play if he wishes. When the player stops, his points are counted. If the player has exceeded 21 points, the method displays the fact that he has lost. Otherwise, the bank continues to play. At the end of the bank's game, its number of points is counted. Then the method displays the game and a message stating who is the winner.

A method allows you to play several rounds in blackjack
​



In the complete rule of blackjack, each Ace can take the value of 1 or 11. In practice, for a given player, a single Ace can take the value 11 (otherwise we have a score of at least 22), and the value of an Ace is chosen to maximize the score without exceeding 21. 

#### Example: 

If a player has an Ace and a 4, he has (at your choice) 5 points or 15: we will favor the value 11 for the Ace to take advantage of a better score. If the player decides to draw another card and he gets a 9, the Ace is then worth 1 to reach a total of 14 (instead of 24 if it was worth 11). Propose a method total_cartes2 which takes into account this new rule in the counting of points of a set of cards.

​

A battle game will oppose the player to the machine. A deck of 52 cards is shuffled and split into two decks of 26 cards: one for the machine, the other for the player. Each turn, the player and the machine draw a card from their deck. Whoever draws the card with the highest height wins the trick, that is to say, he puts the two cards played below his deck. To simplify the problem, we decide that the Ace is worth 1 and that in the event of a tie, everyone puts their card back under their deck. The game continues until one player has no more cards. The other player is then the winner.