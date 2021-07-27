package com.troymorrow.Day1;

class Car1{
    public String name;
    public String color;
    public int price;
    public String engineType;

    public Car1(String name, String color, int price, String engineType){
        this.name = name;
        this.color = color;
        this.price = price;
        this.engineType = engineType;
    }
}
public class Demo21 {
    public static void main(String[] args) {
        Car1 car1 = new Car1("Audi", "White", 10000, "Petrol");
    }
}
