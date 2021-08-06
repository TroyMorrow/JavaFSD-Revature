package com.troymorrow.Day6;

//interface Rectangle{
//    public void draw();
//}
//
//class Test implements Rectangle{
//
//    @Override
//    public void draw() {
//        System.out.println("drawing....");
//    }
//}

interface Rectangle{
    void draw();
}

public class Demo9 {
    public static void main(String[] args) {
        // 1st way
//        Test test = new Test();
//        test.draw();

        // 2nd way
//        Rectangle rectangle = new Rectangle() {
//            @Override
//            public void draw() {
//                System.out.println("drawing...");
//            }
//        };
//        System.out.println(rectangle);

        // 3rd way Using lambda
        Rectangle rectangle = () -> {
            System.out.println("drawing...");
        };
        rectangle.draw();


    }
}
