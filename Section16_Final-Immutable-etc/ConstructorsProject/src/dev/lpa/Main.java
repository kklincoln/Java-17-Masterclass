package dev.lpa;

import external.Child;

public class Main {
    public static void main(String[] args) {

        ///create a new instance object of the Parent class
        Parent parent = new Parent("John Doe", "01/01/1958", 4);
        /// creating a new instance object of the external Child class
        System.out.println("Parent initializer and constructor system lines below are for the Child instance");
        Child child = new Child();

        /// print the child and parent objects; they will both print the toString from the Parent level
        System.out.println("Parent: " + parent);
        System.out.println("Child: " + child);


        ///TESTING THE CANONICAL CONSTRUCTOR FROM Person record
        Person joe  = new Person("Joe", "01-01-1950");
        System.out.println(joe);

        ///non-canonical constructor from Person
        Person joeCopy = new Person(joe);
        System.out.println(joeCopy);


        /// TEST Generation enum
//        Generation g; //no evidence of the code being run
        Generation g = Generation.BABY_BOOMER;  //runs the code


    }
}
