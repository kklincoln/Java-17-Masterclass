public class DishWasher {
    // create fields for Class
    private boolean hasWorkToDo;

    // we don't need constructors because we are not a factory, we are just changing the attributes for the one instance
    // create setter method
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    // create methods
    public void doDishes(){
        if(hasWorkToDo){
            System.out.println("Dishwasher is full. Running dishwasher...");
            hasWorkToDo = false;
        }
    }

}
