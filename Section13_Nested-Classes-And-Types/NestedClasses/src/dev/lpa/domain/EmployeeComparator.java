package dev.lpa.domain;

import java.util.Comparator;

//generic comparator class that accepts any Employee or subtype of Employee
public class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName()); // comparator sort by name
    }
}
