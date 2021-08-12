package com.troymorrow.sqlconnector;

import com.troymorrow.sqlconnector.*;
import org.apache.log4j.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private  static  final Logger logger = LogManager.getLogger(Main.class);
    FileAppender fa = new FileAppender();



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
                    customer.setFirstName(firstName);
                    customer.setLastName(lastName);
                    customer.setEmail(email);
                    customer.setUsername(username);
                    customer.setPassword(password);
                    dao.addCustomer(customer);
                    System.out.println("\n");
                    System.out.println("Step 2) Account Application");
                    int id = customer.getId();
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
                        System.out.println("5) Exit Customer account");
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
                                        logger.info("Customer " + id + "deposited $" + amount + " to their account");
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
                                System.out.println("Enter Customer ID");
                                int id = scanner.nextInt();
                                Account account = new Account();
                                account.setAccStatus(status);
                                account.setCustId(id);
                                daoA.updateAccountStatus(account);
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

/*


                case 1: { //Add Customer
                    System.out.println("Enter Customer First Name: ");
                    String firstName = scanner.next();
                    System.out.println("Enter Customer Last Name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter Customer Email");
                    String email = scanner.next();
                    Customer customer = new Customer();
                    customer.setFirstName(firstName);
                    customer.setLastName(lastName);
                    customer.setEmail(email);
                    dao.addCustomer(customer);
                    break;
                }
                case 2: { //Update Customer
                    System.out.println("Enter Customer First Name: ");
                    String firstName = scanner.next();
                    System.out.println("Enter Customer Last Name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter Customer Email");
                    String email = scanner.next();
                    System.out.println("Enter Customer ID");
                    int id = scanner.nextInt();
                    Customer customer = new Customer();
                    customer.setFirstName(firstName);
                    customer.setLastName(lastName);
                    customer.setEmail(email);
                    customer.setId(id);
                    dao.updateCustomer(customer);


                    break;
                }
                case 3: { //Delete Customer
                    System.out.println("Enter Customer ID");
                    int id = scanner.nextInt();
                    dao.deleteCustomer(id);
                    break;
                }
                case 4: { //View All Customer // did print out list
                    List<Customer> customer = dao.getCustomer();
                    for (Customer customers: customer){
                        System.out.println(customers);
                    }
                    break;
                }
                case 5: { //View One Customer
                    System.out.println("Select Customer to view");
                    int custId = scanner.nextInt();
                    Customer customer = dao.getCustomerByID(custId);
                    System.out.println(customer);
                    break;
                }
                case 6: { // Add Employee
                    System.out.println("Enter Employee First Name: ");
                    String firstName = scanner.next();
                    System.out.println("Enter Employee Last Name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter Employee Email");
                    String email = scanner.next();
                    Employee employee = new Employee();
                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setEmail(email);
                    daoE.addEmployee(employee);
                    break;
                }
                case 7: { //Update Employee
                    System.out.println("Enter Employee First Name: ");
                    String firstName = scanner.next();
                    System.out.println("Enter Employee Last Name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter Employee Email");
                    String email = scanner.next();
                    System.out.println("Enter Employee ID");
                    int id = scanner.nextInt();
                    Employee employee = new Employee();
                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setEmail(email);
                    employee.setId(id);
                    daoE.updateEmployee(employee);
                    break;
                }
                case 8: { //Delete Employee
                    System.out.println("Enter Employee ID");
                    int id = scanner.nextInt();
                    daoE.deleteEmployee(id);
                    break;
                }
                case 9: { //Show all employee //Change array list
                    List<Employee> employee = daoE.getEmployee();
                    for (Employee employees: employee){
                        System.out.println(employees);
                    }
                    break;
                }
                case 10: { //Show Employee based on ID
                    System.out.println("Select Employee to view");
                    int empId = scanner.nextInt();
                    Employee employee = daoE.getEmployeeByID(empId);
                    System.out.println(employee);
                    break;
                }
                case 11: { //

                }
                case 12: { // update accounts
                    System.out.println("Enter transaction type");
                    String action = scanner.next();
                    System.out.println("Enter amount");
                    double amount = scanner.nextDouble();
                    System.out.println("Enter Employee ID");
                    int id = scanner.nextInt();
                    Account account = new Account();
                    double balance = account.getBalance();
                    if (action.equals("Deposit")){
                        balance += amount;
                    }else if (action.equals("Withdraw")){
                        balance -= amount;
                    }else {
                        System.out.println("Invalid Transaction type.");
                    }
                    account.setBalance(balance);
                    account.setAccID(id);
                    daoA.updateAccount(account);
                    break;
                }
                case 13: {

                }
                case 14: {

                }
                case 15: {

                }
                case 16: {
                    System.out.println("Exiting program...");
                    active = false;
                }
            }
            */
        }



    }
}
