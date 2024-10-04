public class Refrigerator {
    // create fields for Class
    private boolean hasWorkToDo;

    // we don't need constructors because we are not a factory, we are just changing the attributes for the one instance
    // create setter method
    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    // create methods
    public void orderFood(){
        if(hasWorkToDo){
            System.out.println("Ordering food from the refrigerator...");
            hasWorkToDo=false;
        }
    }

}
