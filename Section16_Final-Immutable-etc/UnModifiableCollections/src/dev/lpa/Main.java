package dev.lpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /// TESTING
        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill struggles with generics.");

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        //list of the new students
        List<Student> students = new ArrayList<>(List.of(bob, bill));
        //create a copy of the arrayList; shallow copy
        List<Student> studentsFirstCopy = new ArrayList<>(students);
        ///when using copyOf we get a copy of the original list; changes to original list thereafter have no effect on the copy
        List<Student> studentsSecondCopy = List.copyOf(students);
        ///when using unmodifiableList() changes to the original will carry over to this unmodifiable VIEW of the list, not a copy.
        List<Student> studentsThirdCopy = Collections.unmodifiableList(students);


        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder())); //first list is unchanged, but firstCopy has this
//        studentsThirdCopy.set(0, new Student("Bonnie", new StringBuilder())); // List.copyOf() makes the list unmodifiable; adding, reassigning, etc.
        studentsFirstCopy.sort(Comparator.comparing(Student::getName));    //sort on comparator studentName; UNSUPPORTED, CANNOT SORT IMMUTABLE COLLECTION
        students.add(new Student("Bonnie", new StringBuilder()));

        bobsNotes.append("Bob was one of my first students");

        //because Student isn't immutable, we can change bonnie's notes after the construction and this will affect the list
        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();    //variable = studentNotes from index 2
        bonniesNotes.append("Bonnie's notes have been amended after creation, since Student is mutable");


        students.forEach(System.out::println);
        System.out.println("-".repeat(20));
        studentsFirstCopy.forEach(System.out::println); //the notes are in the copy as well, even though the copy was made before notes.append
        System.out.println("-".repeat(20));
        studentsSecondCopy.forEach(System.out::println);
        System.out.println("-".repeat(20));
        studentsThirdCopy.forEach(System.out::println);
        System.out.println("-".repeat(20));

    }

}
