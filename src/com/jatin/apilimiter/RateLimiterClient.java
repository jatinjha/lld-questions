package com.jatin.apilimiter;

import com.jatin.apilimiter.factories.RateLimiterFactory;
import com.jatin.apilimiter.model.Client;
import com.jatin.apilimiter.model.Identifier;
import com.jatin.apilimiter.model.Rule;
import com.jatin.apilimiter.services.RateLimiterService;
import com.jatin.apilimiter.services.RuleService;
import com.jatin.apilimiter.strategies.ThrottleStrategy;
import com.jatin.apilimiter.strategies.TokenBucketThrottleStrategy;

public class RateLimiterClient {
    public static void main(String[] args) {
        System.out.println("rate limiter program starts ");
        Client client = RateLimiterFactory.getClient("client1");
        Rule rule = RateLimiterFactory.getRule(10d);
        Identifier identifier = RateLimiterFactory.getIdentifier("api_key");
        TokenBucketThrottleStrategy tokenBucketThrottleStrategy = RateLimiterFactory.getTokenBucketThrottleStrategy(5,4);
        RuleService ruleService = RateLimiterFactory.getRuleService();
        RateLimiterService rateLimiterService = RateLimiterFactory.getRateLimiterService(tokenBucketThrottleStrategy);
        try {
            ruleService.addRule(client,identifier,rule);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("is valid request : - "+rateLimiterService.checkValidRequest(client,identifier));
        System.out.println("rate limiter program starts ");
    }
}
