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

    public Boolean checkValidRequest(Client client , Identifier identifier){
        // validate identifer
        try {
            if (ruleService.isValidIdentifier(client, identifier)) {
                return throttleStrategy.isRequestAllowed();
            }

        }catch (Exception exception){
            System.out.println("exception occured in rate limiter service");
        }
        return true;
    }
}
