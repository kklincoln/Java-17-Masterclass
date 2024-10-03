public class Dog extends Animal{
    private String earShape;
    private String tailShape;

    // inherit the methods from the Animal class
    public Dog(){
        super("Mutt","Big",50);    // before you explicitly declare a constructor in Animal, this will appear as an error
    }

    // constructor that makes it easier to create an instance of Dog if the ears are perky and the tailshape is curled
    // it calls the other Dog constructor, that then calls the Animal constructor
    public Dog(String type, double weight){
        this(type, weight, "Perky", "Curled");
    }

    //create a dog constructor
    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type
                ,weight < 15? "small" : (weight < 35 ? "medium" : "large") // ternary operator to pass the arg for size
                , weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    //generate the toString code to allow for the information print out for this class


    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    //create methods specific to Dog instances
    public void makeNoise(){ //this is the first override method that is manually created; overrides the one in Animal
        if (type == "Wolf"){    // checks the super field since it is a protected encapsulation not private
            System.out.print("Ow Wooooo! ");
        }
        bark();
        System.out.println();
    }
    @Override
    public void move(String speed) {//this is the override method that is generated, includes @Override
        super.move(speed);
//        System.out.println("Dogs walk, run, and wag their tail."); //demonstrating adding functionality specific to Dog
        if (speed == "slow"){
            walk();
            wagTail();
        }else{
            run();
            bark();
        }
        System.out.println();

    }

    private void bark(){
        System.out.print("Woof! ");
    }

    private void run(){
        System.out.print("Dog Running ");
    }

    private void walk(){
        System.out.print("Dog Walking ");
    }

    private void wagTail(){
        System.out.print("Tail Wagging ");
    }

}
