package dev.lpa.model;

import dev.lpa.util.QueryItem;

import java.util.Random;

//implement the QueryItem interface and Comparable class argument against type Student
public class Student implements QueryItem, Comparable<Student> {
    private static int LAST_ID = 10_000; //keep track of the previous id
    private int studentID;
    private String name;
    private String course;
    private int yearStarted;
    //I want three more fields which I'll use to create random data for a set of Students.
    protected static Random random = new Random();
    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};

    //create constructor, no args, since all student data will get generated
    public Student(){
        this.studentID = LAST_ID++;
        int lastNameIndex = random.nextInt(65, 91); //65 is int for 'A' 90 is value for 'Z', use 91 as non inclusive
        this.name = firstNames[random.nextInt(5)] + " " + (char)lastNameIndex; //of the 5 names, randomly select next int
        this.course = courses[random.nextInt(3)];//of the 3 courses, randomly choose
        this.yearStarted = random.nextInt(2018, 2025);
    }

    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentID, name, course, yearStarted); //-15s is left-justified
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchField(String fieldName, String value) {
        // use switch expression to check each field name that we want to be searchable
        String fName  = fieldName.toUpperCase();

        return switch(fName){
            //filter the student list, checking any passed fieldName against the value
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        //adjust the method to compare the student ids
        return Integer.valueOf(studentID).compareTo(o.studentID);
    }
}
