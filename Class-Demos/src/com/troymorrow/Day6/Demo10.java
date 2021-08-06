package com.troymorrow.Day6;

import java.math.RoundingMode;

interface Hello{
    public String greeting();
}

interface Welcome{
    public String greeting(String name);
}

interface Calculation{
    public int addNumber(int a, int b);
}

interface Say{
    public void sayHello(String name);
}

public class Demo10 {
    public static void main(String[] args) {
        // no parametes
        Hello hello = ()->{
            return "Welcome Guest";
        };
        System.out.println(hello.greeting());
        // one parameter
        Welcome welcome = (name) -> {
            return "Welcome " + name;
        };
        System.out.println(welcome.greeting("Paul"));

        // multiple parameters
        Calculation calculation = (a,b) -> {
            return a + b;
        };
        System.out.println(calculation.addNumber(20,30));

        Say say = (name) -> {
            System.out.println("Hello " + name);
        };
        say.sayHello("watson");
        
    }
}
