package com.troymorrow.Day1;

public class Demo1 {

    static int z = 100; // staic variable
    int x = 10; //instance variable

    public void addNumber(){
//        static in d = 10;  not allowed
        int a =10; // local variable
        int b = 20;
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        int y = 5;
        System.out.println(z - y);
    }

}
