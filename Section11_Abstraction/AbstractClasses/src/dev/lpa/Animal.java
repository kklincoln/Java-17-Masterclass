package dev.lpa;

abstract class Mammal extends Animal{
//Abstract classes dont have to implement abstract methods //an abstract class that extends another abstract class has some flexibility
    //it can implement all, some, or none of the parent's abstract methods
    //it can include additional abstract methods, which will force subclasses to implement BOTH Animal's and Mammal's methods

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }
    //implementing the move method so that any class extending mammal uses this one rather than Animal
    @Override
    public void move(String speed){
        System.out.print(getExplicitType() + " "); // calls the getExplicitType method from Animal
        System.out.println(speed.equals("slow") ? "walks" : "runs");
    }

    //abstract method specific for mammals
    public abstract void shedHair();
}


public abstract class Animal {
        //inherited fields
    protected String type; //subclasses can access directly, without a getter method
    private String size;
    private double weight;

    //constructor
    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }
    // abstract methods
    // here, we are using abstract in the declaration of the methods, again, after the public access modifier.
    // after the method signature, follow with a semi-colon. no need to specify an empty method body
    public abstract void move(String speed);

    public abstract void makeNoise();

    public String getExplicitType(){
        return getClass().getSimpleName() + " (" + type + ")";
    }
}
