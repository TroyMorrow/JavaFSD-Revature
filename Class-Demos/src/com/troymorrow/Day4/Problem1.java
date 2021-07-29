package com.troymorrow.Day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Problem1 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("purple");

        System.out.println(colors);

        Iterator iterator = colors.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        colors.add(0, "orange"); //add orange as index 1
        colors.set(2, "yellow"); // changed index 2 from blue to yellow

        System.out.println(colors);
        System.out.println(colors.get(3));

        colors.remove(3); // remove value at index
        System.out.println(colors);
        System.out.println(colors.contains("orange"));

        Collections.sort(colors); //sort array
        System.out.println(colors);

        ArrayList<String> colors2 = new ArrayList<>(); // create new array
        colors2.add("teal");
        colors2.add("mint");
        colors2.add("pink");
        colors2.add("white");

        colors.addAll(colors2); // add second array to first array
        System.out.println(colors);

        Collections.shuffle(colors); // Shuffles ArrayList
        System.out.println(colors);

        // This reverses the order of the Arraylist after it was shuffled
        Collections.reverse(colors); // reverses order of ArrayList
        System.out.println(colors);

        System.out.println(colors.subList(3,6)); //print sublist of indexes 3 to 6

        Collections.swap(colors, 0, 5); // swaps values of indexes 0 and 5
        System.out.println(colors);

    }
}
