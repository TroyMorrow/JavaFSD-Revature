package com.troymorrow;

class CarInfo{
    public String make;
    public String model;
    public int year;
    public int miles;

    public void printCarInfo(){
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year + ", Miles: " + miles);
    }
}

public class Car {
    public static void main(String[] args) {
        CarInfo car1 = new CarInfo();
        car1.make = "Honda";
        car1.model = "Accord";
        car1.year = 2005;
        car1.miles = 87_000;

        car1.printCarInfo();
    }
}
