public class Main {

    public static void main(String[] args) {
        // create an instance of the Car class
        Car car1 = new Car();
        // manually setting the fields in our class within our external method, this preserves the default values in the class
        // while also allowing our object (instance) to have unique values.
        car1.setMake("Porsche");
        car1.setModel("Carrera");
        car1.setColor("Red");
        car1.setDoors(2);
        car1.setConvertible(true);
        System.out.println("Make = " + car1.getMake());
        System.out.println("Model = " + car1.getModel());
        car1.describeCar();

        Car targa = new Car();
        targa.setMake("Porsche");
        targa.setModel("Targa");
        targa.setColor("Black");
        targa.setDoors(2);
        targa.setConvertible(false);
        targa.describeCar();
    }

}
