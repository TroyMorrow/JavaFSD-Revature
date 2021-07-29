package com.troymorrow.Day4;

import java.util.ArrayList;

public class Demo6 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Mark");
        names.add("Paul");
        names.add("Stacy");
        names.add("Watson");
        System.out.println(names);

        //getting element on a specified index
        System.out.println(names.get(1));

        //adding the element to specified index
        names.add(1, "John");
        System.out.println(names);

        // merge two lists
        ArrayList<String> newNames = new ArrayList<>();
        newNames.add("Rangel");
        newNames.add("Smith");
//        names.addAll(newNames);
        names.addAll(0,newNames);


        System.out.println(names);

        //remove
//        names.remove("Mark");
        System.out.println(names);

        //index remove
//        names.remove(0);
        System.out.println(names);

        names.removeAll(newNames);
        System.out.println(names);

        names.removeIf(name -> name.contains("Paul"));
        System.out.println(names);
    }
}
