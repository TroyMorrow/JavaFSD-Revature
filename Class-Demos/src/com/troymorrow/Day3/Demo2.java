package com.troymorrow.Day3;

public class Demo2 {
    public static void main(String[] args) {
        String str1 = "Hello";
        str1.concat("World"); // using concat method to append string
        System.out.println(str1);

        String str2 = "Hello";
        str2 = str2.concat("World");
        System.out.println(str2);
    }
}
