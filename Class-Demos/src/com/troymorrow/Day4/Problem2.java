package com.troymorrow.Day4;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    public static void main(String[] args) {
        Map customer = new HashMap<>();
        customer.put("Account#", 4564);
        customer.put("LastName", "Johnson");
        customer.put("FirstName", "Linda");
        customer.put("Email", "lj@gmail.com");

        System.out.println(customer);
        System.out.println(customer.size());

        Map customer2 = new HashMap<>();
        customer2.put("Account#", 3337);
        customer2.put("LastName", "Henderson");
        customer2.put("FirstName", "Ralph");
        customer2.put("Email", "rh@gmail.com");

        customer.putAll(customer2);
        System.out.println(customer);
    }
}
