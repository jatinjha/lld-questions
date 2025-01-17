package com.jatin.apilimiter.strategies;

import com.jatin.apilimiter.model.Rule;

public interface ThrottleStrategy {
    public Boolean isRequestAllowed(String identifier);
}
