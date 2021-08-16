package com.troymorrow.sqlconnector;

import com.troymorrow.sqlconnector.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        DAOCustomer dao = DAOCustFactory.getDaoCustomer();
        DAOEmployee daoE = DAOEmpFactory.getDaoEmployee();
        DAOAccount daoA = DAOAccFactory.getDaoAccount();

        boolean active = true;
        while(active){
            System.out.println("******************");
            System.out.println("Log in or Sign up ");
            System.out.println("1) Apply for Customer Account");
            System.out.println("2) Log into Customer Account");
            System.out.println("3) Log into Employee Account");
            System.out.println("4) Exit ");
            System.out.println("******************");
            int access = scanner.nextInt();
            switch (access){
                case 1: {
                    System.out.println("New Customer Application");
                    System.out.println("Please enter the following Information");
                    System.out.println("Step 1) Customer Info");
                    System.out.println("Enter Customer ID");
                    int id = scanner.nextInt();
                    System.out.println("Enter Customer First Name: ");
                    String firstName = scanner.next();
                    System.out.println("Enter Customer Last Name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter Customer Email");
                    String email = scanner.next();
                    System.out.println("Create a Username");
                    String username = scanner.next();
                    System.out.println("Create a Password");
                    String password = scanner.next();
                    Customer customer = new Customer();
                    customer.setId(id);
                    customer.setFirstName(firstName);
                    customer.setLastName(lastName);
                    customer.setEmail(email);
                    customer.setUsername(username);
                    customer.setPassword(password);
                    dao.addCustomer(customer);

                    System.out.println("\n");
                    System.out.println("Step 2) Account Application");
                    int id1 = customer.getId();
                    System.out.println("Enter Account Type. Either Savings or Checking");
                    String type = scanner.next();
                    System.out.println("Enter Starting Balance");
                    double balance = scanner.nextDouble();
                    Account account = new Account();
                    account.setCustId(id);
                    account.setAccType(type);
                    account.setBalance(balance);
                    daoA.addAccount(account);
                    break;
                }
                case 2: {
//                    List<Customer> customers = dao.getCustomer();
                    System.out.println("Customer Log In");
                    Customer customer = new Customer();
                    System.out.println("Enter Username");
                    String username = scanner.next();
                    System.out.println("Enter password");
                    String password = scanner.next();
                    customer = dao.getCustomerByLogin(username, password);

                    boolean custActive = true;
                    while (custActive) {

                        System.out.println(customer);
                        System.out.println("*******************");
                        System.out.println("1) Update customer account");
                        System.out.println("2) Delete Customer account");
                        System.out.println("3) View Bank account");
                        System.out.println("4) Update bank account");
                        System.out.println("5) Transfer Funds");
                        System.out.println("6) Approve/Reject Transfer of Funds");
                        System.out.println("7) Exit Customer account");
                        System.out.println("*******************");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1: { // Update Customer Account
                                System.out.println("Enter Customer First Name: ");
                                String firstName = scanner.next();
                                System.out.println("Enter Customer Last Name: ");
                                String lastName = scanner.next();
                                System.out.println("Enter Customer Email");
                                String email = scanner.next();
//                                System.out.println("Enter Customer ID");
                                int id = customer.getId();
                                customer.setFirstName(firstName);
                                customer.setLastName(lastName);
                                customer.setEmail(email);
                                customer.setId(id);
                                dao.updateCustomer(customer);
                                break;
                            }
                            case 2: { // Delete Customer Account
                                System.out.println("Enter Customer ID");
                                int id = scanner.nextInt();
                                dao.deleteCustomer(id);
                                break;
                            }
                            case 3: { // View bank account
                                System.out.println("Enter Customer ID");
                                int custId = scanner.nextInt();
                                List<Account> account = daoA.accountById(custId);
                                for (Account accounts : account)
                                    System.out.println(accounts);
                                break;
                            }
                            case 4: { //Update Customer Bank Account
                                System.out.println("Enter transaction type");
                                String action = scanner.next();
                                System.out.println("Enter amount");
                                double amount = scanner.nextDouble();
                                System.out.println("Enter Account ID");
                                int id = scanner.nextInt();
                                Account account = new Account();
                                double balance;
                                if (action.equals("deposit")) {
                                    if (amount > 0) {
                                        balance = account.getBalance() + amount;
                                        account.setBalance(balance);
                                        account.setAccID(id);
                                        daoA.updateAccount(account);
                                    }else {
                                        System.out.println("Invalid Transaction");
                                    }
                                } else if (action.equals("withdraw")) {
                                    if (amount > 0) {
                                        balance = account.getBalance() - amount;
                                        account.setBalance(balance);
                                        account.setAccID(id);
                                        daoA.updateAccount(account);
                                    }else {
                                        System.out.println("Invalid Transaction");
                                    }
                                } else {
                                    System.out.println("Invalid Transaction type.");
                                }
                                break;
                            }
                            case 5: {
                                System.out.println("Transfer Funds");
                                System.out.println("Enter Amount");
                                double amount = scanner.nextDouble();
                                System.out.println("Enter First Account ID");
                                int id1 = scanner.nextInt();
                                System.out.println("Enter Second Account ID");
                                int id2 = scanner.nextInt();
                                List<Account> account = daoA.transferFunds(amount, id1, id2);
                                for (Account accounts : account)
                                    System.out.println(accounts);
                                break;

                            }
                            case 6:{
                                System.out.println("Approve or Reject transfer of Funds");
                                System.out.println("Input Approve to accept, or Reject to deny");
                                String response = scanner.next();
                                List<Account> account = daoA.approveRejectFunds(response);
                                for (Account accounts : account)
                                    System.out.println(accounts);
                                break;
                            }
                            case 7: {
                                System.out.println("Exiting Customer Page...");
                                custActive = false;
                            }
                        }

                    }
                    continue;


                }
                case 3: {
                        System.out.println("Employee Log In");
                        System.out.println("Enter Username");
                        String username = scanner.next();
                        System.out.println("Enter password");
                        String password = scanner.next();
                        Employee employee = daoE.getEmployeeByLogin(username, password);
                        boolean empActive = true;
                        while (empActive) {
                        System.out.println(employee);

                        System.out.println("*******************");
                        System.out.println("1) Update Employee account");
                        System.out.println("2) Delete Employee account");
                        System.out.println("3) View Bank account");
                        System.out.println("4) View Customer account applications");
                        System.out.println("5) Approval/Rejection of Customer Applications");
                        System.out.println("6) View Transaction Log");
                        System.out.println("7) Exit");
                        System.out.println("*******************");

                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1: { //update employee account
                                System.out.println("Enter Employee First Name: ");
                                String firstName = scanner.next();
                                System.out.println("Enter Employee Last Name: ");
                                String lastName = scanner.next();
                                System.out.println("Enter Employee Email");
                                String email = scanner.next();
                                System.out.println("Enter Employee ID");
                                int id = scanner.nextInt();
                                employee.setFirstName(firstName);
                                employee.setLastName(lastName);
                                employee.setEmail(email);
                                employee.setId(id);
                                daoE.updateEmployee(employee);
                                break;
                            }
                            case 2: {//Delete Employee Account
                                System.out.println("Enter Employee ID");
                                int id = scanner.nextInt();
                                daoE.deleteEmployee(id);
                                break;
                            }
                            case 3: {// View Customer accounts
                                System.out.println("Enter Customer ID");
                                int custId = scanner.nextInt();
                                List<Account> account = daoA.accountById(custId);
                                for (Account accounts : account)
                                    System.out.println(accounts);
                                break;

                            }
                            case 4: { // Customer Account Applications
                                System.out.println("Enter Status As Pending");
//                                String status = scanner.next();
                                List<Account> account = daoA.accountByStatus();
                                for (Account accounts : account)
                                    System.out.println(accounts);
                                break;
                            }
                            case 5: {
                                System.out.println("Enter Status");
                                String status = scanner.next();
                                System.out.println("Enter Account ID");
                                int id = scanner.nextInt();
                                Account account = new Account();
                                account.setAccStatus(status);
                                account.setAccID(id);
                                daoA.updateAccountStatus(account);
                                break;
                            }
                            case 6: {// View Logs
                                break;
                            }
                            case 7: {
                                System.out.println("Exiting Employee Page...");
                                empActive = false;
                            }
                        }
                    }
                    continue;
                }
                case 4: {
                    System.out.println("Exiting Program...");
                    active = false;
                }

            }


        }



    }
}
