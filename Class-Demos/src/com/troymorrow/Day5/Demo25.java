package com.troymorrow.Day5;

public class Demo25 {
    public static void main(String[] args) {
        //try to convert all primitive type into corresponding wrapper class

        byte a = 10;
        short b = 20;
        int c = 30;
        long d = 40;
        float e = 12.3f;
        double f = 12.14;
        char g = 'a';
        boolean h = true;

        //autoboxing: converting primitives into objects
        Byte byteObj = a;
        Short shortObj = b;

        //unboxing: convert object into primitive
        byte byteValue = byteObj;
        short shortValue = shortObj;
    }
}
