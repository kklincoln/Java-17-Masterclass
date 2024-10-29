package dev.lpa;

// Create a record named Employee, containing First Name, Last Name, hire date
// set up a list of Employees with various names and hire dates in the main method
// set up a new method that takes this list of Employees as a parameter.
// create a local class to wrap this class, (pass Employee to the constructor and include a field for this) add some calculated fields, such as full name and years worked)
// create a list of employees using your local class
// create an anonymous class to sort your local class employees, by full name or years worked
// print the sorted list
// hint: int currentYear = LocalDate.now().getYear();

import dev.lpa.domain.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
     public static void main(String[] args) {
        //set up a list of Employees with various names and hire dates in the main method
        List<Employee> list = new ArrayList<>(List.of(
                new Employee("Steven","Greer","12/01/2000"),
                new Employee("Jason", "Mamoa", "2/23/2010"),
                new Employee("Tim", "Bulchak", "6/1/2013"),
                new Employee("Stephanie", "Stevens", "2/17/2023"),
                new Employee("Peter", "Parker", "3/21/2010"),
                new Employee("Jacob", "Elordi", "4/13/2022")
        ));

        //invoke the sorting
         printOrderedList(list,"name");
         System.out.println("-".repeat(30));
         printOrderedList(list,"date");
    }


    //---------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------
    // set up a new method that takes this list of Employees as a parameter.
    public static void printOrderedList(List<Employee> list, String sortField){
        int currentYear = LocalDate.now().getYear();

        //---------------------------------------------------------------------------------
        // CREATE A LOCAL CLASS TO WRAP THIS CLASS, (pass Employee to the constructor and include a field for this) add some calculated fields, such as full name and years worked)
        class MyEmployee{   //not using extends because Employee is a record, cannot use Record in Extends
            Employee containedEmployee; //reference original Employee instance
            int yearsWorked;
            String fullName;

            //GENERATE CONSTRUCTOR
            public MyEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]);//get the third split on /, getting Year
                fullName = String.join(" ",
                        containedEmployee.firstName(), containedEmployee.lastName());
            }
            //TOSTRING METHOD FOR LOCAL CLASS
            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        //---------------------------------------------------------------------------------
        // CREATE A LIST OF EMPLOYEES USING THE LOCAL CLASS
        List<MyEmployee> secondList = new ArrayList<>();
        for(Employee employee : list){
            secondList.add(new MyEmployee(employee));
        }
        // create an anonymous class to sort your local class employees, by full name or years worked
        //set up comparator
        var comparator = new Comparator<MyEmployee>(){
            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if (sortField.equalsIgnoreCase("name")){
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        secondList.sort(comparator);
        // print the sorted list
        for (MyEmployee myEmployee : secondList){
            System.out.println(myEmployee );
        }

    }

}
