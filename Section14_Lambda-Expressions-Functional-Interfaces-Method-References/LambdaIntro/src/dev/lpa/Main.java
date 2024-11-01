package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    record Person (String firstName, String lastName){//implicitly static when used as an inner class; can access directly using Main's class name to create instances outside of this class
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        // create a list of the Person records
        List<Person> people = new ArrayList<>(Arrays.asList(
                //pass in a list of person records
                new Main.Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Charlie", "Brown"),
                new Person("Peppermint", "Patty")
        ));

        // using anonymous class to compare two input instances of Person
        var comparatorLastName = new Comparator<Person>(){
            //generate an override to compare people by lastName
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };
        //SORT THE LIST WITH THE ANONYMOUS INSTANCE OF THE COMPARATOR INTERFACE
        //generate an override to compare people by lastName
        // when you copy and paste the expression from line 29 into sort() it gives the option to replace with lambda expression
        people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        //
        System.out.println(people);

        // CREATE A LOCAL INTERFACE THAT EXTENDS COMPARATOR.
        interface EnhancedComparator<T> extends Comparator<T>{
            //one abstract method that takes two arguments
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>(){
            //implement the two abstract methods when instantiating the new EnhancedComparator method
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result); // if they're equal, send to second level comparator
            }
            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };
        //SORT THE PEOPLE LIST USING THIS NEW VARIABLE COMPARATORMIXED
        people.sort(comparatorMixed);
        System.out.println(people);
    }
}
