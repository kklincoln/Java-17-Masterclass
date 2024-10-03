public class BankAccount {
    // declare private fields associated with the bank account class
    private String accountNumber;
    private Double accountBalance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    // constructor called
    public BankAccount(){
        // CONSTRUCTOR CHAINING: THE PROCESS OF CALLING ONE OVERLOADED CONSTRUCTOR FROM ANOTHER
        // essentially: if an object of the BankAccount() class is attempted to be called without arguments, use the defaults below
        // passed into the second constructor
        this("56789", 2.50, "Default Name", "Default address", "Default Phone");
        System.out.println("Empty constructor called.");

    }

    // constructor to initialize the fields
    // sets the values of the fields in your instance of a class. In addition, you can add other initialization code
    public BankAccount(String accountNumber, double balance ,String customerName, String customerEmail, String customerPhone){
        System.out.println("Account constructor with parameters called.");
        this.accountNumber = accountNumber;
        this.accountBalance = balance; //initialize account balance to 0.0 to avoid errors.
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public BankAccount(String customerName, String customerEmail, String customerPhone) {
        this("99999",100.55, customerName, customerEmail, customerPhone);
//        this.customerName = customerName;
//        this.customerEmail = customerEmail;
//        this.customerPhone = customerPhone;
    }

    // CREATE TWO ADDITIONAL METHODS, ONE FOR DEPOSITING FUNDS, ONE FOR WITHDRAWING FUNDS
    public void depositFunds(double depositAmount){
        this.accountBalance += depositAmount;
        System.out.println("Deposit of $"+ depositAmount +"The new account balance is: $" + this.accountBalance);
    }
    public void withrawFunds(double withdrawalAmount){
        if (this.accountBalance - withdrawalAmount < 0){
            System.out.println("Insufficient funds available for requested transaction. You have $"+ this.accountBalance
                    +" in your account.");
        }else {
            this.accountBalance -= withdrawalAmount;
            System.out.println("Withdrawal of $" + withdrawalAmount + " The new account balance is: $" + this.accountBalance);

        }
    }


    ////// Establish public getter and setter methods to enforce encapsulation and access requirements
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
////////////////////
    public Double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
////////////////////
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
////////////////////
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
////////////////////
    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }


}
