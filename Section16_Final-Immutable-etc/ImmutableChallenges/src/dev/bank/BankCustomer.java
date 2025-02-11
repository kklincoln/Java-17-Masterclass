package dev.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    /// CREATE BANKCUSTOMER FIELDS
    private int lastCustomerId = 10_000_000;
    private final String name;
    private final int customerId;
    private List<BankAccount> accounts = new ArrayList<>();;

    /// CREATE BANKCUSTOMER CONSTRUCTORS; no access modifiers specified to make this immutable
    BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        this.customerId = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVINGS, savingsAmount));
    }

    /// CREATE GETTERS
    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return "%015d".formatted(customerId);
    }

    public List<BankAccount> getAccounts() {
        // prevents the creation of accounts from any classes, not the same package as BankAccount class
        //return an unmodifiable collection instead; prevents adding, deleting, or reassigning accounts
        return List.copyOf(accounts);
    }

    ///get customer account by account type (enum)
    public BankAccount getAccount(BankAccount.AccountType type){
        //loop through the accounts within the List; if the type is the same as method argument, return
        for (var account : accounts){
            if (account.getAccountType() == type){
                return account;
            }
        }
        return null;
    }


///TOSTRING
    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];  //include all the accounts from List into a new array
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString()); //set all the array elements toString()
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId, String.join("\n\t",accountStrings));
    }
}
