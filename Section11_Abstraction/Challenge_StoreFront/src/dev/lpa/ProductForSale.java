package dev.lpa;

//also create a ProductForSale class, that should have at least three fields: type, price, and description with methods to:
public abstract class ProductForSale {
    // three types have protected access modifiers so all subclasses can access and modify them directly
    protected String type;
    protected double price;
    protected String description;

    //generate constructor
    public ProductForSale(String type, double price, String description){
        this.type = type;
        this.price = price;
        this.description = description;
    }

    //    getSalesPrice, a concrete method, taking quantity, and returns quantity * price
    public double getSalesPrice(int quantity){
        return quantity * this.price;
    }

    //    printPricedItem, a concrete method, which takes a quantity, and should print an itemized line item for an order,
    //    with qty and line-item price
    public void printPricedItem(int quantity){
        //integer of 2 digits //decimal printed with precision of 2, total width 8 // left-justified 15 spaces // LJ 35spaces
        System.out.printf("%2d qty at $%8.2f each, %-15s %-35s %n", quantity, price, type, description);
    }

    //    showDetails, an abstract method, which represents what might be displayed on a product page.
    //    Product type, description, price, etc.
    public abstract void showDetails();
}
