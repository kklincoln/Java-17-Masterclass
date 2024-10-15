package dev.lpa;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird(); //the usual way of creating an instance of Bird and assigning it to variable 'bird'
//but since you can say Bird is an Animal and is FlightEnabled and Trackable, you can assign the Bird object to
// different reference types. A Bird can be assigned to any of these four different types
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

//when we assign the variable's declared Type (in this case, Animal), that's what determines which methods can be used
        animal.move();
//        flier.move();   //cannot use; these types don't have a move() method
//        tracked.move(); //cannot use; these types don't have a move() method

        //mmethods overridden in the Bird class that were created in Animal interface
//        flier.takeoff();
//        flier.fly();
//        tracked.track();
//        flier.land();

        //replacing the direct method calls with the call to the method below
        inFlight(flier);
        System.out.println("-".repeat(30));

        //create an instance of the Jet class (implements FlightEnabled, Trackable)
        inFlight(new Jet());
        System.out.println("-".repeat(30));
        //create instance of Truck (implements Trackable)
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);


        //ABSTRACTED TYPES - CODING TO AN INTERFACE (USING INTERFACE TYPES AS THE REFERENCE TYPE IS CONSIDERED BEST PRACTICE)
        LinkedList<FlightEnabled> fliers = new LinkedList<>();
        fliers.add(bird);
        //ArrayList implements the declared type, and it is recommended to use the interface type
        List<FlightEnabled> betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        //pass the ArrayList type into the methods that are declared to iterate through the list and call the methods
        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);
//        attempting with betterFliers (you cannot pass a List to a method where it expect an ArrayList; note: if methods are
//        just expecting List<> as an argument, you don't need to adjust either of the methods or calls to the methods
        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);



    }


    //the argument is something that flies, of FlightEnabled type;
    private static void inFlight(FlightEnabled flier){
        flier.takeoff();
        flier.fly();
        if (flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }

    //this method is to demonstrate why the betterFliers list interface type is better than fliers ArrayList inteface type
    private static void triggerFliers(List<FlightEnabled> fliers) {
        // take an ArrayList of FlightEnabled things and then calling the takeoff method for each
        for (var flier : fliers) {
            flier.takeoff();
        }
    }
    private static void flyFliers(List<FlightEnabled> fliers){
        // take an ArrayList of FlightEnabled things and then calling the takeoff method for each
        for (var flier : fliers){
            flier.fly();
        }
    }
    private static void landFliers(List<FlightEnabled> fliers) {
        // take an ArrayList of FlightEnabled things and then calling the takeoff method for each
        for (var flier : fliers) {
            flier.land();
        }
    }
}
