package com.jatin.apilimiter.strategies;

public interface ThrottleStrategy {
    public Boolean isRequestAllowed();
}
