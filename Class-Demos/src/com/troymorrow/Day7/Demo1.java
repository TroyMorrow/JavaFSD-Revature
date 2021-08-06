package com.troymorrow.Day7;

class Calculator{
//    public boolean areEqual(int a, int b){
//        if(a == b)
//            return true;
//        else
//            return false;
//    }

    public boolean areEqual(Object a, Object b){
        if (a.equals(b))
            return true;
        else
            return false;
    }

}

public class Demo1 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        boolean result = cal.areEqual("A","A");
        if(result)
            System.out.println("Numbers are equal");
        else
            System.out.println("Numbers are not equal");
    }
}
