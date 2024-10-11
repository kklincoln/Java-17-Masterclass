package dev.lpa;

//ENUMS ARE REALLY JUST A CLASS, AND EACH OF THE CONSTANTS ARE INSTANCES OF THE CLASS.
// we can add fields, methods, and even constructors to the enum type, this is when a semicolon is required
public enum Topping {
    MUSTARD,
    PICKLES,
    BACON,
    CHEDDAR,
    TOMATO;

    public double getPrice(){
        return switch(this){
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }


}
