package com.jatin.multithreading.stampedeLock;

public class StampedDriver {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(()->{
           sharedResource.produceItem();
        });
        Thread t2 = new Thread(()->{
            sharedResource.produceItem();
        });
        Thread t3 = new Thread(()->{
            sharedResource.produceItem();
        });
        Thread t11 = new Thread(()->{
            sharedResource.consumeItem();
        });
        Thread t22 = new Thread(()->{
            sharedResource.consumeItem();
        });
        Thread t33 = new Thread(()->{
            sharedResource.consumeItem();
        });

        t33.start();
        t2.start();
        t3.start();
        t11.start();
        t22.start();
        t1.start();

    }
}
