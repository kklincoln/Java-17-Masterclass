package dev.lpa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five,
                    (val == 0 ? "==": (val < 0) ? "<" : ">"),
                    i,
                    val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear","BANANA"};

        for (String s : fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana,
                    (val == 0 ? "==": (val < 0) ? "<" : ">"),
                    s,
                    val);
        }
// sort the arrays of strings before explaining why the pear and BANANA return -14, 32 respectively instead of -1, 1
        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));
// demonstrate the values associated with the respective letters;
// we are really comparing the int values on the characters in the strings. return the difference between the consecutive
// character's underlying int values. Comparing banana to pear, we compare 98 to 112, returning -14
        System.out.println("A:" + (int)'A' + " " + "a:" + (int)'a');
        System.out.println("B:" + (int)'B' + " " + "b:" + (int)'b');
        System.out.println("P:" + (int)'P' + " " + "p:" + (int)'p');



        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"), new Student("Ann") };
        //compareTo
        Arrays.sort(students); // class Student could not be cast to comparable, unless you implement comparable
        System.out.println(Arrays.toString(students));
        System.out.println("Result = " + tim.compareTo(new Student("TIM")));

    // to use the studentGPAComparator, the Arrays.sort method has an overloaded version that takes a comparator as the second arg
        Comparator<Student> gpaSorter = new studentGPAComparator();
        Arrays.sort(students, gpaSorter); //sort students, overload with the gpaSorter
        System.out.println(Arrays.toString(students));

    }
}

//create a class that implements Comparator (for instances of wanting to compare the GPA rather than student ID)
class studentGPAComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2){
        //compare GPA, but sort alphabetically in case of tie
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}



class Student implements Comparable<Student> {

    private static int LAST_ID = 1000; //static because they're only needed inside student
    private static Random random = new Random();
    String name;
    private int id;
    protected double gpa; //protected allows for subtypes of Student outside of the dev.lpa package access as well

    //constructor
    public Student(String name) {
        this.name = name;
        id = LAST_ID++; //increment from the last_D used (the static field created)
        gpa = random.nextDouble(1.0, 4.0); // random double (the static field created) between the range 1-4
    }

    @Override
    public String toString() {
        //print all the fields
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    //adjust the compareTo method to use the student ID
    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }

    //override comparable, default method to allow for comparison
//    @Override
//    public int compareTo(Object o) {
//        // cast o, which was passed to the method, as Student. Assign it to Student var called other
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }
}
