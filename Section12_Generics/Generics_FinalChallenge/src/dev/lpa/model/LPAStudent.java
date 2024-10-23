package dev.lpa.model;
//subclass of student
public class LPAStudent extends Student {
    private double percentComplete;

    //no args constructor
    public LPAStudent(){
        this.percentComplete = random.nextDouble(0,100.001);
    }

    //override the toString method
    @Override
    public String toString(){
        return "%s %8.1f%%".formatted(super.toString(),percentComplete); //note the second % is how to get it to print in the output
    }

    //generate a getter for percentComplete field
    public double getPercentComplete(){
        return this.percentComplete;
    }

    @Override
    public boolean matchField(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("percentComplete")){
            //return true if percentComplete <= value passed
            return percentComplete <= Integer.parseInt(value);
        }
        return super.matchField(fieldName, value);
    }
}
