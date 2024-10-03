public class Fish extends Animal{
    // create fields that are unique to this class
    private int fins;
    private int gills;


    //constructors to initialize the class with the fields from Animal too //inherit fields from Animal(type, size, weight)
    public Fish(String type, double weight, int fins, int gills){
        super(type, "small", weight);
        this.fins = fins;
        this.gills = gills;
    }

    //create methods specific to Fish instances, they are private because we only want the move() method to call them
    private void moveMuscles(){
        System.out.print("muscles moving ");
    }

    private void moveBackFins(){
        System.out.print("backfin moving ");
    }

    //the intheritance method from the Animal class
    @Override
    public void move(String speed) {
        super.move(speed);
        moveMuscles();
        if (speed == "fast"){
            moveBackFins();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                "} " + super.toString();
    }
}
