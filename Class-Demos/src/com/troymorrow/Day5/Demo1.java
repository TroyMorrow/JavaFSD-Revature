package com.troymorrow.Day5;

class MultiThreadDemo extends Thread{
    @Override
    public void run(){
        System.out.println("thread is coming");
    }
}

public class Demo1 {
    public static void main(String[] args) {
        MultiThreadDemo threadDemo = new MultiThreadDemo();
        threadDemo.start();
    }
}
