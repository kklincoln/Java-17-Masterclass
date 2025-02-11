package dev.lpa;

import java.util.Arrays;

record Person (String name, String dob, Person[] kids){
    /// custom constructor for a deep copy
    public Person(Person p) {
        //have to call the conanonical or generated constructor
        this(p.name, p.dob,
                p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }




    @Override
    public String  toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}
public class Main {

    public static void main(String[] args) {
    /// CREATE INSTANCES OF PERSON
        Person joe = new Person("Joe" , "01/01/1961", null);
        Person jim = new Person("Jim" , "02/02/1962", null);
        Person jack = new Person("Jack" , "03/03/1963",
                new Person[]{joe, jim});
        Person jane = new Person("Jane" , "04/04/1964", null);
        Person jill = new Person("Jill" , "05/05/1965",
                new Person[]{joe, jim});

        /// create an array of these persons
        Person[] persons = {joe, jim, jack, jane, jill};
        //create a shallow copy of the array. A deep copy would be unnecessary since there's no way to mutate these Records
        //        Person[] personsCopy = Arrays.copyOf(persons, persons.length);
        ///create a shallow copy with the clone()
        Person[] personsCopy = persons.clone();

///CREATE A DEEP COPY INSTEAD
//        Person[] personsCopy = new Person[5];
///instead of the forLoop below, use Arrays.setAll()
//        Arrays.setAll(personsCopy, i -> new Person(persons[i])); //instantiate a new person and place at the same index in Copy[]

//        for (int i =0; i < 5; i++){
//            personsCopy[i] = new Person(persons[i]);   //instantiate a new person and place at the same index in Copy[]
//        //note: the for loop below only prints records if the references in the arrays are the same. Since this forLoop instantiates new Records,
//        //They are no longer the same, so nothing will print from the "Equal References" forLoop
//        }


    ///DEMONSTRATING SHALLOW COPIES ARE MUTABLE; THIS COULD CAUSE REAL PROBLEMS. see the arrays change for Jill's kids
        var jillsKids = personsCopy[4].kids();
        jillsKids[1] = jane;

        //confirm that both arrays are referencing the same records
        for (int i = 0 ; i < 5; i++){
            if (persons[i] == personsCopy[i]){
                System.out.println("Equal References " + persons[i]);
            }
        }
        //confirms the data is the same.
        //NOTE: we enforced the Deep copy depth with the line 35 ternary statement on var kids. (replaced by the custom constructor on Person Record)
        // Original Array wasn't changed, only the copy
        System.out.println(persons[4]);
        System.out.println(personsCopy[4]);


    }

}
