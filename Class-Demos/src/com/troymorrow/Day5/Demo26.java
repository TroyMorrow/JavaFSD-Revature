package com.troymorrow.Day5;

import java.util.Scanner;

public class Demo26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first and last name");

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();

        System.out.println("Full name: " + firstName + " " + lastName);
    }
}
