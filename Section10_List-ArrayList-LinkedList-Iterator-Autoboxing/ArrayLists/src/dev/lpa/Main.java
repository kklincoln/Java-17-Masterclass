package dev.lpa;
//creating a grocery list


import java.util.ArrayList;
import java.util.Arrays;

//create a record not a class that can be used for the grocery item
record GroceryItem(String name, String type, int count){
//default constructor is created with all field
//custom constructor for count of 1
    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }
//    create a toString method to override the default, simplifying the output of the records
    @Override
    public String toString(){
        return String.format("%d %s in %s", count, name.toUpperCase(), type); // int , string, in string
    }

}

public class Main {
    public static void main(String[] args) {
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk"); //calls explicit 1-arg constructor
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6); // calls default implicit constructor
        groceryArray[2] = new GroceryItem("oranges","PRODUCE", 5);
        //print the array
        System.out.println(Arrays.toString(groceryArray));


        // CREATE A GROCERY LIST WITH AN ARRAYLIST CLASS INSTEAD OF AN ARRAY; note: there is no fixed Size, no size needed
        //note: this one provides the error because it allows any object type to be added to the ArrayList, not good practice
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt"); //this is not correct, we don't want different types for records
        System.out.println(objectList);

        // specify the expected input to enforce that expactation on new line creation
        //the <GroceryItem> is telling the ArrayList what all records should expect as type.
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
//        groceryList.add("Yogurt"); // this line shows how the Literal String could not be passed
        groceryList.add(new GroceryItem("Yogurt"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("Oranges", "PRODUCE", 5));
        groceryList.set(0, // index 0 specification indicates where the new record addition will be placed, instead of end
                new GroceryItem("Apples","PRODUCE", 7)); //set record will replace whatver is at index 0
        groceryList.remove(1); //removes yogurt
        System.out.println(groceryList);

    }
}
