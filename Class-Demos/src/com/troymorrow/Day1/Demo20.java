package com.troymorrow.Day1;

class Calculator{
    int a = 10;
    int b = 20;

    public Calculator(){
        System.out.println("Parameter less constructor");
    }
    public Calculator(int x, int y){
        this.a = x;
        this.b = y;
    }

    public void addNumber(){
        System.out.println(a + b);
    }
}
public class Demo20 {
    public static void main(String[] args) {
        Calculator cal1 = new Calculator();
        cal1.addNumber();

        Calculator cal2 = new Calculator(100, 200);
        cal2.addNumber();
    }
}
