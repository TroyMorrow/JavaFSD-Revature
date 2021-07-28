package com.troymorrow.Day3;

public class Demo22 {
    public static void main(String[] args) {
        //case 1: exception not occur
        try{
            int c = 10 / 5;
            System.out.println(c);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally{
            System.out.println("Case 1: finally called");
        }

        //Case 2: exception occured but not handled
        try{
            int c = 20 / 0;
            System.out.println(c);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Case 2: Finally called");
        }

        //Case 3: exception occured and handled
        try{
            int c = 10 / 0;
            System.out.println(c);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Case 3: Finally called");
        }
    }
}
