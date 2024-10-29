package dev.lpa.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {
// ATTRIBUTES OF THE MEAL CLASS
    private double price = 5.0;
    private Burger burger;    //calling the inner class of Item for these variable types
    private Item drink;
    private Item side;

    private double conversionRate;

    // no args constructor
    public Meal() {
        this(1); //1 so there is no conversion
    }

    //constructor outer class
    public Meal(double conversionRate){
        this.conversionRate = conversionRate;
        burger = new Burger("regular");
        drink = new Item("coke", "drink",1.5);
        System.out.println(drink.name); //demonstrates how the enclosing Meal class has direct access to Item's attributes w/o getters/setters
        side = new Item("fries", "side", 2.0);
    }

    //get total method
    public double getTotal(){
        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate); //call the i
    }


    //TOSTRING METHOD FOR THE MEAL CLASS
    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total Due: ", getTotal());
    }

    public void addToppings(String... selectedToppings){
        burger.addToppings(selectedToppings);
    }

//------------------------------------INNER CLASS: ITEM----------------------------------------------------------//
    //PRIVATE INNER CLASS; it's not static and it's declared as a class member.
    private class Item{
        private String name;
        private String type;
        private double price;

        //constructor for this inner class
        public Item(String name, String type) {//call the other constructor using default value for price
            // assigning the base price (a private field on the enclosing Meal class, directly to an attribute in inner class)
            // this shows that the inner class has direct access to the outer class's attributes, even private ones.
            this(name,type,type.equalsIgnoreCase("burger") ? Meal.this.price : 0);
        }
        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        //override the toString method
        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate)); //pass the price through the conversion method before returning
        }

        // method to convert across currency types
        private static double getPrice(double price, double rate){
            return price * rate;
        }
    }

    //------------------------------------INNER CLASS: BURGER----------------------------------------------------------//
// create another inner class, Burger; this should be a specialized item, and should also include a list of toppings, also items;
    // items have a name, type, price, and methods to convert prices. Allow a user to add toppings using the Meal class, which should
    // delegate to its burger class. Allow toppings to be added with a method that allows for variable # of Strings to be entered, representing
    // the toppings selected. Allow pricing differences between toppings. Print toppings along with burger info
    public class Burger extends Item{
        //dont need to include name,type,price fields (gathered from Item)
        //set up an enum, containing valid toppings for burgers
        enum Extra {AVOCADO, BACON, CHEESE, KETCHUP, BBQ, MUSHROOM, JALAPENOS;
            private double getPrice(){
                return switch (this){ //When getPrice is called, it's done on an instance of the enums, so we can use: this
                    case AVOCADO -> 1.0;
                    case BACON, CHEESE, MUSHROOM, JALAPENOS -> 0.5;
                    default -> 0;
                };
            }
        }

        private List<Item> toppings = new ArrayList<>();//add ArrayList for the toppings

        //CONSTRUCTOR: super constructor for item, passing name
        Burger(String name) {
            super(name, "burger",5.00);
        }

        //GETTER: PRICE; allows for the getTotal() method above to pull the price information
        public double getPrice(){
            double total = super.price; //gets the burger's set price without toppings
            //loop through the toppings and add to the total
            for (Item topping : toppings){
                total += topping.price; //add price of topping to total
            }
            return total;
        }

        //ADD TOPPINGS METHOD
        private void addToppings(String... selectedToppings){
            //print out the toppings
            for (String newTopping : selectedToppings){
                //try - catch block to check if the topping exists
                try{
                    Extra topping = Extra.valueOf(newTopping.toUpperCase());//change case to uppercase, find match in enum?
                    toppings.add(new Item(topping.name(),"TOPPING",
                            topping.getPrice()));// add topping price to the total, using the enum method of getPrice
                }catch (IllegalArgumentException ie){//catch the error associated with the illegal argument
                    System.out.println(newTopping + " is not an available topping.");
                }
            }
        }

        //TOSTRING() for burger
        @Override
        public String toString(){
            StringBuilder itemized = new StringBuilder(super.toString()); //StringBuilder because of the varying number of toppings added
            //enhanced for loop, adding each incremental topping
            for (Item topping : toppings){
                itemized.append("\n");//new line
                itemized.append(topping); //add to itemized
            }

            return itemized.toString();
        }
    }

}
