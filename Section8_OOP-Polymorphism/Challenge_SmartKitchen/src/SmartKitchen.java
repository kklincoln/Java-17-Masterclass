public class SmartKitchen {
    // create instances of each respective product class using composition
    private CoffeeMaker brewMaster;
    private Refrigerator iceBox;
    private DishWasher dishWasher;

    // create constructor with no arguments. i.e. there is a standard type of smart kitchen
    public SmartKitchen(){
        brewMaster = new CoffeeMaker();
        iceBox = new Refrigerator();
        dishWasher = new DishWasher();
    }

    //generate getters to get the status of the appliances; setters are within each class file
    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }
    public Refrigerator getIceBox() {
        return iceBox;
    }
    public DishWasher getDishWasher() {
        return dishWasher;
    }

        //alternative approach to the three above, sets the three boolean values appropriately based on args entered
    public void setKitchenState(boolean coffeFlag, boolean fridgeFlag, boolean dishWasherFlag){
        brewMaster.setHasWorkToDo(coffeFlag);
        iceBox.setHasWorkToDo(fridgeFlag);
        dishWasher.setHasWorkToDo(dishWasherFlag);
    }
    //doKitchenWork delegates any applicable work to the appliances as necessary; hides the work to be done by calling code
    public void doKitchenWork(){
        brewMaster.brewCoffee();
        iceBox.orderFood();
        dishWasher.doDishes();
    }
}
