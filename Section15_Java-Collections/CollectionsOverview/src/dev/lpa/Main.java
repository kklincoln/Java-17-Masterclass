package dev.lpa;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // METHODS DEFINED ON THE COLLECTION INTERFACE EXECUTED ON A SPECIFIC IMPLEMENTATION, THE ARRAYLIST, BUT ASSIGNED TO A LIST VARIABLE
        // LIST, LATER ABSTRACTED TO COLLECTION; recap on how interfaces work.
//        List<String> list = new ArrayList<>();
//        Collection<String> list = new ArrayList<>();
        Collection<String> list = new HashSet<>();  // Treeset implements collection interface, same output; HashSet has same output but not ordered
        String[] names = {"Anna", "Bob", "Charles", "David", "Ed", "Frank"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);
        System.out.println("-".repeat(20));

        // ADDING MORE STATEMENTS USING METHODS SHOWN DEFINED ON THE COLLECTION INTERFACE
        list.add("George");
        list.addAll(Arrays.asList("Gary","Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        // REMOVEIF WITH LAMBDA EXPRESSIONS
        list.removeIf(s -> s.charAt(0) == 'G'); //remove from list if first letter == G
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        //

    }
}
