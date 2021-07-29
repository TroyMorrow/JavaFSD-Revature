package com.troymorrow.Day4;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo8 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Mark");
        names.add("Paul");
        names.add("Watson");

        names.add(0,"John");
        System.out.println(names);

        LinkedList<String> namesNew = new LinkedList<>();
        namesNew.add("Stacy");
        namesNew.add("Smith");

//        names.addAll(namesNew);

        names.addAll(0,namesNew);
        System.out.println(names);

        names.addFirst("First");
        System.out.println(names);

        names.addLast("last");
        System.out.println(names);

        names.add("John");
        names.add("Paul");
        System.out.println(names);

//        names.removeFirstOccurrence("John");
        names.removeLastOccurrence("John");
        System.out.println(names);

        System.out.println("original");
        System.out.println(names);

        System.out.println("\n");
        Iterator iterator = names.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(int i = names.size() -1; i <= 0; i++){
            System.out.println(names.get(i));
        }

    }
}
