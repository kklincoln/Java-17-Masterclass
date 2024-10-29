package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.EmployeeComparator;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//anonymous classes
public class RunMethods {
    public static void main(String[] args) {
        //create a list of storeEmployees
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(//instantiate the ArrayList and pass in instances
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10435, "Tim", 2020, "Macys"),
                new StoreEmployee(19432, "Steven", 2018, "Target"),
                new StoreEmployee(12043, "Marty", 2016, "Walmart"))
        );

        //TOP LEVEL CLASS COMPARATOR and lower levels
        var c0 = new EmployeeComparator<StoreEmployee>();   //
        var c1 = new Employee.EmployeeComparator<StoreEmployee>(); // static nested class on Employee class
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>(); // uses the inner class on StoreEmployee, creating an instance of StoreEmployee first

        //LOCAL CLASS ACTING AS COMPARATOR
        class NameSort<T> implements Comparator<StoreEmployee>{
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        var c3 = new NameSort<StoreEmployee>();

        //ANONYMOUS CLASS ACTING AS COMPARATOR
        //create variable c4 and immediately assign it to comparator (hence the anon), reminder that you cant instantiate an interface directly
        var c4 = new Comparator<StoreEmployee>(){
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        //invoke sortIt method
        sortIt(storeEmployees,c0);  //sorted by name
        sortIt(storeEmployees, c1);  //sorted by name
        sortIt(storeEmployees,c2); //sorted by store then yearStarted
        sortIt(storeEmployees,c3); // local class acting as comparator
        sortIt(storeEmployees,c4); // anon class acting as comparator

    }

//  METHOD TO SORT ELEMENTS USING LIST AN COMPARATOR ARGS
    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator ){ // ? is lower bounded
        System.out.println("Sorting with comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee : list){
            System.out.println(employee);
        }
    }
}
