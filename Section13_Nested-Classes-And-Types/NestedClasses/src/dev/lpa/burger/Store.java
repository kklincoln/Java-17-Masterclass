package dev.lpa.burger;

//used for testing the Burger code from Meal class
public class Store {
    public static void main(String[] args) {

        Meal regularMeal = new Meal();
        regularMeal.addToppings("mushroom", "bbq","Bacon", "pepperjack");
        System.out.println(regularMeal);

        //in a real application, we would use an API service to get the realtime conversion rate at time of service
        Meal USRegularMeal = new Meal(0.68); //convert from AUD to USD
        System.out.println(USRegularMeal);
    }
}
