package dev.dto;

public class Transaction {
    /// DECLARE FIELDS
    private int routingNumber;
    private long transactionId;
    private int customerId;
    private double amount;

    ///DECLARE CONSTRUCTOR
    public Transaction(int routingNumber, long transactionId,  int customerId, double amount) {
        this.routingNumber = routingNumber;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.amount = amount;
    }
    ///GETTERS AND SETTERS; frameworks for DTOs include both
    public int getRoutingNumber() {
        return routingNumber;
    }
    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }
    public long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    ///TOSTRING
    @Override
    public String toString() {
        ///15digit 0-filled routing number, 20digit 0-filled customerID, 15digit 0-filled transactionID, 12digit-0-filled double amount
        return "%015d:%020d:%015d:%012.2f".formatted(routingNumber, customerId, transactionId, amount);
    }
}
