package dev.lpa.games.poker;

import dev.lpa.Card;

import java.util.*;
import java.util.function.Consumer;

public class PokerGame {
    private final List<Card> deck = Card.getStandardDeck();
    private int playerCount;
    private int cardsInHand;
    private List<PokerHand> pokerHands;
    private List<Card> remainingCards;

    ///CREATE A CONSTRUCTOR WITH PLAYERCOUNT AND CARDSINHAND
    public PokerGame(int playerCount, int cardsInHand) {
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }

    ///CREATE STARTPLAY METHOD WITH NO PARAMS; SHUFFLES DECK AND PRINTS
    public void startPlay(){
        Collections.shuffle(deck);
        Card.printDeck(deck);
        ///CREATE A CUT THE DECK
        int randomMiddle = new Random().nextInt(15,35);
        Collections.rotate(deck, randomMiddle); //middle of the deck would be card 26 not randomMiddle
        Card.printDeck(deck);
        ///DEAL CARDS
        Deal();
        System.out.println("-".repeat(20));
        Consumer<PokerHand> checkHand = PokerHand::evalHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));

        int cardsDealt = playerCount * cardsInHand;
        int cardsRemaining = deck.size() - cardsDealt;
        //create a new arraylist for remainingCards, populate the list with the size calculated from cardsRemaining
        remainingCards = new ArrayList<>(Collections.nCopies(cardsRemaining, null));
        remainingCards.replaceAll(c -> deck.get(cardsDealt + remainingCards.indexOf(c)));
        Card.printDeck(remainingCards, "Remaining Cards" , 2);

    }

    /// DEAL PLAYER'S HANDS
    private void Deal(){
        Card[][] hands = new Card[playerCount][cardsInHand]; // create a new array associated with each player
        for (int deckIndex = 0, i =0; i < cardsInHand ; i++){//for each of the cards in the deck
            for (int j =0; j < playerCount; j++){ // loop through the players
                hands[j][i] = deck.get(deckIndex++);

            }
        }

        int playerNo = 1;
        //loop through the 2D array, instantiate a new poker hand for each player, passing in their array of cards using Arrays.asList(hand) in constructor
        for (Card[] hand : hands){
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }

    }

    ///EVALUATE PLAYERS' HANDS


}
