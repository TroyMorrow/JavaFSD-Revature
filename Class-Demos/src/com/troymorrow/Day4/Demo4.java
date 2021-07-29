package com.troymorrow.Day4;

import java.util.ArrayList;

public class Demo4 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Mark");
        names.add("Paul");
        names.add("Stacy");
        names.add("Watson");

        //for
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }

        //for each
        names.forEach(name -> {
            System.out.println(name);
        });

    }
}
