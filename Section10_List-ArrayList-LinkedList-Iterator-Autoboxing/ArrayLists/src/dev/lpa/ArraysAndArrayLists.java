package dev.lpa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysAndArrayLists {
    public static void main(String[] args) {

        //create a StringArray passing three elements
        String[] originalArray = new String[]{"First", "Second", "Third"};
        //var lets us declare the variable without knowing the type exactly.
        // pass original string array as the argument to create ArrayList
        var originalList = Arrays.asList(originalArray);

        originalList.set(0, "one"); //set the item at the 0 index = "one"
        System.out.println("list: " + originalList);
        System.out.println("Array: " + Arrays.toString(originalArray));
        // note that both the list and the original array are updated according to the change to ArrayList.
        //this is why you cannot change the length of the arraylist when it is created this way

        //second demonstration:
        originalList.sort(Comparator.naturalOrder());
        System.out.println("list: " + originalList);
        System.out.println("Array: " + Arrays.toString(originalArray));

        //this method takes variable args, you can use it to create fixed size lists from a list of elements
        List<String> newList = Arrays.asList("Sunday","Monday","Tuesday");
        System.out.println(newList);

    }
}
