package com.troymorrow.Day3;

public class Demo1 {
    public static void main(String[] args) {
        String s1 = "Hello";
        char ch[] = {'H', 'e', 'l', 'l', 'o'};

        String s2 = new String(ch);
        String s3 = new String("World");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
