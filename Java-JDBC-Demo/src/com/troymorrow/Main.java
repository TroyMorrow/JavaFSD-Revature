package com.troymorrow;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int options = 0;
        EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();

        System.out.println("*********************");
        System.out.println("Select from the options below");
        System.out.println("*********************");
        System.out.println("1) Add Employee");
        System.out.println("2) Update Employee");
        System.out.println("3) Delete Employee");
        System.out.println("4) Read Employee");
        System.out.println("5) Read Employee by ID");
        System.out.println("6) Exit");
        System.out.println("*********************");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your option : ");
        options = scanner.nextInt();


        switch(options){
            case 1:{
                dao.startTranscation();
                System.out.println("Enter Name: ");
                String name = scanner.next();
                System.out.println("Enter email:");
                String email = scanner.next();
                Employee employee = new Employee();
                employee.setName(name);
                employee.setEmail(email);
                dao.addEmployee(employee);
                String confirm = scanner.next();
                if (confirm == "reject")
                    dao.rollbackTransaction();

                else
                    dao.commitTransaction();


                break;

            }
            case 2:{
                System.out.println("Enter Name: ");
                String name = scanner.next();
                System.out.println("Enter email:");
                String email = scanner.next();
                System.out.println("Enter ID:");
                int id = scanner.nextInt();
                Employee employee = new Employee();
                employee.setName(name);
                employee.setEmail(email);
                employee.setId(id);
                dao.updateEmployee(employee);
                break;

            }
            case 3:{
                System.out.println("Enter ID:");
                int id = scanner.nextInt();
                dao.deleteEmployee(id);
                break;
            }
            case 4:{
                List<Employee> employee = dao.getEmployee();
                for (Employee employees: employee){
                    System.out.println(employees);
                }
                break;
            }
            case 5:{
                System.out.println("Enter ID: ");
                int empId = scanner.nextInt();
                Employee employee = dao.employeeById(empId);
                System.out.println(employee);
                break;
            }
        }


    }
}
