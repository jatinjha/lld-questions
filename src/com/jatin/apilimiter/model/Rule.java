package com.jatin.apilimiter.model;

import java.util.UUID;

public class Rule {
    String id;
    double ruleValue;

    public Rule(double ruleValue) {
        this.ruleValue = ruleValue;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public double getRuleValue() {
        return ruleValue;
    }
}
