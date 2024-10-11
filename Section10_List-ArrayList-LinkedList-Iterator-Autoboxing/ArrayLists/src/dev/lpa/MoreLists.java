package dev.lpa;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        //create a new array of Strings
        String[] items = {"apples", "bananas", "milk", "eggs"};

        // create a list from the input of a string
        List<String> list = List.of(items); //transform an array of string to a list of string
        System.out.println(list);

        //verify the type associated to the method calls
//        System.out.println(list.getClass().getName());
//        list.add("Yogurt"); //cannot be done, error generated since the List is immutable

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries); // this can be done now

        //create a new ArrayList with a more streamlined one line with the list.of() method
        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles","mustard","cheese"));
        System.out.println(nextList);

        //adding elements to the ArrayList()
        groceries.addAll(nextList); // adding everything within the list since ArrayList is mutable and you can add from other ArrayLists
        System.out.println(groceries);

        //printing the elements
        System.out.println("Third item = " + groceries.get(2));
        //searching for elements within the list:
        System.out.println("Eggs on the list? " + groceries.contains("eggs")); //returns boolean
        if (groceries.contains("mustard")){
            System.out.println("Mustard is on the list too.");
        }
        //searching for elements, return index
        System.out.println("Yogurt is found on index: " + groceries.indexOf("yogurt")); // returns index
        groceries.add("yogurt");
        System.out.println("Last instance of yogurt found on index: " + groceries.lastIndexOf("yogurt"));

        //removing items from the list:
        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt"); //only removes the first element of the list
        groceries.removeAll(List.of("pickles", "mustard"));
        System.out.println(groceries);
        groceries.retainAll(List.of("eggs","milk","yogurt","cheese"));        //remove through retainAll omission
        System.out.println(groceries);
        groceries.clear();
        System.out.println(groceries);
        System.out.println("isEmpty = " + groceries.isEmpty());

        //re-add items
        groceries.addAll(List.of("apples","milk","mustard","cheese"));
        groceries.addAll(Arrays.asList("eggs","pickles","mustard","ham"));
        System.out.println(groceries);

        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        // GET A LIST FROM AN ARRAY (first create the array in line 72, then covert to string)
        //pass a new string array to the toArray method, initialized to the type and size of the returned array to be (matching the list)
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));


    }


}
