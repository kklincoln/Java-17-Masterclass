package dev.bank;


import dev.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    public enum AccountType {CHECKING, SAVINGS};

    /// BANKACCOUNT FIELDS
    // an enum value is an immutable type, so neither of these are subject to side effects once assigned
    private final AccountType accountType;
    private double balance;
        //using map to allow for search via transactionID; LinkedHashMap initialization to order by the insertion
    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    /// CREATE BANKCUSTOMER CONSTRUCTORS
    // removed the 'public' accessor so that there would be blocks to manually adding accounts; also blocks subclass creation
    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }
    /// CREATE GETTERS
    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Map<Long, String> getTransactions() {
//instead return a map of immutable instances, Strings. This provides the same behavior iwthout exposing data to side effects.
//        return Map.copyOf(transactions);
        Map<Long, String> txMap = new LinkedHashMap<>();
        for (var tx : transactions.entrySet()){
            txMap.put(tx.getKey(), tx.getValue().toString());
        }
        return txMap;
    }

    ///TOSTRING
    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }

/// method to commit a transaction to the account
    void commitTransaction(int routingNumber, long transactionId, String customerId, double amount){
        //assume validation already happened
        balance += amount;
        //create a transaction
        transactions.put(transactionId, new Transaction(routingNumber, transactionId, Integer.parseInt(customerId),
                amount));
    }
}
