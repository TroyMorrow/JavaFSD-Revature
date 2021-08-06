package com.troymorrow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean active = true;
        while(active){
            System.out.println("******************");
            System.out.println("Please select one of our program options.");
            System.out.println("1) Add Customer");
            System.out.println("2) Update Customer");
            System.out.println("3) Delete Customer");
            System.out.println("4) View All Customer");
            System.out.println("5) View One Customer");
            System.out.println("6) Add Employee");
            System.out.println("7) Update Employee");
            System.out.println("8) Delete Employee");
            System.out.println("9) View All Employees");
            System.out.println("10) Add Accounts");
            System.out.println("11) Update Accounts");
            System.out.println("12) Delete Accounts");
            System.out.println("13) View All Accounts");
            System.out.println("14) View One Account");
            System.out.println("15) View Transactions");

            int choice = scanner.nextInt();
            switch (choice){
                case 1: { //Add Customer

                }
                case 2: { //Update Customer

                }
                case 3: { //Delete Customer

                }
                case 4: { //View All Customer

                }
                case 5: { //View One Customer

                }
                case 6: { // Add Employee

                }
                case 7: { //Update Employee

                }
                case 8: { //Delete Employee

                }
            }
        }

    }
}
