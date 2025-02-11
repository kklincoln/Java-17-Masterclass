package dev.lpa;

public class Parent {
    /// STATIC INITIALIZER lets us initialize static variables and is called as part of the class construction
    static {
        System.out.println("Parent static initializer: class being constructed");
    }

    ///establish private fields for the parent class;
    /// reminder: final fields need to be initialized, and setters do not compile
    private final String name;
    private final String dob;
    protected final int siblings;   //protected so subclasses can access

    ///instance initializer; executed when the instance of the class is created, before any code in the class constructors
    {
//        name = "John Doe";
//        dob = "01/01/1900";
        System.out.println("In Parent Initializer");
    }


    /// ///CONSTRUCTOR after the initializer block
    /// need to create a no args constructor any time there is a constructor created; implicit one no longer becomes avail.
//    public Parent() {
//        System.out.println("Parent's no arg constructor.");
//    }

    public Parent(String name, String dob, int siblings) {
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("In Parent constructor");
    }

    ///getters and setters for fields and toString
    public String getName() {
        return name;
    }
    public String getDob() {
        return dob;
    }

    ///toString
    @Override
    public String toString() {
        return "name= " + name + '\'' + ", dob='" + dob + '\'';
    }
}
