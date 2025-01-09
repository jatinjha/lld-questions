package com.jatin.multithreading.mutexlock;

public class DriverClass {
    public static void main(String[] args) {

        System.out.println("main method start");

        SharedResource sharedResource = new SharedResource();
        Thread taskOne = new Thread(new ProduceItem(sharedResource));
        Thread taskTwo = new Thread(new ConsumeItem(sharedResource));

        taskOne.start();
        taskTwo.start();

        System.out.println("main method end");

    }
}
