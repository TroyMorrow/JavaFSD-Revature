package com.troymorrow.Day7;

import java.util.ArrayList;
import java.util.List;

abstract class Shape{
    abstract void draw();
}

class Rectangle extends Shape{
    @Override
    void draw() {
        System.out.println("drawing rectangle...");
    }
}

class Circle extends Shape{
    @Override
    void draw() {
        System.out.println("drawing circle...");
    }
}

class Cone {

    void draw() {
        System.out.println("drawing cone...");
    }
}

class Test{
    //creating a method that accepts only a child class of shape
    public static void drawShape(List<? extends Shape> list){
        for (Shape shape: list){
            shape.draw();
        }
    }
}

public class Demo7 {
    public static void main(String[] args) {
        List<Rectangle> rectangleList = new ArrayList<>();
        List<Circle> circleList = new ArrayList<>();
        List<Cone> coneList = new ArrayList<>();

        Test.drawShape(rectangleList);
        Test.drawShape(circleList);
//        Test.drawShape(coneList); // Make sure when using generics that the correct classes extend
    }
}
