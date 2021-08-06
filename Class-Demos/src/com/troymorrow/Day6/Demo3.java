package com.troymorrow.Day6;

import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee>{
    public int id;
    public String name;
    public int age;

    public Employee(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee other) {
        if (id > other.id)
            return 1;
        else if (id < other.id)
            return -1;
        else
            return 0;

    }
}

public class Demo3 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(2, "Mark", 30));
        employees.add(new Employee(3, "Watson", 40));
        employees.add(new Employee(1, "Paul", 50));

        System.out.println("Before sorting..");
        for (Employee employee: employees){
            System.out.println(employee);
        }

        Collections.sort(employees);
        Collections.reverse(employees);
        System.out.println("After sorting..");
        for (Employee employee: employees){
            System.out.println(employee);
        }
    }
}
