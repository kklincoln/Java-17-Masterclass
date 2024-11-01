package dev.lpa.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

/// first, create an array of names in mixed case as was done in the Lambda Expression challenge
/// create a list of Function interfaces or alternately UnaryOperator, which will contain all the operations you want executed on each name in your array
   /// make each name upper case
    /// add a random middle initial
    /// add a last name, which is reverse of the first
/// use a mix of lambda expressions and method references
/// create a method that takes the name array and the function list, and applies each function to each name using the transform method on String to do this
/// all changes should be applied to the original array
/// make sure you explore as many transformations as you can trying as many different types of method references as you can think of

public class Main {
    // RANDOM INITIAL METHOD
    private static Random random = new Random();

    //PRIVATE PERSON RECORD; Extra notes and references
    private record Person(String first){
        public String last(String s){
            return first + " " + s.substring(0, s.indexOf(" ")); // return first, space, concatenate after the new String s
        }
    }

    public static void main(String[] args) {
        //first, create an array of names in mixed case as was done in the Lambda Expression challenge
        String[] names = {"Alex", "Ben", "Charlie", "David", "Edward", "Frank"};

        // create a new person to demonstrate the Tim suffixed with the names
        Person tim = new Person("Tim");
        // create a list of Function interfaces or alternately UnaryOperator, which will contain all the operations
        // you want executed on each name in your array
        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                //MAKE EACH NAME UPPERCASE
                // this is not a static method reference, it's an instance method used on the unbounded retriever; method called on first arg
                String::toUpperCase,
                // ADD A RANDOM MIDDLE INITIAL
                s -> s += " " + getRandomChar('D', 'M') + ".",
                // ADD A LAST NAME (REVERSE OF FIRST NAME)
                s -> s += " " + reverseName(s, 0, s.indexOf(" ")),
                tim::last // passes each name from list to the last method in Person
        ));
        applyChanges(names, list);
    }

    // SET UP A METHOD THAT EXECUTES THE LIST OF FUNCTIONS
    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions){
        List<String> backedByArray = Arrays.asList(names);
        //loop through the list of functions; for each function, call a lambda expression to transform the input by replacing with fx output
        for (var function : stringFunctions){
            backedByArray.replaceAll(s -> s.transform(function));
            //print out the names from the array after each function
            System.out.println(Arrays.toString(names));
        }
    }

    //METHOD TO GET RANDOM MIDDLE INITIAL
    public static char getRandomChar(char startChar, char endChar){
        return (char) random.nextInt((int) startChar, (int) endChar + 1); // nextInt is non-inclusive for end, add 1
    }

    //METHOD TO REVERSE THE NAME
    public static String reverseName (String s){    //overloaded, if no start/end indexes provided
        return reverseName(s, 0, s.length());
    }
    public static String reverseName (String s, int start, int end){
         return new StringBuilder(s.substring(start, end)).reverse().toString();
    }
}
