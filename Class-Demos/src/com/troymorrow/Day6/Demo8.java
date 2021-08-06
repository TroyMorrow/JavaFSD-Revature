package com.troymorrow.Day6;

interface IBank{
    void deposit(int amount);
    void withdraw(int amount);
}

class SavingAccount implements IBank{

    @Override
    public void deposit(int amount) {
        System.out.println("deposit amount: " + amount);
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("withdraw amount: " + amount);
    }
}

class CurrentAccount implements IBank{

    @Override
    public void deposit(int amount) {
        System.out.println("deposit amount: " + amount);
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("withdraw amount: " + amount);
    }
}

class LoanAccount implements IBank{
    @Override
    public void deposit(int amount) {
        System.out.println("deposit amount: " + amount);
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("withdraw amount: " + amount);
    }
}

class Factory{
    public static IBank getAccount(int id){
        switch (id){
            case 1:
                return new SavingAccount();
            case 2:
                return new CurrentAccount();
            case 3:
                return new LoanAccount();
            default:
                return null;
        }
    }
}

enum AccountType{
    SAVING_ACCOUNT,
    CURRENT_ACCOUNT,
    LOAN_ACCOUNT
}

public class Demo8 {
    public static void main(String[] args) {
//        SavingAccount account = new SavingAccount();
//        CurrentAccount account1 = new CurrentAccount();

        IBank account = Factory.getAccount(1);
    }
}
