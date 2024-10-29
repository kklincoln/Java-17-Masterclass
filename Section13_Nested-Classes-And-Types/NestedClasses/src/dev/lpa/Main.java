package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //set up employees in the main method within a List
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001,"Tim",2021),
                new Employee(10002, "Steven", 2024),
                new Employee(10022, "Jane", 2013),
                new Employee(11353, "Laura", 2020),
                new Employee(10050, "Jim", 2018)
                ));

        // create a new comparator
//        var comparator = new EmployeeComparator<>(); //inferred type of Employee class
//        employees.sort(comparator); //pass the comparator into the default ArrayList.sort method

        //after moving the Comparator class to be nested within the Employee class, verify comparator against a diff field
        employees.sort(new Employee.EmployeeComparator<>("YearStarted")//inferred type of the instantiation of comparator
                .reversed());

        //confirm list is sorted by name; print using forloop
        for (Employee e : employees){
            System.out.println(e);
        }

        //non-static nested classes cannot be instantiated the same way those in line 25 are
        System.out.println("Store Members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(//instantiate the ArrayList and pass in instances
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10435, "Tim", 2020, "Macys"),
                new StoreEmployee(19432, "Steven", 2018, "Target"),
                new StoreEmployee(12043, "Marty", 2016, "Walmart")
                ));
        //call comparator
// //in order to call the inner nested class comparator, Java defaults to using Employee's comparator unless we instantiate a generic StoreEmployee first
//        var genericEmployee = new StoreEmployee();
//        var comparator = genericEmployee.new StoreComparator<>();

        //if we didn't want to use the approach above, we first instantiate an instance of StoreEmployee()
        // then create an instance of inner class StoreComparator
        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);

        for (StoreEmployee s : storeEmployees){
            System.out.println(s);
        }

        //print from the new pigLatinNames method
        System.out.println("With Pig Latin Names:");
        addPigLatinName(storeEmployees);

    }

    //LOCAL CLASSES: pig-latin
    public static void addPigLatinName(List<? extends StoreEmployee> list){ //accepts List containing StoreEmployee or subtype of StoreEmployee
        //LOCAL CLASS, CREATED WITHIN THE METHOD BODY OF addPigLatinName, since we only want it to exist for this one specific purpose
        String lastName = "Piggy";


        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{
            private String pigLatinName;
            private Employee originalInstance;

            //CONSTRUCTOR
            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString(){
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        //within the same method, create a list of the pigLatinNames and print them out
        List<DecoratedEmployee> newList = new ArrayList<>(list.size()); //create list of size from the argument
        //loop through the list and ad them to the new list
        for (var employee : list){
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        //sort the newList
        newList.sort(null); //same result as Comparator.naturalOrder()
        //print each from the decorated employees
        for (var dEmployee : newList){
//            System.out.println(dEmployee);
            System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
        }

    }

}
