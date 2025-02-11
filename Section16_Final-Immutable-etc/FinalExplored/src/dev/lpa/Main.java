package dev.lpa;

import consumer.specific.ChildClass;
import dev.lpa.generic.BaseClass;
import external.util.Logger;

public class Main {
    public static void main(String[] args) {
        /// execute the recommendedMethod on both BaseClass and ChildClass (extends BaseClass)
        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();                //childClass uses the overridden methods
        BaseClass childReferredToAsBase = new ChildClass(); //childClass uses the overridden methods

        /// INSTANCE METHODS are based on the runtime type, so child & childReferredToAsBase execute Child instance methods i.e. new Instances of ChildClass()
        parent.recommendedMethod();
        System.out.println("-".repeat(20));
        childReferredToAsBase.recommendedMethod();
        System.out.println("-".repeat(20));
        child.recommendedMethod();

        /// STATIC METHODS are based on the methods based on reference (ref type), so parent and childReferredToAsBase execute BaseClass static methods
        System.out.println("-".repeat(20));
        parent.recommendedStatic();
        System.out.println("-".repeat(20));
        childReferredToAsBase.recommendedStatic();
        System.out.println("-".repeat(20));
        child.recommendedStatic();

        //note that the codeblocks above indicate warnings, because best practice recommends always using the type reference when executing a static method.
        System.out.println("-".repeat(20));
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();


        /// FINAL VARIABLES OUTPUT
        String xArgument = "This is all I've got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only saying this: Section");
        doXYZ(xArgument, 16, zArgument);
        //demonstrating that modifying a method arg to final has no major benefit since the argument is out of scope after method execution
        System.out.println("After Method, xArgument: " + xArgument);


        /// implement the Logger method; note: Method arguments are copies of references. This is easy to overlook when dealing with collections and arrays
        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());  //adding the toString() suffix because otherwise the output is truncated after each execution
        tracker.append(", Step 2 is xyz.");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " + tracker);

    }

    /// DEMONSTRATING FINAL VARIABLES
    private static void doXYZ( String x, int y, StringBuilder z){
        //for instance, if we want to use the variable in lambda expressions later, we indicate to future devs that this needs to remain unchanged.
        final String c = x + y; // this just means that we aren't assigning a different value to C after initial assigment
        System.out.println("c = " + c);
        x = c;
        z.append(y);
//        z = new StringBuilder("This is a new reference"); //cannot be done if the z argument is modified to final
    }
}
