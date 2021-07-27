package com.troymorrow.Day2;

interface ICustomer{

}

class Customer implements ICustomer{

}
public class Demo26 {
    public static void main(String[] args) {
        Customer customer = new Customer();
        ICustomer iCustomer = new Customer(); // interface holds reference of a class

    }
}
