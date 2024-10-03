public class Main {
    public static void main(String[] args) {

        // test functionality:
        // instantiate a new instance of the class associated with the bank account.
        //commenting these out to demonstrate the overloaded constructor
//        BankAccount bobsAccount = new BankAccount("12345",500,"Bob Brown", "myemail2@bob.com",
//                "(760) 123-4567");

            //no values passed in during object creation to demonstrate the constructor chaining.
        BankAccount bobsAccount = new BankAccount();
        System.out.println(bobsAccount.getAccountNumber());
        System.out.println(bobsAccount.getAccountBalance());
        //no longer need the setter methods when you use a constructor
//        bobsAccount.setAccountNumber("12345");
//        bobsAccount.setAccountBalance(1000.00);
//        bobsAccount.setCustomerName("Bob Brown");
//        bobsAccount.setCustomerEmail("myemail@bob.com");
//        bobsAccount.setCustomerPhone("(087) 123-4567");

        bobsAccount.withrawFunds(100.0);
        bobsAccount.depositFunds(250.0);
        bobsAccount.withrawFunds(100.0);

    }
}
