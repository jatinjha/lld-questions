package com.jatin.multithreading.mutexlock;

public class ProduceItem implements Runnable{
    SharedResource sharedResource;

    public ProduceItem(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }


    @Override
    public void run() {
        System.out.println("current thread"+Thread.currentThread().getName());
        try {
            System.out.println("putting thread in sleep "+Thread.currentThread().getName());
            Thread.sleep(1000l);
        }catch (Exception ex){
            System.out.println("exception while sleep "+ex.getMessage());
        }
        sharedResource.produceItem();
    }
}
