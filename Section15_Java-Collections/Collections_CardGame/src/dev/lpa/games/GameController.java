package dev.lpa.games;

///Collections Method Challenge, Your own card game : FIVE CARD DRAW
///
/// CREATE A DECK OF CARDS
/// SHUFFLE YOUR DECK
/// DEAL YOUR PLAYER’S HANDS: pick the number of players player and figure out how to deal the cards one at a time to each hand or some other way
/// EVALUATE YOUR PLAYERS’ HANDS for card combinations that are important to the game
/// USE A COMBINATION OF java.util.Collections and List methods to achieve the results

import dev.lpa.games.poker.PokerGame;

///Dealer shuffles the deck, asks another player to cut the deck
/// dealer deals the cards one at a time to each player, starting with the player on the dealer's left, until each player has 5 cards
/// each player evaluates his hand for certain card combinatinos, called card ranks
/// each player can discard up to 3 cards
/// the dealer will replace discarded cards from the remaining pile, in the order they've been shuffled.
/// each player reevaluates his hand if he drew new cards, and bets on his hand.

//card ranks: https://www.Wikihow.com/play-five-card-draw

public class GameController {
    public static void main(String[] args) {
        PokerGame fiveCardDraw = new PokerGame(8,5);
        fiveCardDraw.startPlay();
    }
}
