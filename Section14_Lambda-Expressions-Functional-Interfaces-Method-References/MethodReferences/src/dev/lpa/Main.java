package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// using a method reference to instantiate a new instance of a class
class PlainOld{
    private static int last_id = 1;
    private int id;

    public PlainOld(){
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}


public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Anna","Bob","Chuck","Dave" ));
        list.forEach(System.out::println);

        // call to the calculator expression, two parameters (a,b) that returns a+b
        calculator(Integer::sum, 10,2); //replaces the (a,b) -> a + b,  syntax with Integer::sum
        calculator(Double::sum, 10.0,2.5);

        //CREATE A LOCAL VARIABLE, TYPE SUPPLIER
        Supplier<PlainOld> reference1 = PlainOld::new; // formerly instntiated with: () -> new PlainOld()
// it would be easier to just call 'new' on the PlainOld class when we need the instance, but later there will be instances where this will make more sense
        PlainOld newPojo = reference1.get();


        //EXECUTE THE DEFERRED METHOD INVOCATION METHOD
        System.out.println("Getting Array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 3);

        // method reference with String
        calculator((s1, s2) -> s1.concat(s2), "Hello ", "World");
        calculator(String::concat, "Hello ", "World");
        //to make this more explicitly clear
        BinaryOperator<String> b1 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> b2 = (s1, s2) -> s1.concat(s2);
        UnaryOperator<String> u1 = String::toUpperCase; //invalid to be done for UnaryOperator because there is no s2 available to it

        System.out.println(b1.apply("Hello ", "World"));
        System.out.println(b2.apply("Hello ", "World"));
        System.out.println(u1.apply("Hello"));

        //method references
        String result = "hello".transform(u1);
        System.out.println("Result = " + result);

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);

    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);

    }


    //EXAMPLE SCENARIO OF WHEN THE DEFERRED METHOD INVOCATION MAKES SENSE:
    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
