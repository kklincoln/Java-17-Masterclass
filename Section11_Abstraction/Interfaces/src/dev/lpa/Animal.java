package dev.lpa;


//enum describes four stages of a Satellite launch
enum FlightStages implements Trackable{GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;
    @Override
    public void track() {
        if (this != GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }

    // gets the next Stage
    public FlightStages getNextStage(){
        //retrieve all stages
        FlightStages[] allStages = values();
        // allStages[ currentIndex+1] ensure that if the current stage is the last, wrap to first stage(remainder: index 0)
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

record DragonFly(String name, String type) implements FlightEnabled{
    //normally, records wouldnt have class bodies, but we are implementing FlightEnabled so we need to implement the methods
    @Override
    public void takeoff() {

    }
    @Override
    public void land() {

    }
    @Override
    public void fly() {

    }
    }

class Satellite implements OrbitEarth{
    //EACH STATGE WILL BE SET AS IT CYCLES THROUGH THE STAGES
    FlightStages stages = FlightStages.GROUNDED;
    public void achieveOrbit(){
        System.out.println("That method was achieved.");
    }

    @Override
    public void takeoff() {
        transition("Taking Off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    //overload method
    public void transition(String description){
        System.out.println(description);
        stages = transition(stages);
        stages.track();
    }
}


interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();

    private static void log(String description){
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }
    private void logStage(FlightStages stage, String description){
        description = stage + ": " + description;
        //pass the description alongside the log()
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages originalStage) {
        //asign what comes back from FlightEnable's transition() method to nextStage
        FlightStages nextStage = FlightEnabled.super.transition(originalStage);
        // pass the originalStage and description to the logStage() method
        logStage(originalStage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}

interface FlightEnabled{
//note: "public" and "abstract" are both implied with interfaces
//    public abstract  void takeOff();    // public and abstract modifiers are redundant; unnecessary to declare
//    abstract void land();               // abstract modifier is redundant
//    void fly();                         // this is the PREFERRED declaration, public and abstract are implied
    double MILES_TO_KM = 1.60934; //note: fields declared on interfaces are really constants
    double KM_TO_MILES = 0.621371;

    void takeoff();
    void land();
    void fly();

//hypothetically, we later have new Method requirements that are established as a result of some business change
    //this new method means that every class that implements this interface will not compile. This means that for us, Bird, Jet,
    //Satellite, and DragonFly all need to change. Imagine the issues that arise due to a program with a lot more classes than this.
//    FlightStages transition(FlightStages originalStage);
    default FlightStages transition(FlightStages originalStage){
//        System.out.println("Transition not implemented on " +
//                getClass().getName()); //this. is implicit in the  this.getClass().getName() in non-static methods
//        //this console output lets us know that every class using this interface should override this method before using it in code
//        return null;
    FlightStages nextStage = originalStage.getNextStage();
    System.out.println("Transitioning from " + originalStage + " to " + nextStage);
    return nextStage;
    }
}

interface Trackable{
    void track();
}


public abstract class Animal {
    public abstract void move();
}
