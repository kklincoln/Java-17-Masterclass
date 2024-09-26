// create a new class Customer
    // name
    // credit limit
    // email address
// create the getter methods; not the setters
// create three constructors
    // one to assign all three fields from arguments directly to instance fields
    // second create a no args constructor that calls another constructor passing in literal values for each arg
    // third create a constructor with just the name and email parameters which also calls another constructor

public class Customer {
    private String name;
    private double creditLimit;
    private String emailAddress;


    // second create a no args constructor that calls another constructor passing in literal values for each arg
    public Customer(){ //not providing the credit limit sends it to the constructor below
        this("Nobody","Nobody@gmail.com");
        System.out.println("Calling the default vals; constructor number 2");
    }

    // third create a constructor with just the name and email parameters which also calls another constructor
    public Customer(String name, String emailAddress){
        this(name, 1000, emailAddress);
        System.out.println("Calling the partial constructor; constructor number 3");
    }

    // one to assign all three fields from arguments directly to instance fields
    public Customer(String name, double creditLimit, String emailAddress){
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }


    //getter methods
    public String getName(){
        return this.name;
    }
    public double getCreditLimit(){
        return this.creditLimit;
    }
    public String getEmailAddress(){
        return this.emailAddress;
    }
}
