package com.troymorrow.sqlconnector;

public class Account {
    private int accID;
    private int custId;
    private String firstName;
    private String lastName;
    private String accType;
    private double balance;
    private String accStatus;

    // for inner join on Account and Customer


    public Account(){}

    public Account (int accId, int custId, String accType, double balance, String accStatus){
        this.accID = accId;
        this.custId = custId;
        this.accType = accType;
        this.balance = balance;
        this.accStatus = accStatus;
    }

    public Account(int accID, int custId, String firstName, String lastName, String accType, double balance, String accStatus){
        this.accID = accID;
        this.custId = custId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accType = accType;
        this.balance = balance;
        this.accStatus = accStatus;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accID=" + accID +
                ", custId=" + custId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accType='" + accType + '\'' +
                ", balance=" + balance +
                ", status='" + accStatus + '\'' +
                '}';
    }
}
