public class Car {

    // five fields are associated to the car class, since they are defined in the class's code block and not a method
    // unlike local variables, class variables should have some type of access modifier declared to it.
    private String make = "Tesla";
    private String model = "Model X";
    private String color = "Gray";
    private int doors = 2;
    private boolean convertible = true;


    // GETTER METHODS
    // these getter methods allow for the data that is set in the fields above to be called by external methods.
    // since the access modifier is set to private, they would not otherwise be able to have the values accessed.
    // e.g. for use within external method:         System.out.println("Model = " + car1.getModel());
    public String getMake(){return make;}
    public String getModel(){return model;}
    public String getColor(){return color;}
    public int getDoors(){return doors;}
    public boolean isConvertible(){return convertible;}


    // SETTER METHODS
    // Setter method simply assigns the argument that has been passed to the method, to the field, but it can also contain
    // code that would validate data, check additional security requirements, ensure immutability of the field value, or
    // any other code required to protect and validate an object's state.
    public void setMake(String make){
        if (make == null) make = "Unknown";
        String lowercaseMake = make.toLowerCase();
        switch  (lowercaseMake){
            case "holden","porsche","tesla" -> this.make = make;
            default ->{
                this.make = make;
            }
        }
    }
    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    // create a method that will describe the class. The method is not static becasue I'm accessing instance fields on the class
    public void describeCar(){
        System.out.println(doors + "-Door " +
                color + " " +
                make + " " +
                model + " " +
                (convertible ? "Convertible" : ""));
    }
}
