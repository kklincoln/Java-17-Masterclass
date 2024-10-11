package lpa.dev;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Challenge_ArrayLists {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        //create ArrayList: groceryList
        ArrayList<String> groceries = new ArrayList<>();


        // create the scanner to scan for user input
        while (flag){
            printActions();
            switch(Integer.parseInt(scanner.nextLine())){ //scan the console input and convert string to int
                case 0 -> {
                    System.out.println("Shutting down...");
                    System.exit(0); //exit with status 0
                }
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag = false; // if user enters anything other than the above, code crashes, breaks loop
            }
            //print sorted list after each operation
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }

    //method to print the prompt; code cleanliness
    private static void printActions(){
        String textBlock = """
                Available Actions:
                
                    0 - to shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove any items (comma delimited list)
                
                    Enter a number for which action you want to do:""";
        System.out.println(textBlock + " ");
    }

    //create methods on the ArrayList to add items, remove items, check if item is already in the list, and print sorted list
    //do not allow duplicates
    public static void addItems(ArrayList<String> groceries){
        System.out.println("Add item(s) [separate items by comma]: ");
        String[] items = scanner.nextLine().split(","); //create a String array from the user input, split by comma

        for (String i : items){
            String trimmed = i.trim(); //remove trailing whitespace
            if(groceries.indexOf(trimmed) < 0){ //if not in list
                // add to list
                groceries.add(trimmed);
            }
        }
    }
    public static void removeItems(ArrayList<String> groceries){
        System.out.println("Remove item(s) [separate items by comma]: ");
        String[] items = scanner.nextLine().split(","); //scan the user input and split by comma, store in string array

        for (String i : items){// for each item within the String Array created above,
            String trimmed = i.trim(); // trim whitespace
            groceries.remove(groceries.indexOf(trimmed));
        }
    }

}
