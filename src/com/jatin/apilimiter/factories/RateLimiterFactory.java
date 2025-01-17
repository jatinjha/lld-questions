package com.jatin.apilimiter.factories;

import com.jatin.apilimiter.model.Client;
import com.jatin.apilimiter.model.Identifier;
import com.jatin.apilimiter.model.Rule;
import com.jatin.apilimiter.services.CacheService;
import com.jatin.apilimiter.services.RateLimiterService;
import com.jatin.apilimiter.services.RuleService;
import com.jatin.apilimiter.strategies.SlidingWindowCounterStrategy;
import com.jatin.apilimiter.strategies.ThrottleStrategy;
import com.jatin.apilimiter.strategies.TokenBucketThrottleStrategy;

import java.time.Clock;

public class RateLimiterFactory {
    public static Client getClient(String clientName){
        return new Client(clientName);
    }

    public static Rule getRule(long refillRate , int allowedRequestValue){
        return new Rule(refillRate,allowedRequestValue);
    }

    public static Identifier getIdentifier(String identifierKey){
        return new Identifier(identifierKey);
    }

    public static RuleService getRuleService(){
        return new RuleService();
    }

    public static RateLimiterService getRateLimiterService(ThrottleStrategy throttleStrategy){
        return new RateLimiterService(throttleStrategy);
    }

    public static CacheService getCacheService(){
        return new CacheService();
    }
    public static TokenBucketThrottleStrategy getTokenBucketThrottleStrategy(long maxBucketSize , long refillRate){
        return new TokenBucketThrottleStrategy(maxBucketSize,refillRate);
    }

    public static SlidingWindowCounterStrategy getSlidingWindowThrottleStrategy(int maxBucketSize , long refillRate){
        Clock clock = Clock.systemDefaultZone();
        return new SlidingWindowCounterStrategy(maxBucketSize,refillRate,clock);
    }
}
