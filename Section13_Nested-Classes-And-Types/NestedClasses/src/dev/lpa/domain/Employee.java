package dev.lpa.domain;

import java.util.Comparator;

public class Employee {

    //generic comparator class that accepts any Employee or subtype of Employee
    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

        //make this comparator more flexible
        private String sortType;

        //generate no args constructor
        public EmployeeComparator() {
            // chain a call to the other constructor passing the name field as sort type
            this("name");
        }
        // generate constructor with field
        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            //sort based on sortType field
            if (sortType.equalsIgnoreCase("yearStarted")){
                return o1.yearStarted - o2.yearStarted;
            } else if (sortType.equalsIgnoreCase("employeeID")){
                return o1.employeeID - o2.employeeID;
            } else{
                return o1.name.compareTo(o2.name); // comparator sort by name
            }
        }
    }

    private int employeeID;
    private String name;
    private int yearStarted;

    //create constructor, no args
    public Employee() {
    }

    //create constructor, all fields
    public Employee(int employeeID, String name, int yearStarted) {
        this.employeeID = employeeID;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    // name getter
    public String getName(){
        return this.name;
    }

    //generate a toString


    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeID, name, yearStarted);
    }
}
