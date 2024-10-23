package dev.lpa;

// you should have constructors or methods to support adding a couple of attributes and some location data to your class
// you can pass location data of Point type, as String, or a set of double values, representing Lat/Long
// you can pass multiple locations of a line, as a set of Strings, or a two-dimensional array of doubles that represents
// the multiple points on your line.

public class River extends Line{
    private String name;

    //CREATE CONSTRUCTOR INCLUDING THE SUPER(LOCATION) FROM ABSTRACT POINT CLASS
    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }
    //OVERRIDE toString method
    @Override
    public String toString() {
        return name + " River";
    }
}
