package com.jatin.apilimiter.services;

import com.jatin.apilimiter.model.Client;
import com.jatin.apilimiter.model.Identifier;
import com.jatin.apilimiter.model.Rule;
import com.jatin.apilimiter.strategies.ThrottleStrategy;
import com.jatin.apilimiter.strategies.TokenBucketThrottleStrategy;

public class RateLimiterService {
    ThrottleStrategy throttleStrategy;
    RuleService ruleService;

    public RateLimiterService(ThrottleStrategy throttleStrategy){
        this.throttleStrategy =throttleStrategy;
        this.ruleService = new RuleService();
    }

    public synchronized Boolean checkValidRequest(Client client , Identifier identifier){
        System.out.println("Thread enter in rl service "+Thread.currentThread().getName());
        try {
            if (ruleService.isValidIdentifier(client, identifier)) {
                return throttleStrategy.isRequestAllowed(identifier.getId());
            }

        }catch (Exception exception){
            System.out.println("exception occured in rate limiter service");
        }
        return true;
    }
}
