package external;

import dev.lpa.Parent;

import java.util.Random;

public class Child extends Parent {

    private final int birthOrder = getBirthOrder();
    private final String birthOrderString;

    /// 3) instance initializer block to get the birthOrderString
    {
        if (siblings ==0 ) {
            birthOrderString = "Only";
        } else if (birthOrder == 1) {
            birthOrderString = "First";
        } else if (birthOrder == (siblings + 1)){
            birthOrderString = "Last";
        }else {
            birthOrderString = "Middle";
        }
        System.out.println("Child: Initializer, birthOrder =  " + birthOrder);
    }


    ///1) since we commented out the no args constructor for the Parent class, this Child class generates an error
    /// we cannot have a subclass that doesn't declare a constructor. Adding an explicit constructor below
    public Child(){
        super("Jane Doe", "02/02/1920", 5);    ///calling super() with no args is the problem above; pass defaults
        System.out.println("Child: Constructor");
    }

    /// 2) call a final method to initialize final instance fields
    private final int getBirthOrder(){
        if (siblings == 0) return 1; // siblings field called from parent, since it's initialized first
        return new Random().nextInt(1, siblings + 2);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + birthOrderString + " child";
    }
}
