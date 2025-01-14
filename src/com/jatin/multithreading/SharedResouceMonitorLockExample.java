package com.jatin.multithreading;

public class SharedResouceMonitorLockExample {
    int item;

    public SharedResouceMonitorLockExample(int item) {
        this.item = item;
    }

    public synchronized void incrementItem(){


        //item++;
        try {
            Thread.sleep(4000);
            System.out.println("increase item value by Thread "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void printValue(){
        System.out.println("value access by Thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
