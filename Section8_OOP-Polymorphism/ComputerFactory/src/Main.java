public class Main {
    public static void main(String[] args) {
        //create a computer case, monitor, and motherboard instance
        ComputerCase theCase = new ComputerCase("2208", "Dell","240");
        Monitor theMonitor = new Monitor("27inch Beast", "Acer",27,"2540 x 1440");
        Motherboard theMotherboard = new Motherboard("BJ-200","Asus",4,6,"v2.44");
        // using the same information as used in the individual instances, create a personalComputer instance
        PersonalComputer thePC = new PersonalComputer("2208","Dell",theCase,theMotherboard,theMonitor);

        // draw pixelArt with the method within the monitor class; chain the method to the product to the composition instance
//        thePC.getMonitor().drawPixelArt(10,10,"Red");   // draw pixel Art from the monitor method
//        thePC.getMotherboard().loadProgram("Windows OS"); //load program from the motherboard method
//        thePC.getComputerCase().pressPowerButton(); //press power button on the computer case from computercase method

        //enforcing privacy so that the PersonalComputer is controlling all of the objects through Composition and encapsulation
        thePC.powerUp();


    }
}
