public class Burger extends Item{ //extends item so it can inherit name and price
//every hamburger should have a burger type, base price, and up to max of 3 extra toppings
    //establish fields for Burger; these will have type of Item, price inherited from Item
    private Item extra1;
    private Item extra2;
    private Item extra3;


    // create Burger constructor; should only include burger type and price, somehow add extra toppings and priced by type
    //since no extras are selected by default, we just want to create a constructor for the inheritance from super
    public Burger(String name, double price) {
        super("Burger", name, price);
    }
//create Burger methods
    @Override
    public String getName() {
        return super.getName() + " BURGER"; // THE TYPE WILL INDICATE SPECIFIC TYPE OF BURGER
    }
    @Override
    public double getAdjustedPrice() { // price of each extra item is added to base price
        return getBasePrice() +
                ((extra1 == null) ? 0 : extra1.getAdjustedPrice()) +
                ((extra2 == null) ? 0 : extra2.getAdjustedPrice()) +
                ((extra3 == null) ? 0 : extra3.getAdjustedPrice());
    }

    // calculate the price of whatever the extra topping is
    public double getExtraPrice(String toppingName){
        return switch (toppingName.toUpperCase()){
            case "JALAPENO", "PEPPERCHINI", "MUSHROOM" -> 0.5;
            case "AVOCADO", "CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default -> 0.0;
        };
    }
    //then add the price together
    public void addToppings(String extra1, String extra2, String extra3){
        this.extra1 = new Item("TOPPING", extra1, getExtraPrice(extra1));
        this.extra2 = new Item("TOPPING", extra2, getExtraPrice(extra2));
        this.extra3 = new Item("TOPPING", extra3, getExtraPrice(extra3));
    }

    public void printItemizedList(){
        printItem("BASE BURGER", getBasePrice());
        if (extra1 != null) {
            extra1.printItem();
        }if (extra2 != null) {
            extra2.printItem();
        }if (extra3 != null) {
            extra3.printItem();
        }
    }

    //print an itemized list for Burger printItem. overriding the Item printItem method
    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }

    //create setter/getter methods if applicable
    //create deluxeBurger meal: deluxe burger with set price, any addtl toppings don't change price.

}
