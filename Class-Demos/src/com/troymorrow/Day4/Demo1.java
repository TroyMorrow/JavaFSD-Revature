package com.troymorrow.Day4;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> mlist = new ArrayList<String>();

        mlist.add("Mark");
        mlist.add("Paul");
        mlist.add("Watson");

        System.out.println(mlist);

        Iterator iterator = mlist.iterator();
        //hasNext() will check if iterator has the element
        while(iterator.hasNext()){
            System.out.println(iterator.next()); // print the element and move the cursor to the next
        }

//        for (String name: mlist){
//            System.out.println(name);
//        }
    }
}
