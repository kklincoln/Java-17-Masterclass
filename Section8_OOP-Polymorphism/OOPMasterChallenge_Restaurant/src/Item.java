public class Item {
    // should have at least a type and price (varies by size)
    // establish fields for side item
    private final String type;
    private final String name;
    private final double price;
    private String size = "MEDIUM"; //size defaults to medium

    // create side item constructor
    public Item(String type, String name, double price){
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = price;
    }

    //create side item methods
    public String getName() {
        if(type.equals("SIDE") || type.equals("DRINK")){
            return size + " " + name;
        }
        return name;
    }
    ///////////
    public double getBasePrice() {
        return price;
    }
    ////////////
    public double getAdjustedPrice(){
        return switch (size){
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    //create setter/getter methods if applicable
    public void setSize(String size){
        this.size = size;
    }

    /////////////// these two methods get overridden for any subclasses.
    public static void printItem(String name, double price){
        System.out.printf("%20s:%6.2f%n", name, price); //reserve 20 char for %s, reserve 6 and .00 char for second
    }
    public void printItem(){
        printItem(getName(),getAdjustedPrice());
    }

}
