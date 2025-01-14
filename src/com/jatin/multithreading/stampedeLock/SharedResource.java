package com.jatin.multithreading.stampedeLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int item = 2;
    StampedLock stampedLock = new StampedLock();


    public void produceItem(){
        long stampId = stampedLock.writeLock();
        System.out.println("write lock acquired by thread "+Thread.currentThread().getName()+" lock id "+stampId);

        try{
            if(stampedLock.validate(stampId)){
                System.out.println("stamped write matched value");
                item = 9;
                Thread.sleep(1000);
            }else{
                System.out.println("stamp write value is not matching error ");
            }

        }catch (Exception ex){
            System.out.println("excepton in thread "+ex.getMessage());
        }finally {
            System.out.println("unlocking lock "+stampId);
            stampedLock.unlock(stampId);
        }
    }
    public void consumeItem(){
        long stampId = stampedLock.tryOptimisticRead();
        System.out.println("read lock acquired by thread : "+Thread.currentThread().getName()+" lock id "+stampId);

        try {
            if(stampedLock.validate(stampId)){
                System.out.println("stamp read matched value");
                item = 4;
            }
            else{
                System.out.println("stamp read value is not matching error ");
            }
        }finally {
            System.out.println("unlocking lock : "+stampId);
            stampedLock.unlock(stampId);
        }

    }
}
