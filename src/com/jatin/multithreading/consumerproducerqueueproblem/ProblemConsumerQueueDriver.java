package com.jatin.multithreading.consumerproducerqueueproblem;

public class ProblemConsumerQueueDriver {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(4);

        Thread t1 = new Thread(()->{
            try{
                for (int i=0 ; i<7 ; i++){
                    sharedResource.produce(i);
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        });

        Thread t2 = new Thread(()->{
            try{
                for (int i=0 ; i<7 ; i++){
                    sharedResource.consume();
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        });

        t1.start();
        t2.start();

    }
}
