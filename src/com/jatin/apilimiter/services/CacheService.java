package com.jatin.apilimiter.services;

import com.jatin.apilimiter.factories.RateLimiterFactory;
import com.jatin.apilimiter.model.Client;
import com.jatin.apilimiter.model.Identifier;
import com.jatin.apilimiter.model.Rule;

public class CacheService {
    private static Rule rule;

    public Rule getRule(){
        return rule;
    }
    public void setRule(Rule rule){
        this.rule = rule;
    }
//    public Rule getConfiguredRulesAgainstIdentifier(Client client , Identifier identifier){
//        return RateLimiterFactory.getRule(2,10);
//        //return rule;
//    }
}
