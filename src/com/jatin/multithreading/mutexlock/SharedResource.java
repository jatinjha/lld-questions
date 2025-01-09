package com.jatin.multithreading.mutexlock;

public class SharedResource {
    boolean isItemAvailable = false;

    public synchronized void consumeItem(){
        System.out.println("consuming item with thread : "+Thread.currentThread().getName());
        while (!isItemAvailable) {
            try {
                System.out.println("putting this thread in waiting : " + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("item consumed by thread :"+Thread.currentThread().getName());
        isItemAvailable = false;
    }

    public synchronized void produceItem(){
        System.out.println("item produced by thread"+Thread.currentThread().getName());
        isItemAvailable = true;
        notifyAll();
    }

}
