public class Main {
    public static void main(String[] args) {
        //create new instance of car
        Car car = new Car("2022 Blue Ferrari 296 GTS");
        //execute the static method runRace using instance above
        runRace(car);
        System.out.println("_ _ _ _ _");

        //create new instance of gasCar
        Car ferrari = new GasCar("2022 Blue Ferrari 296 GTS",
                15.4, 6);
        runRace(ferrari);
        System.out.println("_ _ _ _ _");
    //create new instance of electric car
        Car tesla = new ElectricCar("2022 Red Tesla Model 3", 568,75);
        runRace(tesla);
        System.out.println("_ _ _ _ _");
    //create new instance of hybrid car
        Car prius = new HybridCar("2022 Blue Toyota Prius", 428, 4, 42 );
        runRace(prius);
        System.out.println("_ _ _ _ _");

    }

    //create method that will take a car parameter; (static means it belongs to the class itself, not the instances)
    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}

// create fields for class

// create constructor

// create getter/setters (optional)

// create methods for class