package com.jatin.multithreading.mutexlock;

public class ConsumeItem implements Runnable{

    SharedResource sharedResource;

    public ConsumeItem(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("current thread in consume "+Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
