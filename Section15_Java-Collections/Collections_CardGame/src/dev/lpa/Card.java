package dev.lpa;
/// Set up a Card class which will be used to create a deck of playing cards.
/// Using these cards, and decks of cards, to demonstrate methods on the java.util.Collections framework.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

///      A face field, which will be a String, containing either the number of the card, or the face value of the card, Jack, Queen, King, or Ace.
///        a rank, an integer

public record Card(Suit suit, String face, int rank){
    /// the card will have three fields:
    ///        A suit, meaning Club, Diamond, Heart, or Spade. This will be an enum
    public enum Suit {CLUB, DIAMOND, HEART, SPADE;
        public char getImage(){
            //club: 9827, diamond: 9830, Heart: 9829, Spade: 9824
            return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
        }
    };

    //PUBLIC INSTANCE METHODS
    /// the card should override the toString method and print hte card with the face value (abbrev if a face card), the ASCII character of the suit, and the rank in parentheses.
    /// The output shown here shows all the cards in a standard deck of playing cards, sorted by suit and rank.
    public static Comparator<Card> sortRankReversedSuit(){
        return Comparator.comparing(Card::rank).reversed().thenComparing(Card::suit); //higher ranked cards listed first
    }



    @Override
    public String toString() {
        int index = face.equals("10") ? 2: 1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }

    /// the Card should have the following public static methods to assist anyone using the class
    /// PUBLIC STATIC METHODS
    public static Card getNumericCard(Suit suit, int cardNumber){
        /// getNumericCard returns an instance of Card based on the suit and number passed to it.
        if (cardNumber > 1 && cardNumber < 11){
            return new Card(suit, String.valueOf(cardNumber), cardNumber-2); //lowest card is a 2, so sub2 for rank
        };
        System.out.println("Invalid Numeric card selected");
        return null;
    }
    public static Card getFaceCard(Suit suit, char abbrev){
        /// getFaceCard returns an instance of a Card based on the suit and the abbrev passed to it
        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1){
            return new Card(suit, "" + abbrev, 9 + charIndex);
        }
        System.out.println("Invalid Face card selected");
        return null;
    }
    public static List<Card> getStandardDeck(){
    /// getStandardDeck returns a list of Cards youd find in a standard deck, see previous image for details.
        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()){    // loop through the enums for all suits (4)
            for (int i = 2; i <=10; i++){ // loop cards 2-10
                deck.add(getNumericCard(suit, i));//add card using previously declared method
        }
            for (char c : new char[]{'J','Q','K','A'}){//loop through face cards
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }


    public static void printDeck(List<Card> deck){
        /// Finally, the Card should have an overloaded printDeck method, that will print the “Current Deck” as
        ///the description and use 4 as the number of rows to be printed
        printDeck(deck, "Current Deck", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows){
        /// printDeck which takes a description, a list of Card, and a row count. print Cards out in the number of rows passed
        System.out.println("-".repeat(20));
        if (description != null){
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows;
        for (int i = 0 ; i < rows; i++){
            int startIndex = i * cardsInRow; // so second row of standard deck would be index 1 * 13, 2* 26, etc.
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }
}



