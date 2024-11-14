package dev.lpa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // showing the variations of "hello"
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        /// note that the first four elements show th eexact same hash code, but the one with a lowercase 'h' shows a different one
        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);
        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));

        /// a HashSet is a class that implements the Set interface and tracks duplicates by their hash code.
        Set<String> mySet = new HashSet<>(hellos);
        ///Most collections allow the creation of another collection type, by passing a different collection to the constructor
        /// as we are doing here. Passing a list to a Set, but a Set’s constructor allows any instance that implements Collection to be passed to it.
        System.out.println("mySet = " + mySet);
        System.out.println("# of elements = " + mySet.size()); // confirms the number of elements: 2, even though the list had 5

        /// Loop through the elements to see which string references are stored in the set
        for (String setValue : mySet){
            System.out.print(setValue + ": ");
            //loop through the strings in the hellosList
            for (int i = 0; i < hellos.size(); i++){
                if (setValue == hellos.get(i)){ // if the comparison is the same object in memory (==)
                    System.out.print(i + ", ");
                }
            }
            ///the first element, hello with an uppercase H is the same as the first two list elements (index 0 and 1), hello is same as element 4 in the list
            System.out.println(" "); //new line after each set element
        }
    /// SET UP NEW CARDS
        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs","King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");
            //generate a list of the new cards created
        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach(s -> System.out.println(s + ": " + s.hashCode())); // generates unique hashcodes for each.

        ///create a set of cards, adding them one at a time
        Set<PlayingCard> deck = new HashSet<>();
        for (PlayingCard c : cards){
            if(!deck.add(c)){ // returns true if element is successfully added and false if not, sets dont allow duplicates
                System.out.println("Found a duplicate for " + c);
            }
        }
        System.out.println(deck);
    }
}
