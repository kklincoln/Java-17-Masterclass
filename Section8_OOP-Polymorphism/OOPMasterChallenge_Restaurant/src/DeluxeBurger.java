public class DeluxeBurger extends Burger{
//create deluxeBurger meal: deluxe burger with set price, any addtl toppings don't change price. room for +2 toppings
    //establish fields for DeluxeBurger
    private Item deluxe1;
    private Item deluxe2;

    // create DeluxeBurger constructor
    public DeluxeBurger(String name, double price) {
        super(name, price);
    }

    //create setter/getter methods if applicable
//create DeluxeBurger methods
    //override methods for add toppings and print itemized list
    public void addToppings(String extra1, String extra2, String extra3, String extra4, String extra5) {
        super.addToppings(extra1, extra2, extra3);
        deluxe1 = new Item("TOPPING",extra4,0.0);
        deluxe2 = new Item("TOPPING", extra5, 0.0);
    }

    @Override
    public void printItemizedList() {
        super.printItemizedList();
        if (deluxe1 != null){
            deluxe1.printItem();
        }
        if (deluxe2 != null){
            deluxe2.printItem();
        }
    }
    //override the getExtraPrice on burgers method because all toppings are included
    @Override
    public double getExtraPrice(String toppingName) {
        return 0.0;
    }
}
