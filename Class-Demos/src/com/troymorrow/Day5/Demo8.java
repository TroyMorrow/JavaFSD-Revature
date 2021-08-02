package com.troymorrow.Day5;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

class WorkerThread implements Runnable{

    private String message;
    public WorkerThread(String message){
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start message -> " + message);
        processMessage();;
        System.out.println(Thread.currentThread().getName() + "End message -> " + message);
    }

    private void processMessage(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Demo8 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++){
            Runnable worker = new WorkerThread("" + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("Finished all threads");
    }
}

