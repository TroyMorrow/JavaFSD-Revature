package com.troymorrow.Day6;

//class Car{
//    Engine engine;
//    Tire tire;
//
//    public Car(){
//        this.engine = new Engine();
//        this.tire = new Tire();
//    }
//}
//
//class Engine{
//    public Engine(String type){}
//}
//
//class Tire{
//    public Tire(String type){
//
//    }
//}

class Engine{

}

class Tire{

}

class CarFactory2{
    public static void getInstance(int id){
        switch (id){
            case 0:
                System.out.println("");
                break;
            case 1:
                System.out.println("");
                break;
        }
    }
}

class Car{
    Engine engine;
    Tire tire;

    public Car(Engine engine, Tire tire){
        this.engine = engine;
        this.tire = tire;

    }
}


public class Demo7 {
}
