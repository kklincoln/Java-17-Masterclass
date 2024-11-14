package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /// TEST CODE FOR FUNCTIONALITY

        /// TESTING METHODS ON JAVA.UTIL.COLLECITONS
        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A'); // new card passing abbrev and suit
        Arrays.fill(cardArray, aceOfHearts); //pass the aceOfHearts card into the the array
        Card.printDeck(Arrays.asList(cardArray), "Ace of Hearts", 1);   // all 13 cards are filled with the A<3

        // note that this approach doesn't work as expected because the instantiation of the arrayList of 52 length doesn't
        // fill it will null values, but rather reserves the memory. the Collections.fill() only replaces existing values in an ArrayList
        List<Card> cards = new ArrayList<>(52); // new arrayList of Cards holding 52 for standard deck
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());
        //a working approach to achieve the desired effect
        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        //correcting the desired effect from code lines 22-28
        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);//showing the instance in which more elements than memory reservations are added
        Card.printDeck(cards, "Card Collection with Aces added" , 2);

        ///COLLECTIONS.COPY replaces existing elements with elements passed
        //note: these lines also require that there actually be values added to the List, not just the memory reservations
        Collections.copy(cards, kingsOfClubs);  //destination of copied elements (full deck), copied elements
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        ///LIST.COPYOF returns an immutable copy of the list passed
        //if you want a full list of copy, you'd use List.copyOf()
        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);


        ///
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
    ///shuffle is a good tool to randomize a list of existing elements
        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);
        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed deck of cards", 4);

    ///sorting; Collections.sort() takes list as first argument, you can also pass a comparator
        //comparator local variable
        var sortingAlgo = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgo);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck); //highest to lowest rank
        Card.printDeck(deck, "Sorted by rank, suit reversed", 13);

    ///Comparing subLists to full lists
        List<Card> kings = new ArrayList<>(deck.subList(4, 8)); //starting index 4, ending index 8, exclusive index
        Card.printDeck(kings, "Kings in deck", 1);
        List<Card> tens = new ArrayList<>(deck.subList(16, 20)); //starting index 4, ending index 8, exclusive index
        Card.printDeck(tens, "Tens in deck", 1);

        ///use the two lists above to test additional methods on Collections class
//        Collections.shuffle(deck);  //when shuffling, the next line returns -1 meaning it's not found in the sublist, but contains full list
        int subListIndex = Collections.indexOfSubList(deck, tens);// search deck for tens list ,return index if exits
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        ///Disjoint method; returns true if two lists have no elements in common
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("Disjoint = " + disjoint); //should return false
        boolean disjoint2 = Collections.disjoint(tens, kings);
        System.out.println("Disjoint = " + disjoint2); //should return true

        ///BinarySearch; requires the list be sorted order prior to running. you can use List.indexOf to do the same w/o sort
        deck.sort(sortingAlgo);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgo);
        System.out.println("foundIndex = " + foundIndex);   //dependent on sorting of list
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts)); // can find without list sorting
        System.out.println(deck.get(foundIndex));

        ///ReplaceAll; requires you to replace one or more instances with another
        //first create a tenOfClubs card
        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32,36), "Tens Row", 1); //there will now be two tens of hearts cards
        if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)){
            System.out.println("Ten of hearts replaced by ten of clubs");
        }else {
            System.out.println("Nop tens of hearts were found in the list"); // this will print because they were already replaced above
        }

        /// Frequency method; allows to check for duplicates in the collection
        System.out.println("Ten of Clubs Card = " + Collections.frequency(deck, tenOfClubs));

        /// min/max
        System.out.println("Best Card = " + Collections.max(deck, sortingAlgo));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgo));

        ///ROTATE; imagine the list being like a rolladex, you can 'rotate' the elements through shifting their positions
        //create new comparator
        var sortBySuit = Comparator.comparing(Card::suit);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);
            // create new lists to visualize rotation
        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, 2);  /// ROTATES 2 TO THE RIGHT
        System.out.println("UnRotated: " + deck.subList(0,13));
        System.out.println("Rotated" + 2 + ": " + copied);
            //ROTATE LEFT
        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, -2); /// ROTATES ELEMENTS 2 TO THE LEFT
        System.out.println("UnRotated: " + deck.subList(0,13));
        System.out.println("Rotated" + -2 + ": " + copied);

        /// SWAP; reminder that you only need to swap half of the elements
        copied = new ArrayList<>(deck.subList(0,13));
        for (int i = 0; i < copied.size() / 2; i++){
            Collections.swap(copied, i, copied.size() - 1 - i); // swap i with the opposing side of the list
        }
        System.out.println("Manual reverse :" + copied);
        ///Collections.Reverse
        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Using Collections.reverse :" + copied);
    }
}
