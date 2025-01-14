package com.jatin.multithreading;

public class MonitorLockExampleDriver {


    public static void main(String[] args) {

        SharedResouceMonitorLockExample sharedResouceMonitorLockExample = new SharedResouceMonitorLockExample(1);
        Thread t1 = new Thread(() -> {
            SharedResouceMonitorLockExample.printValue();
        });

        Thread t2 = new Thread(() -> {
            sharedResouceMonitorLockExample.incrementItem();
        });

        t1.start();
        t2.start();

    }

}
