// should be comprised of one burger, one drink, and one side item;
// for each mealOrder:
// add some toppings to the burger
//change the size of the drink
//print the itemized list (inc: price of burger, extra toppings, drink based on size, and side item price)
//print total due amount for meal
public class MealOrder {
    private Burger burger;
    private Item drink;
    private Item side;

    //create no arg constructor as default meal
    // most common meal order should be created without arguments, e.g.: regular burger, small coke, fries
    public MealOrder(){
        this("regular","coke","fries"); //calls the other constructor below
    }


    //create constructor; using Strings because we don't want to pass objects, just the string to indicate the type
    // you could have used the Burger or Item classes, but this way the calling code doesn't need anything except the meal itself
    //should be able to create other meal orders by specifying different burgers, drinks, and side items
    //create a meal with a burger and the drink and side of choice, with up to 3 extra toppings.
    public MealOrder(String burgerType, String drinkType, String sideType){
        if(burgerType.equalsIgnoreCase("Deluxe")){
            this.burger = new DeluxeBurger(burgerType, 8.5); //substitute the deluxe burger and price for drink+Side
        }else{
            this.burger = new Burger(burgerType, 4.00);
        }
        this.drink = new Item("DRINK",drinkType, 1.00);
        this.side = new Item("SIDE", sideType, 1.50);
    }

    public double getTotalPrice(){
        if (burger instanceof DeluxeBurger){
            return burger.getAdjustedPrice(); // if deluxe burger, only print the price of the deluxe burger
        }
        return side.getAdjustedPrice() +
                drink.getAdjustedPrice() +
                burger.getAdjustedPrice();
    }
    public void printItemizedList(){
        burger.printItem();
        if (burger instanceof DeluxeBurger){ //change prices of drink and side to 0
            Item.printItem(drink.getName(),0);
            Item.printItem(side.getName(), 0);
        }else{
            drink.printItem();
            side.printItem();
        }
        System.out.println("-".repeat(30));
        Item.printItem("TOTAL PRICE",getTotalPrice()); //using the static method from item to print the total price
    }

    // create a method to add toppings to the burger, which is really just a pass-through to the addToppings method on burger
    public void addBurgerToppings(String extra1, String extra2, String extra3){
        burger.addToppings(extra1, extra2,extra3);
    }
    //create method to allow for up to five toppings
    public void addBurgerToppings(String extra1, String extra2, String extra3,
                                  String extra4, String extra5){
        if (burger instanceof DeluxeBurger db){ //binding variable used to avoid necessary casting for db.addTopings method
            db.addToppings(extra1, extra2, extra3, extra4, extra5);
        }else{
            burger.addToppings(extra1,extra2,extra3);
        }
    }

    // add a set Drink size for the burger method
    public void setDrinkSize(String drinkSize){
        drink.setSize(drinkSize);
    }
}
