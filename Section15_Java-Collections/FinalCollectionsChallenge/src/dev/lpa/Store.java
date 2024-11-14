package dev.lpa;

import java.time.LocalDate;
import java.util.*;

public class Store {

    private static Random random = new Random();    // will be used to assign random prices later
    private Map<String, InventoryItem> inventory;   // map, keyed by the SKU
    // navigableSet methods to look for abandoned carts later
    private NavigableSet<Cart>  carts = new TreeSet<>(Comparator.comparing(Cart::getId));   //ordered by cartID
    private Map<Category, Map<String, InventoryItem>> aisleInventory; // searching for items through Aisles, then a product name/desc


    public static void main(String[] args) {
        /// TESTING INSTANTIATION, STOCK, LISTINVENTORY
        Store myStore = new Store();
        myStore.stockStore();
        myStore.listInventory();
        System.out.println("-".repeat(20));

        /// STOCKAISLES & LISTINVENTORY
        myStore.stockAisles();
        myStore.listProductsByCategory(false, true);
        System.out.println("-".repeat(20));

        /// MANAGESTORECARTS
        myStore.manageStoreCarts();
        myStore.listProductsByCategory(false, true);
        myStore.carts.forEach(System.out::println);

        /// DELETE ABANDONED CARTS
        // this will demonstrate the removal of carts that arent of today's date; reserve quantities also reset to zero for the old carts
        myStore.abandonCarts();
        myStore.listProductsByCategory(false, true);
        myStore.carts.forEach(System.out::println);

    }


    private void manageStoreCarts(){
        //create cart instance
        Cart cart1 = new Cart(Cart.CartType.PHYSICAL,1);    // yesterday's cart
        carts.add(cart1);
        //create an instance of an item from: Aisle.get(Category).get(product)
        InventoryItem item = aisleInventory.get(Category.PRODUCE).get("apple");
        cart1.addItem(item, 6);
        cart1.addItem(aisleInventory.get(Category.PRODUCE).get("pear"), 5);
        System.out.println(cart1);

        //remove items, 2 pears
        cart1.removeItem(aisleInventory.get(Category.PRODUCE).get("pear"), 2);
        System.out.println(cart1);

        //VIRTUAL CARTS
        Cart cart2 = new Cart(Cart.CartType.VIRTUAL, 1); // 1 day old cart
        carts.add(cart2);
        cart2.addItem(inventory.get("L103"), 20);   //get items via SKU (20 lemons)
        cart2.addItem(inventory.get("B100"), 10);   // 10 bananas
        System.out.println(cart2);

/// note that the code for cart3 trigggers the reorder of new rice chex, due to this order
        Cart cart3 = new Cart(Cart.CartType.VIRTUAL, 0);
        carts.add(cart3);
        cart3.addItem(inventory.get("R777"), 998);  ///should trigger low threshold count
        System.out.println(cart3);
        if(!checkOutCart(cart3)){
            System.out.println("Something went wrong, could not check out.");
        }

        Cart cart4 = new Cart(Cart.CartType.PHYSICAL, 0);
        carts.add(cart4);
        cart4.addItem(aisleInventory.get(Category.BEVERAGE).get("tea"),1);
        System.out.println(cart4);
    }

    private boolean checkOutCart(Cart cart){
        //get a view: the entrySet of the products in the cart and loop through each
        for (var cartItem : cart.getProducts().entrySet()){
            //getKey (productSKU) and getValue (qty)
            var item = inventory.get(cartItem.getKey());
            int qty = cartItem.getValue();
            // check the sellItem on every InventoryItem in the cart, if successful it returns true. otherwise you get this error
            if (!item.sellItem(qty)) return false;
        }
        cart.printSalesSlip(inventory);
        carts.remove(cart);
        return true;
    }

    private void abandonCarts(){
        //any cart that doesn't have today's date
        int dayOfYear = LocalDate.now().getDayOfYear();
        Cart lastCart = null;   //sets to a date that's not = todays date

        for (Cart cart : carts){
            //check each cart in the carts inventory. break loop if cart's date is today; these are ordered by date already
            if (cart.getCartDate().getDayOfYear() == dayOfYear) {
                break;
            }
            lastCart = cart;    // will serve as the 'splice point' for cutting the carts with headSet
        }
        var oldCarts = carts.headSet(lastCart, true);   //create a Set of carts that include lastCart and prior
        Cart abandonedCart = null;
        while ((abandonedCart = oldCarts.pollFirst()) != null){         // pollFirst removes the cart from the view, oldCarts, and also the source, Carts
            for (String sku : abandonedCart.getProducts().keySet()){    // loop through each of the Product SKUs within the currently iterated Cart
                InventoryItem item = inventory.get(sku);                // Instantiate an InventoryItem using the sku from cart
                item.releaseItem(abandonedCart.getProducts().get(sku)); // removes item from cart, using the sku from the abandonedCart
            }
        }
    }

    private void listProductsByCategory(){
        listProductsByCategory(true, false);
    }

    private void listProductsByCategory(boolean includeHeader, boolean includeDetail){
        //print the products from the aisleInventories
        aisleInventory.keySet().forEach(k ->{
            if (includeHeader) System.out.println("------\n" + k + "\n------");
            if (!includeDetail) {
                //loop the aisle and get the Key, printing each key (Product name)
                aisleInventory.get(k).keySet().forEach(System.out::println);
            }else{
                aisleInventory.get(k).values().forEach(System.out::println);
            }
        });
    }

    /// SET UP PRODUCTS FOR THE STORE FIRST
    private void stockStore(){
        //instantiate the inventory with a hashmap
        inventory = new HashMap<>();
        //generate a list of products with the arraylist, list.of(new Product())
        List<Product> products = new ArrayList<>(List.of(
                new Product("A100","apple","local",Category.PRODUCE),
                new Product("B100","banana","local",Category.PRODUCE),
                new Product("P100","pear","local",Category.PRODUCE),
                new Product("L103","lemon","local",Category.PRODUCE),
                new Product("M201","milk","farm",Category.DAIRY),
                new Product("Y001","yogurt","farm",Category.DAIRY),
                new Product("C333","cheese","farm",Category.DAIRY),
                new Product("R777","rice chex","Nabisco",Category.CEREAL),
                new Product("G111","granola","Nat Valley",Category.CEREAL),
                new Product("BB11","ground beef","butcher",Category.MEAT),
                new Product("CC11","chicken","butcher",Category.MEAT),
                new Product("BC11","bacon","butcher",Category.MEAT),
                new Product("BC77","coke","coca cola",Category.BEVERAGE),
                new Product("BC88","coffee","value",Category.BEVERAGE),
                new Product("BC99","tea","herbal",Category.BEVERAGE)
        ));
        //loop through the list to create a new InventoryItem instance for each product and add them to the inventory Map
        products.forEach(p -> inventory.put(p.sku(), new InventoryItem(p,
                random.nextDouble(0, 1.25),1000,5  )));
    }

    ///STOCK THE AISLES OF THE STORE
    private void stockAisles(){
        //shoppers would find the aisle, then search for the product
        aisleInventory = new EnumMap<>(Category.class); //EnumMap of the Category options
        //for each item within the map: Inventory, find the aisle of the item (Enum Category), create if absent
        for (InventoryItem item : inventory.values()){
            //get the aisle for each item
            Category aisle = item.getProduct().category();
            //new local variable for the nested map, check if the aisle exists as option from the Enum Category
            Map<String, InventoryItem> productMap = aisleInventory.get(aisle);
            if (productMap == null){
                // TreeMap is a sorted collection, time complexity big O(log n) due to the red-black tree structure enabling sorting
                productMap = new TreeMap<>();
            }
            productMap.put(item.getProduct().name(), item); //add the InventoryItem, keyed by the product name
            aisleInventory.putIfAbsent(aisle,productMap);   //add the category if absent
        }
    }

    private void listInventory(){
        System.out.println("-".repeat(20));
        //loop through values of inventory and print them on their own lines.
        inventory.values().forEach(System.out::println);
    }

}
