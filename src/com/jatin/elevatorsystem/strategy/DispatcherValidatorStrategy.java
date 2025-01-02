package com.jatin.elevatorsystem.strategy;

public interface DispatcherValidatorStrategy {
    public void addValidationRules(String elevatorId, String rule , String floorIds);
    public boolean checkDestinationValidity(String elevatorId , String rule , String floorIds);
}
