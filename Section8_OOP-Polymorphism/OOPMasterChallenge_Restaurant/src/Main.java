public class Main {
    public static void main(String[] args) {

        //test a coke
//        Item coke = new Item("DRINK", "coke", 1.50);
//        coke.printItem(); // prints size name : price
//        coke.setSize("LARGE");
//        coke.printItem();
//        //test a topping
//        Item avocado = new Item("Topping","avocado", 1.50);
//        avocado.printItem();
//
//        //test create a burger with extra toppings
//        Burger burger = new Burger("Testing", 3.5);
//        burger.addToppings("BACON","CHEESE","AVOCADO"); //should add a total of 3.5 given the prices in Burger.java
//        burger.printItem();

// testing default MealOrder
//        MealOrder mealTest = new MealOrder();
//        mealTest.printItemizedList();
//        mealTest.getTotalPrice();
//testing MealOrder plus toppings and new drink size
//        MealOrder secondMeal = new MealOrder("XXL BURGER", "COKE","FRIES");
//        secondMeal.setDrinkSize("LARGE");
//        secondMeal.addBurgerToppings("AVOCADO","BACON","CHEESE");
//        secondMeal.printItemizedList();
//        secondMeal.getTotalPrice();
// create a meal with a deluxe burger where all items, drink, side item, and +5 toppings included in burger price
        MealOrder deluxeMeal = new MealOrder("DELUXE","7-UP","POTATO");
        deluxeMeal.setDrinkSize("SMALL");
        deluxeMeal.addBurgerToppings("AVOCADO","BACON","PEPPERCHINIS","JALAPENOS","MUSHROOMS");
        deluxeMeal.printItemizedList();
        deluxeMeal.getTotalPrice();



    }
}
