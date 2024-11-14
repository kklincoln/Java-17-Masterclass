package dev.lpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// RECORDS for course and course purchase
record Course(String courseId, String name, String subject){}
record Purchase(String courseId, int studentId, double price, int yr, int dayOfYear){
    public LocalDate purchaseDate(){
        return LocalDate.ofYearDay(yr, dayOfYear); //will be using this date as a key in the map.
    }
}


/// STUDENT CLASS
public class Student {
    public static int lastId =1;    //we want an ID assigned as part of the construction of the object, so the LastID used gets stored
    private String name;
    private int id; //auto assigned when using the static lastId when the new instance is created
    private List<Course> courseList;

    ///CONSTRUCTORS
    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courseList = courses;
        this.id = lastId++;
    }
    public Student(String name, Course course) {
        this(name, new ArrayList<>(List.of(course)));   //new arrayList created including the course name
    }

    ///GETTERS
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    /// METHOD TO ADD A COURSE
    public void addCourse(Course course){
        courseList.add(course );
    }

    /// TOSTRING
    @Override
    public String toString() {
        String[] courseNames = new String[courseList.size()]; //store the course names in an array the same size as the CourseList
        Arrays.setAll(courseNames, i -> courseList.get(i).name()); //get name from each index to populate the array
        return "[%d] : %s".formatted(id, String.join(", ", courseNames)); // return a comma delimited list
    }
}
