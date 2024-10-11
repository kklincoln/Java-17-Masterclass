//create a simple banking app with a Customer and Bank type
//Customer will have a name and an ArrayList of transactions containing Double wrapper elements
    //A customer's transaction can be a credit, meaning a positive amount, or it can be a debit, a negative amt
//Bank will have a name and an ArrayList of Customers
    // Bank should *add a new customer* if they're not already in the list
    // bank class should allow customer to add a transaction, to existing Customer
    // the class should also print a statement that includes the customer name and the transaction amounts. The method should use unboxing

package dev.lpa;

import java.util.ArrayList;

// create Record (not class) for the Customer and Bank
record Customer(String name, ArrayList<Double> transactions ){
    public Customer(String name, double initialDeposit){
        // call the this() implicit constructor that will reference the default constructor
        this(name.toUpperCase(),
        new ArrayList<Double>(500)); //new instance of the Double ArrayList, with an estimated capacity threshold
        transactions.add(initialDeposit);
    }
}

public class Challenge_Banking {
    public static void main(String[] args) {
        // test the Record by creating a new customer
        Customer bob = new Customer("Bob S",1000.0);
        System.out.println(bob);


        //testing methods
        Bank kBank = new Bank("Chase");
        kBank.addCustomer("Kiernan",20000.0);
        System.out.println(kBank);

        kBank.addTransaction("Kiernan",-12300.0);
        kBank.addTransaction("Kiernan",2100.0);
        kBank.addTransaction("Kiernan",-12000.0);
        kBank.addTransaction("Kiernan",14320.0);
        kBank.printTransactions("Kiernan");

        kBank.printTransactions("Bob");

        kBank.printTransactions("Bob");
    }
}

class Bank{
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    //create a constructor that only accepts name for instantiation
    public Bank(String name){
        this.name = name;
    }
    //no getters and setters so no client code can access the customer list

    //return a matching customer from the list based on customer name
    private Customer getCustomer(String customerName){
        for ( var customer : this.customers){
            //use an enhanced for loop to go through the customerlist based on customerName arg; return match if found
            if(customer.name().equalsIgnoreCase(customerName)){
                return customer;
            }
        }
        System.out.printf("Customer (%s) not found. ", customerName);
        return null;
    }

    //method to add new customer
    public void addCustomer(String customerName, double initialDeposit){
        //check if customer exists
        if (getCustomer(customerName) == null){
            // instantiate customer and add to the ArrayList; confirm with println
            Customer newCustomer = new Customer(customerName, initialDeposit);
            this.customers.add(newCustomer);
            System.out.println("New Customer Added: " + newCustomer);
        }
    }

    // update the toString method
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers= " + customers +
                "}";
    }

    //create the add transaction method
    public void addTransaction(String customerName, double transactionAmount){
        // get matching customer record; if not null, add transaction
        Customer customer = getCustomer(customerName);
        if (customer != null){
            customer.transactions().add(transactionAmount);
        }
    }
    //print the transactions, public so it can be called from main
    public void printTransactions(String customerName){
        Customer customer = getCustomer(customerName);
        if (customer == null){
            System.out.printf("No customer %s exists, unable to print transactions.", customerName);
            return;
        }
        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + customerName);
        System.out.println("Transactions");
        for (Double d : customer.transactions()){ //unboxing
            System.out.printf("$%10.2f (%s)%n",d, (d < 0 ? "debit" : "credit") ); //10 width.## (debit or credit ternary) newline

        }
    }

}

