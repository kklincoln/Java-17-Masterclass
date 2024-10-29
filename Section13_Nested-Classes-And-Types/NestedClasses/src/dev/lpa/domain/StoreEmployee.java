package dev.lpa.domain;

import java.util.Comparator;

public class StoreEmployee extends Employee {
    private String store;

    //generate constructors for this class
    public StoreEmployee() {
    }
    public StoreEmployee(int employeeID, String name, int yearStarted, String store) {
        super(employeeID, name, yearStarted);
        this.store = store;
    }

    // print out each employee with the toString method
    @Override
    public String toString() {
        return "%-8s%s".formatted(store,super.toString()); //store and then the toString from original Employee
    }

    // implement Store Comparator with type arg of StoreEmployee
    public class StoreComparator<T extends StoreEmployee>
            implements Comparator<StoreEmployee>{

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            if (result == 0){//check if employees are at the same store; if so, compare by yearStarted
                return new Employee.EmployeeComparator<>("YearStarted").compare(o1,o2);
            }
            return result;
        }
    }
}
