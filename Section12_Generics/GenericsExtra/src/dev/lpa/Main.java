package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.model.Student;
import dev.lpa.util.QueryItem;
import dev.lpa.util.QueryList;

import java.util.ArrayList;
import java.util.List;


//create record to test the QueryList restriction of: Student & QueryItem
record Employee(String name) implements QueryItem{
    //leave default override method
    @Override
    public boolean matchField(String fieldName, String value) {
        return false;
    }
}


public class Main {
    public static void main(String[] args) {

        //set up test cases to generate 10 random students
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0 ; i < studentCount ; i++){
            // add new instance of student to the array list
            students.add(new Student());
        }
        // call the method to print the arrayList of students
//        printList(students);
        printMoreLists(students);

        // test for the subclass: LPAStudent
        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0 ; i < studentCount ; i++){
            // add new instance of student to the array list
            lpaStudents.add(new LPAStudent());
        }
        // call the method to print the arrayList of students
        //this doesn't work because the method expects the List<Student> type, and the container has no relationship to List<LPAStudent>
//        printList(students);
        printMoreLists(lpaStudents); //works after the generic alteration to the method to allow the type argument


        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1,2,6,3)));


        //check fieldmatching
        var queryList = new QueryList<>(lpaStudents); //pass the lpaStudents list into the QueryList class; java infers type LPAStudent
        var matches = queryList.getMatches("Course", "Python");
        printMoreLists(matches);

        //call the static method from QueryList
        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreLists(students2021 );

        //test the enforcement of the QueryList restriction: Student & QueryItem (Employee only implements QueryItem)
//        QueryList<Employee> employeeList = new QueryList<>(); //type dev.lpa.Employee is not within its bound,


    }

    //create a method to print out the list of students
//    In the code block of our example, this is the best implementation, because we are using elements in the collection,
//    and I can access functionality specific to Student elements, but I’m not trying to add, or set an element in my list in this code.
    public static void printMoreLists(List<? extends Student> students){ //? is wildcard

        for (var student : students){
            System.out.println(student.getYearStarted() +": " + student);
        }
        System.out.println();
    }

//    The lists have no upper bounds associated with them, so they always resolve to List<Object>
//    these methods wouldn’t overload each other in the byte code
    // create a static method accepting List<String>
//    public static void testList(List<String> list){
//        for (var element : list){
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }// create overloaded static method accepting List<Int>
//    public static void testList(List<Integer> list){
//        for (var element : list){
//            System.out.println("Integer: " + element.floatValue());
//        }
//    }
//solution:
    public static void testList(List<?> list){
        for (var element : list){
            if (element instanceof String s){
                System.out.println("String: " + s.toUpperCase());
            }else if (element instanceof Integer i){
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }



    //create a method to print out the list of students
    //to allow for the use of subclasses within the args as well, we will make this a generic method, using <T>
//    public static <T extends Student> void printList(List<T> Students){ //takes a List of any Type T
//        for (var student : Students){
//            System.out.println(student.getYearStarted() +": " + student);
//        }
//        System.out.println();
//    }
}
