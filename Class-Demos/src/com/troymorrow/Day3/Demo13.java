package com.troymorrow.Day3;

public class Demo13 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());
        sb.append("Hello");
        System.out.println(sb.capacity());
        sb.append("Welcome to java class, Have a nice day");
        System.out.println(sb.capacity());
    }
}
