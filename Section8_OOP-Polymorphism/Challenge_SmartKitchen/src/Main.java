public class Main {
    public static void main(String[] args) {
        // create instance of SmartKitchen
        SmartKitchen kitchen = new SmartKitchen();

//        // set all appliances to have work to do
//        kitchen.getDishWasher().setHasWorkToDo(true);//set the boolean flag to true
//        kitchen.getIceBox().setHasWorkToDo(true);//set the boolean flag to true
//        kitchen.getBrewMaster().setHasWorkToDo(true);//set the boolean flag to true
//        //call methods for each appliance to do the work
//        kitchen.getDishWasher().doDishes();
//        kitchen.getIceBox().orderFood();
//        kitchen.getBrewMaster().brewCoffee();
        //alternative to the code commented out above: incorporated composition
        kitchen.setKitchenState(true,false,true);
        kitchen.doKitchenWork();//does any work for necessary appliance
    }

}
