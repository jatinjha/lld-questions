package com.jatin.multithreading.poolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDriver {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                5000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5), new CustomThreadFactory(), new CustomRejectHandler());


        threadPoolExecutor.allowCoreThreadTimeOut(true);

        for(int i=0 ; i<8 ; i++){
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread Name : "+Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();
    }


}
