package com.jatin.multithreading.consumerproducerqueueproblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> queue;
    private int bufferSize;

    public SharedResource(int  bufferSize){
        this.bufferSize = bufferSize;
        queue = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        Thread.sleep(1000);
        while(queue.size()==bufferSize){
            System.out.println("buffer size is full producer is waiting");
            wait();
        }
        System.out.println("Thread producing item "+Thread.currentThread().getName()+"element produced in queue -> "+item);
        queue.add(item);
        notify();
    }


    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()){
            System.out.println("buffer is empty consumer is waiting");
            wait();
        }
        System.out.println("Thread consuming item "+Thread.currentThread().getName()+"element consumed from queue -> "+queue.poll());
        notify();
    }
}
