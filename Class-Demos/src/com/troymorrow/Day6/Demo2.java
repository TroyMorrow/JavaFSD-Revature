package com.troymorrow.Day6;

import java.util.ArrayList;
import java.util.Collections;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> letters = new ArrayList<>();
        letters.add("c");
        letters.add("d");
        letters.add("a");
        letters.add("e");
        letters.add("b");

        System.out.println("Before sorting...");
        for (String letter: letters){
            System.out.println(letter);
        }

        Collections.sort(letters);
        System.out.println("After sorting...");
        for (String letter: letters){
            System.out.println(letter);
        }

    }
}
