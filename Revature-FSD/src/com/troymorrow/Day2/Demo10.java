package com.troymorrow.Day2;

class Bank{
    public int getRateOfInterest(){
        return 0;
    }

}

class BankA extends Bank{
    public int getRateOfInterest(){
        return 7;
    }
}

class BankB extends Bank{
    public int getRateOfInterest(){
        return 8;
    }
}
public class Demo10 {
    public static void main(String[] args) {
        BankA bankA = new BankA();
        BankB bankB = new BankB();

        System.out.println(bankA.getRateOfInterest());
        System.out.println(bankB.getRateOfInterest());
    }
}
