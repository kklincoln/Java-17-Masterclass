package dev.lpa;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    /// FIELDS
    enum CartType {PHYSICAL, VIRTUAL};
    private static int lastId = 1;      //generate unique cartID
    private int id;
    private LocalDate cartDate;
    private CartType type;
    private Map<String, Integer> products;  //name, productSKU

    ///CONSTRUCTORS
    public Cart(CartType type, int days) {  //extra argument adjust the dates by a few days to test abandon cart
        this.type = type;
        id = lastId++; //increment cartID
        cartDate = LocalDate.now().minusDays(days);
        products = new HashMap<>();
    }
    public Cart(int id) {
        this.id = id;
    }

    /// GETTERS
    public int getId() {
        return id;
    }
    public LocalDate getCartDate() {
        return cartDate;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    ///METHODS
    public void addItem(InventoryItem item, int qty){
        // if the item is in the Map, it will add qty to the current quantity; else, insert new entry with qty
        products.merge(item.getProduct().sku(), qty, Integer::sum);
        //reserve the item
        if(!item.reserveItem(qty)){
            System.out.println("Something went wrong, could not add the item!");
        }
    }

    public void removeItem(InventoryItem item, int qty){
        int current = products.get(item.getProduct().sku());
        if (current <= qty){
            // if the current amount is less than the amount we intend to remove, we cant so only remove the amt that's current
            qty = current;  //set qty = max amount of current item
            products.remove(item.getProduct().sku());   //remove item from the Map
            System.out.printf("Item [%s] removed from the basket%n", item.getProduct().name());
        }else{
            //if the shopper had 5 items and wanted to put back 2:
            products.merge(item.getProduct().sku(), qty,
                    (oldVal, newVal)-> oldVal - newVal);
            System.out.printf("%d [%s]s removed%n", qty, item.getProduct().name());
        }
        //call releaseItem to change the reserve amount with the qty from above
        item.releaseItem(qty);
    }

    public void printSalesSlip(Map<String, InventoryItem> inventory){
        double total = 0;   //establish total value placeholder
        System.out.println("-".repeat(20));
        System.out.println("Thank you for your sale: ");

        for (var cartItem : products.entrySet()){
            // loop through the products Map, for each cartItem, get the Key
            var item = inventory.get(cartItem.getKey());
            int qty = cartItem.getValue();
            double itemizedPrice = (item.getPrice() * qty);
            total =+ itemizedPrice;
            System.out.printf("\t%s %-10s (%d)@ $%.2f = $%.2f%n", cartItem.getKey(), item.getProduct().name(),qty
                    ,item.getPrice(), itemizedPrice);
        }
        System.out.printf("Total Sale: $%.2f%n", total);
        System.out.println("-".repeat(20));

    }

    ///TOSTRING
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartDate=" + cartDate +
                ", products=" + products +
                '}';
    }
}
