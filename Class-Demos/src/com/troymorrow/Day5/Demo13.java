package com.troymorrow.Day5;

public class Demo13 {
    public static void main(String[] args) {
        final String resource1 = "First resource";
        final String resource2 = "Second resource";

        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (resource1){
                    System.out.println("Thread 1: Locked resource 1");
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    synchronized (resource2){
                        System.out.println("Thread 1: Locked resource 2");
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (resource2){
                    System.out.println("Thread 2: Locked resource 2");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource1){
                        System.out.println("Thread 2: Locked resource 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
