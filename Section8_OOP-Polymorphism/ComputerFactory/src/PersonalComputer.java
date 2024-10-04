public class PersonalComputer extends Product{
    //personal computer class is composed of three other classes, this is the instance of composition
    private ComputerCase computerCase;
    private Motherboard motherboard;
    private Monitor monitor;

    //generate constrcutor that loops in all of the fields relevant to the created class objects

    public PersonalComputer(String model, String manufacturer,
                            ComputerCase computerCase,
                            Motherboard motherboard,
                            Monitor monitor) {
        super(model, manufacturer);
        this.computerCase = computerCase;
        this.motherboard = motherboard;
        this.monitor = monitor;
    }



    //creating private methods to get the attributes associated with the computer parts. enforced privacy through encapsulation
    private void drawLogo(){
        monitor.drawPixelArt(1200,50,"yellow");
    }
    public void powerUp(){
        computerCase.pressPowerButton();
        drawLogo();
    }


    //add getter methods for the attributes
//    public ComputerCase getComputerCase() {
//        return computerCase;
//    }
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }
//    public Monitor getMonitor() {
//        return monitor;
//    }




}
