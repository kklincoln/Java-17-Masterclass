package dev.lpa;



public class Bird extends Animal implements FlightEnabled, Trackable {
    //overriding the move() abstract method from Animal
    // this class will also need to override the methods from the interfaces that are implemented
    @Override
    public void move() {
        System.out.println("Flaps Wings");
    }

    @Override
    public void takeoff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }
}
