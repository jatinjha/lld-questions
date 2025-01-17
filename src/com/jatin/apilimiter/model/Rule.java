package com.jatin.apilimiter.model;

import java.util.UUID;

public class Rule {
    String id;
    long refillRate;
    int allowedRequestValue;

    public Rule(long refillRate, int allowedRequestValue) {
        this.refillRate = refillRate;
        this.allowedRequestValue = allowedRequestValue;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public long getRefillRate() {
        return refillRate;
    }

    public int getAllowedRequestValue() {
        return allowedRequestValue;
    }
}
