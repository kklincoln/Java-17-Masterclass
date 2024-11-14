package dev.lpa;

public class InventoryItem {
    ///FIELDS
    private Product product;    //record; immutable
    private double price;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder; //qty reordered if low threshold is reached
    private int qtyLow;     //qty threshold that triggers a reorder

    ///CONSTRUCTORS
    public InventoryItem(Product product, double price, int qtyTotal, int qtyLow) {
        this.product = product;
        this.price = price;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.qtyReorder = qtyTotal;
    }

    ///GETTERS
    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    ///METHODS
    public boolean reserveItem(int qty){
        // if the total - qty reserved in other people's carts is still greater than the qty requested.
        if ((qtyTotal - qtyReserved) >= 0 ){
            qtyReserved += qty;
            return true;
        }
        return false;
    }

    public void releaseItem(int qty){
        //shopper removes item from cart or when the cart is abandoned
        qtyReserved -=qty;
    }

    public boolean sellItem(int qty){
        if (qtyTotal >= qty){
            qtyTotal -= qty;
            qtyReserved -= qty;
            if (qtyTotal <= qtyLow){
                //if stock falls below threshold, replenish
                placeInventoryOrder();
            }
            return true;
        }
        return false;
    }

    public void placeInventoryOrder(){
        System.out.printf("Ordering qty %d : %s%n", qtyReorder, product);
    }

    ///TOSTRING
    @Override
    public String toString() {
        return "%s, $%.2f : [%04d, % 2d]".formatted(product, price, qtyTotal, qtyReserved);
    }
}
