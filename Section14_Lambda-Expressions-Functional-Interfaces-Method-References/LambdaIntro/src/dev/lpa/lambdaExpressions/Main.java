package dev.lpa.lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //CREATE AN ARRAYLIST OF TYPE STRING WITH LIST.OF TO ADD FOUR ELEMENTS
        List<String> list = new ArrayList<>(List.of(
                //add four elements
                "alpha", "bravo", "charlie", "delta" ));
        //PRINT EACH STRING WITH ENHANCED FOR LOOP
        for (String s : list){
            System.out.println(s);
        }
        System.out.println("-".repeat(20));
        //THE ARRAYLIST COMES WITH AN EASIER WAY TO PRINT EACH ELEMENT THAN THE ABOVE METHOD
        //this method takes a lambda expression, a Consumer type, which we just covered, as its argument
        list.forEach((myString) -> System.out.println(myString));

        //to include multiple statements, we need to include opening/closing curly braces around the statements
        System.out.println("-".repeat(20));
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });
        System.out.println("-".repeat(20));

        //PASS ARGUMENTS INTO THE CALCULATOR; lambda operation
        int result = calculator((var a, var b) -> a + b , 5,2);
        var result2 = calculator((a,b) -> a / b, 10.0,2.5);
        var result3 = calculator((a,b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph","Kramden");
        System.out.println("-".repeat(20));


        // CREATE A NEW LAMBDA EXPRESSION USING Consumer and BiConsumer.
        // start with creating a variable coords of double[] list.
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659});
        // loop through and print each
        //remember, this is using an enhanced for loop, looping over each in the coords list, meaning 's' is really double[]
        coords.forEach(s -> System.out.println(Arrays.toString(s)));


        //BiConsumer code  //declaring the code with the lambda expression isn't actually going to execute that expression
        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f long:%.3f]\n", lat,lng);
        //manually call the function
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0],firstPoint[1], p1); // call the lambda variable using the lat long expressions
        System.out.println("-".repeat(20));
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        //works the same, but it a bit less DRY / clean.
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lng) -> System.out.printf("[lat:%.3f long:%.3f]\n", lat,lng)));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(20));
        list.addAll(List.of("echo","easy","earnest"));
        list.forEach(s -> System.out.println(s));
        //remove any string starting with ea
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        // first method on List is replaceAll and it takes a UnaryOperator as an arg, taking one argument and returning result of same type
        // pass an array element, and get a transformed array element back.
        list.replaceAll(s -> s.charAt(0) + "-" + s.toUpperCase());
        System.out.println(" - ".repeat(20));
        list.forEach(s -> System.out.println(s));

        // THE FUNCTION INTERFACE
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.setAll(emptyStrings, (i) -> "" + (i +1) +".");
        System.out.println(Arrays.toString(emptyStrings));

        //using switch expression with lambda expression
        Arrays.setAll(emptyStrings, (i) -> "" + (i +1) +"."
         + switch(i){
            case 0-> "first";
            case 1-> "second";
            case 2-> "third";
            default ->"";
        } );
        System.out.println(Arrays.toString(emptyStrings));

        // SUPPLIER LAMBDA EXPRESSION
        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Frank"};
        String[] randomList = randomlySelectedValues(15, names,// want an array of 15 back,
                ()-> new Random().nextInt(0, names.length) ); //lambda expression with no args to rand select from length of array
        System.out.println(Arrays.toString(randomList));
    }

    //AFTER CREATING THE FUNCTIONAL INTERFACE "Operation", we create a public static generic method
    // first parameter is an instance of the functional interface, followed by the two args needed for Operation
    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        // output of result type T, passing value1 and value2 into the instance of Operation: function's method:operate
        T result = function.apply(value1, value2);
        System.out.println("Result of Operation: " + result);
        return result;
    }

    //BiConsumer functional interface; in this code, we say that they’ll be the same types, by using T,T in the angle brackets.
    // This executes code that doesn’t return a value (void) or if it does, it can be ignored.
    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }

    // SUPPLIER LAMBDA EXPRESSION
    public static String[] randomlySelectedValues(int count,    // return array of String with same number of elements passed as count
                                                  String[] values,  //use this to get a value randomly picked from this array
                                                  Supplier<Integer> s){ //uses this to get an integer to use as the index to pick the name
        String[] selectedValues = new String[count];
        for (int i =0; i < count; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }

}
