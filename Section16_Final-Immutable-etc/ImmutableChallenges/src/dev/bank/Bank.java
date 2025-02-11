package dev.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
///declare fields relevant for the bank
    private final int routingNumber;                    //created at time of  bank creation, should not change (final)
    private long lastTransactionId = 1;                 //initialized to 1
    private final Map<String, BankCustomer> customers;  //Map so you can search by CustomerID

/// generate a constructor
    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        this.lastTransactionId = lastTransactionId++; //increment the lastTransaction number in log
        this.customers = new HashMap<>();   //not important that it's ordered, but the retrieval will be faster that way
    }

/// generate tostring
    @Override
    public String toString() {
        return "Bank{" +
                "routingNumber=" + routingNumber +
                ", lastTransactionId=" + lastTransactionId +
                ", customers=" + customers +
                '}';
    }

    ///METHODS FOR BANKING PROCESSES
    public BankCustomer getCustomer(String id){
        BankCustomer customer = customers.get(id);  //search through the customers Map for the BankCustomer with that id
        return customer;
    }

    public void addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit){
        // can only create customer's from within the bank package so it has to be done here
        BankCustomer customer = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        customers.put(customer.getCustomerId(), customer);
    }

    public boolean doTransaction(String id, BankAccount.AccountType type, double amount){
        //check if customer exists
        BankCustomer customer = customers.get(id);
        if (customer != null){
            //validate the transaction amount vs account balance
            BankAccount account = customer.getAccount(type);
            if (account != null){
                if ((account.getBalance() + amount) < 0){//this would only occur if there was a withdrawl exceeding balance
                    System.out.println("Insufficient funds");
                }else{
                    //process the commitTransaction method from the BankAccount class
                    account.commitTransaction(routingNumber, lastTransactionId++, id, amount);
                    return true;
                }
            }
        } else{
            System.out.println("Invalid customer id");
        }
        return false;
    }
}
