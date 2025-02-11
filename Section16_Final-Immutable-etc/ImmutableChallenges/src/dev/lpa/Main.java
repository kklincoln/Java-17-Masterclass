package dev.lpa;

import dev.bank.Bank;
import dev.bank.BankAccount;
import dev.bank.BankCustomer;


public class Main {
    public static void main(String[] args) {
    /// TESTING
        //CREATE ACCOUNTS
//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);
        //currently this is immutable, meaning you can't change the accounttype or balance, but this isn't realistic for a banking app
        //but if we are passing the info to a clearing house, we wouldn't want this information tampered with.

    ///tests for after the BankCustomer implementation with constructor and toString
//        BankCustomer joe = new BankCustomer("Steven G.", 1500.0, 65000.00);
//        System.out.println(joe);
        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe"  , 500.0, 10000.00);

        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

    ///add funds to joe's account
        //add funds
        if(bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING, 35)){
            System.out.println(joe);
        }

        BankAccount checking = joe.getAccount(BankAccount.AccountType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k,v) -> System.out.println(k + " : " + v));   //not guaranteed to be in order

    ///attempt to tamper with each transaction; they currently have been changed
//        System.out.println("-".repeat(20));
//        for (var tx : transactions.values()){
//            tx.setCustomerId(2);
//            tx.setAmount(10000.00);
//        }
//        transactions.forEach((k,v) -> System.out.println(k + " : " + v));

        ///instead of the code above, try to clear joe's transactions
        //this compiles and runs, but has no effect on the transactions because what's returned in BankAccount class
        // is a map of String not Transaction. a modifiable collection with immutable data
        joe.getAccount(BankAccount.AccountType.CHECKING).getTransactions().clear();


        //check if they have been changed on joe not local variables; they have.
        System.out.println("-".repeat(20));
        joe.getAccount(BankAccount.AccountType.CHECKING).getTransactions().forEach((k,v) -> System.out.println(k + ": " + v));

    }


}

