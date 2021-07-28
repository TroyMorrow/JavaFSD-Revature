package com.troymorrow.Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo28 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader("data.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){

        } finally {
            if(bufferedReader != null){
                try{
                    bufferedReader.close();
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
