package com.jatin.apilimiter.strategies;

public class TokenBucketThrottleStrategy implements ThrottleStrategy{

    private final long maxBucketSize;
    private final long refillRate;
    private final long currentBucketSize;
    private final long lastRefillTime;

    public TokenBucketThrottleStrategy(long maxBucketSize , long refillRate){
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        this.currentBucketSize = maxBucketSize;
        this.lastRefillTime = System.nanoTime();
    }


    @Override
    public Boolean isRequestAllowed(long token) {

    }
}
