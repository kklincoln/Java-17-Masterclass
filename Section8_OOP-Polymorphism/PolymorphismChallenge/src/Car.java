public class Car {
    // create fields for class
    private String description;

    // create constructor
    public Car(String description) {
        this.description = description;
    }

    // create getter/setters (optional)
    // create methods for class
    public void startEngine(){
        System.out.println("Car -> startEngine...");
    }
    //protected means subclasses can override it, but other classes cannot
    protected void runEngine() {
        System.out.println("Car -> runEngine...");
    }
    public void drive(){
        System.out.println("Car -> driving, type is " + getClass().getSimpleName());
        runEngine();
    }
}

//---------------------------------------------------------------CREATE SUBCLASSES
//----------------------------------- GAS CAR

class GasCar extends Car{
    // create fields for this class specifically
    private double avgKmPerLitre;
    private int cylinders =6;

    // generate a constructor that is the same as car class
    public GasCar(String description){
        super(description);
    }

    //create constrctor including super fields
    public GasCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    // create methods for the class
    @Override
    public void startEngine() {
        //replacing functionality from the super method
        System.out.printf("Gas -> All %d, cylinders are fired up, Ready!%n", cylinders);
    }
    @Override
    protected void runEngine() {
        //replacing functionality from the super method
        System.out.printf("Gas -> Usage exceeds the average: %.2f %n", avgKmPerLitre);
    }
//    @Override
//    public void drive(){
//
//    }
}

//---------------------------------- ELECTRIC CAR
class ElectricCar extends Car{
    // create fields for this class specifically
    private double avgKmPerCharge;
    private int batterySize =6;

    // generate a constructor that is the same as car class
    public ElectricCar(String description){
        super(description);
    }

    //create constrctor including super fields
    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    // create methods for the class
    @Override
    public void startEngine() {
        //replacing functionality from the super method
        System.out.printf("BEV -> Switch %d kWh battery on, Ready!%n", batterySize);
    }
    @Override
    protected void runEngine() {
        //replacing functionality from the super method
        System.out.printf("BEV -> Usage under the average: %.2f %n", avgKmPerCharge);
    }
//    @Override
//    public void drive(){
//
//    }
}


//---------------------------------- HYBRID CAR
class HybridCar extends Car{
    // create fields for this class specifically
    private double avgKmPerLitre;
    private int cylinders =6;
    private int batterySize;

    // generate a constructor that is the same as car class
    public HybridCar(String description){
        super(description);
    }

    //create constrctor including super fields
    public HybridCar(String description, double avgKmPerLitre, int cylinders, int batterySize) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
        this.batterySize = batterySize;
    }

    // create methods for the class
    @Override
    public void startEngine() {
        //replacing functionality from the super method
        System.out.printf("Hybrid -> %d cylinders are fired up.%n", cylinders);
        System.out.printf("Hybrid -> Switch %d kWh battery on, Ready!%n", batterySize);
    }
    @Override
    protected void runEngine() {
        //replacing functionality from the super method
        System.out.printf("Hybrid -> Usage below the average: %.2f %n", avgKmPerLitre);
    }
//    @Override
//    public void drive(){
//    }
}
