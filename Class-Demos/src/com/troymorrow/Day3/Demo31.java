package com.troymorrow.Day3;


import java.io.*;

public class Demo31 {
    public static void main(String[] args) {
        // try block to check for exception
        try(FileOutputStream stream = new FileOutputStream("C:\\Users\\beavs\\IdeaProjects\\Class-Demos\\src\\com\\troymorrow\\Day3\\data.txt")){ //creating an object of FOS
            //customer string input
            String data = "Hello World";
            //convert string to bytes
            byte[] arr = data.getBytes();
            stream.write(arr);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("resources are closed");
    }
}
