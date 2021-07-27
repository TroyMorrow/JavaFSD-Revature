package com.troymorrow.Day2;

interface Drawable{
    void draw(); //abstract
    default void print(){ //using default keyword allows for method to be used in interface
        System.out.println("printing...");
    }
}

class Rect implements Drawable{

    @Override
    public void draw() {
        System.out.println("drawing...");
    }
}
public class Demo22 {
    public static void main(String[] args) {
        Rect rectObj = new Rect();
        rectObj.draw();
        rectObj.print();
    }
}
