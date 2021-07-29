package com.troymorrow.Day4;

import java.util.TreeSet;

public class Demo11 {
    public static void main(String[] args) {
        //create treeset
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Mark");
        treeSet.add("Watson");
        treeSet.add("John");
        treeSet.add("Apple");

        for (String name: treeSet){
            System.out.println(name);
        }
    }
}
