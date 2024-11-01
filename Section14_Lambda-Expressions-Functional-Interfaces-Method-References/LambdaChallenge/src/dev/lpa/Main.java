package dev.lpa;

/// This challenge is designed to exercise your skills with methods on Arrays and ArrayLists, that are targets for lambda expressions.
/// First, create an array of String, which is populated with first names, in mixed case. Include at least one name which is spelled the same both directions
/// Use Arrays.setAll, or List.replaceAll to change the values in this array.
/// If you use List methods, you'll need a list backed by the array so that the changes get made to the initial array.
/// Using one of those two methods, perform the following functions on the elements in the array with appropriate lambda expressions
    /// transform all names to uppercase
    /// add a randomly generated middle initial and include a period
    /// add a last name that is the reverse of the first name.
/// print your array or the array elements after each change, using the forEach method at least once.
/// Finally, create a new modifiable ArrayList from your names array, removing any names where the last name = first name
/// use removeIf with a lambda expression for the last operation

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Anna", "Bob", "Carol", "David", "Ed", "Fred", "Gary"};
        System.out.println(Arrays.toString(names));
        Arrays.setAll(names,
                i -> names[i].toUpperCase());//with i as a parameter, return the names array at i index to uppercase
        System.out.println("--> Transform to Uppercase:");
        System.out.println(Arrays.toString(names));
        List<String> backedByArray = Arrays.asList(names);


        System.out.println("--> Add a randomly generated middle initial and include a period");
        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println(Arrays.toString(names));

        System.out.println("--> Add a last name that is the reverse of the first name");
        backedByArray.replaceAll(s -> s+= " " + getReverseString(s.split(" ")[0])); //split after first name (space)
        Arrays.asList(names).forEach(s -> System.out.println(s));

    // create a new modifiable ArrayList from names array, removing names where firstName = lastName, use removeIf with lambda expression
        List<String> newList = new ArrayList<>(List.of(names));
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ") + 1)
        ));
        System.out.println("--> Remove names where first = last");
        newList.forEach(s -> System.out.println(s));
    }


    //TWO PRIVATE STATIC CLASSES TO MAKE LAMBDAS EASIER TO READ
    public static char getRandomChar(char startChar, char endChar){
        return (char) random.nextInt((int) startChar, (int) endChar+1 ); //random char between the indexes provided, non inclusive
    }
    //reverse characters in a string
    public static String getReverseString(String firstName){
        return new StringBuilder(firstName).reverse().toString();
    }
}
