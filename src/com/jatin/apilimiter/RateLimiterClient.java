package com.jatin.apilimiter;

import com.jatin.apilimiter.factories.RateLimiterFactory;
import com.jatin.apilimiter.model.Client;
import com.jatin.apilimiter.model.Identifier;
import com.jatin.apilimiter.model.Rule;
import com.jatin.apilimiter.services.CacheService;
import com.jatin.apilimiter.services.RateLimiterService;
import com.jatin.apilimiter.services.RuleService;
import com.jatin.apilimiter.strategies.SlidingWindowCounterStrategy;
import com.jatin.apilimiter.strategies.ThrottleStrategy;
import com.jatin.apilimiter.strategies.TokenBucketThrottleStrategy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RateLimiterClient {
    public static void main(String[] args) {
        System.out.println("rate limiter program starts ");

        Client client = RateLimiterFactory.getClient("client1");
        Rule rule = RateLimiterFactory.getRule(2,2);
        Identifier identifier = RateLimiterFactory.getIdentifier("api_key");
        RuleService ruleService = RateLimiterFactory.getRuleService();

        SlidingWindowCounterStrategy slidingWindowCounterStrategy = RateLimiterFactory.getSlidingWindowThrottleStrategy(2,1000);
        RateLimiterService rateLimiterService = RateLimiterFactory.getRateLimiterService(slidingWindowCounterStrategy);

        try {
            ruleService.addRule(client,identifier,rule);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExecutorService executorService = new ThreadPoolExecutor(2,4,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2));
        executorService.submit(()->{
            for(int i=0 ; i<10 ; i++){
                //System.out.println("call rate limiter from thread "+i);
                if(i>=3&&i<=6){
                    try {
                        System.out.println("sleep thread "+i);
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("is valid request : - "+rateLimiterService.checkValidRequest(client,identifier));
            }
        });

        executorService.shutdown();
        System.out.println("rate limiter program end main thread");
    }
}
