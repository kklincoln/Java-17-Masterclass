package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ///CREATE A STRING
        String name = "tim";
        ///CREATE A FUNCTION W/ TWO STRING TYPES CALLED UCASE
        Function<String, String> uCase = String::toUpperCase;
        //pass the name into uCase using the apply() method
        System.out.println(uCase.apply(name));

        ///SECOND FUNCTION TO APPEND LAST NAME TO STRING
        Function<String, String> lastName = s -> s.concat(" Buchalka");
        Function<String,String> uCaseLastName = uCase.andThen(lastName); //processes uCase() and then it processes lastName()
        System.out.println(uCaseLastName.apply(name));

        ///compose is the opposite of andThen; it executes lastName() first and then executes the uCase()
        //compose is only available to lambda expressions targeting a Function, or a UnaryOperator interface.
        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        ///NOTE: Chained lambdas or method references don't need to return all the same types within the chain
        Function<String, String[]> f0 = uCase   //input type string, but final result is array of strings
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "));    //this one returns a string array
        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String, String> f1 = uCase   //input type string, but final result is array of strings
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() +", " + s[0]);
        System.out.println(f1.apply(name));

        Function<String, Integer> f2 = uCase   //input type string, but final result is array of strings
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        System.out.println(f2.apply(name));


        ///Consumer doesnt return any data, so whatever the input at the start of the chain will remain the type at the end of the chained expressions
        String[] names = {"Bob", "Ann", "Carol"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0)); //print first char of string
        Consumer<String> s1 = System.out::println; // prints the entire name on new line
        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1));



        /// PREDICATE TESTING EXAMPLES
        Predicate<String> p1 = s -> s.equals("TIM");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");
        Predicate<String> p3 = s -> s.startsWith("T");
        Predicate<String> p4 = s -> s.endsWith("e");

        Predicate<String> combined1 = p1.or(p2);    //checks one of the Predicate conditions above
        System.out.println("combined1 = " + combined1.test(name));
        Predicate<String> combined2 = p3.and(p4); // checks if BOTH predicate conditions are true
        System.out.println("combined2 = " + combined2.test(name));
        //if we want the opposite of a test
        Predicate<String> combined3 = p3.and(p4).negate(); // negate() returns the opposite result of whatever was prefixed
        System.out.println("combined3 = " + combined3.test(name));



        ///DEMONSTRATING THE COMPARATOR METHODS
        record Person(String firstName, String lastName){}
        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter","Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie","Mouse"),
                new Person("Mickey", "Mouse")
        ));
        //sort list and print each from list
        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);
        System.out.println("-".repeat(20));
        //cleaner sort with Comparator.comparing()
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("-".repeat(20));
        //cleaner sort with Comparator.comparing()
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);
    }
}
