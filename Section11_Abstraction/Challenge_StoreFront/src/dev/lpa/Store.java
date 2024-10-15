//in this challenge, you  need to build an application that can be a store front for any item imaginable for sale.
//instead of the main class, create a Store class with a main method. The store class should:
//    manage a list of products for sale, including displaying the product details
//    manage an order, which can just be a list of OrderItem objects
//    have methods to add an item to the order and print the ordered items so it looks like a sales receipt

//also create a ProductForSale class, that should have at least three fields: type, price, and description with methods to:
//    getSalesPrice, a concrete method, taking quantity, and returns quantity * price
//    printPricedItem, a concrete method, which takes a quantity, and should print an itemized line item for an order, with qty and line-item price
//    showDetails, an abstract method, which represents what might be displayed on a product page. Product type, description, price, etc.

//also create an OrderItem type, that has a minimum 2 fields: quantity and Product for Sale
//create 2-3 classes that extend the ProductsForSale class
package dev.lpa;
import java.util.ArrayList;

//the proper real world implementation would be order class and a list of order items
record OrderItem( int quantity, ProductForSale product){}

public class Store {
//    manage a list of products for sale, including displaying the product details
    //create an ArrayList of type ProductForSale and initialize it. Any class that's a subclass of ProductForSale can be an element
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {
        //add products to the inventory list
        storeProducts.add(new ArtObject("Oil Painting",1350,
                "Impressionistic work by ABF; painted in 2010"));
        storeProducts.add(new ArtObject("Sculpture", 2000,
                "Bronze work by JKF; produced in 1950"));
        storeProducts.add(new Furniture("Desk",500, "Mohogany Desk"));
        storeProducts.add(new Furniture("Lamp", 200, "Tiffany Lamp with Hummingbirds"));

        //list the products for sale
        listProducts();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1,1,2);
        addItemToOrder(order1, 0,1);
        printOrder(order1);


        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2,3,5);
        addItemToOrder(order2, 0,1);
        addItemToOrder(order2, 2,1);

        printOrder(order2);

    }

//create a method to be called to list the items for sale within the storeProducts ListArray
    public static void listProducts(){
        for (var item : storeProducts){
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    //    have methods to add an item to the order and print the ordered items so it looks like a sales receipt
    public static void addItemToOrder(ArrayList<OrderItem> order, int productIndex, int quantity){
        // add quantity of storeProduct(orderIndex) to the ArrayList of OrderItems
        order.add(new OrderItem(quantity, storeProducts.get(productIndex)));

    }
    public static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for(var item : order){
//        for each element in the list; call the printPricedItem method from the product (ProductForSale)
            item.product().printPricedItem(item.quantity());
            // getSalesPrice for the item based on quantity and add to the total variable
            salesTotal += item.product().getSalesPrice(item.quantity());     //item.quantity taken from OrderItem record
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }
}
