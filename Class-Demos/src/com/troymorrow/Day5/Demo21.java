package com.troymorrow.Day5;

import java.io.FileWriter;
import java.io.IOException;

public class Demo21 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("data2.txt",true);

        fw.write(100);
        fw.write("This is some message222111");
        fw.write("\n");
        char[] c1 = {'a','b','c'};
        fw.write(c1);
        fw.write("\n");

        fw.flush();
    }
}