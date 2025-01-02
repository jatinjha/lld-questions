package com.jatin.elevatorsystem.strategy;

import java.util.HashMap;
import java.util.Map;

public class AllDispatcherValidatorStrategy implements DispatcherValidatorStrategy{
    private Map<String, Map<String,String>> elevatorVsRuleVsFloors;

    public AllDispatcherValidatorStrategy(){
        elevatorVsRuleVsFloors = new HashMap<>();
    }

    @Override
    public void addValidationRules(String elevatorId , String rule , String floorIds) {
        Map<String,String> ruleVsFloors = elevatorVsRuleVsFloors.getOrDefault(elevatorId,new HashMap<>());
        ruleVsFloors.put(rule,floorIds);
        elevatorVsRuleVsFloors.put(elevatorId,ruleVsFloors);
    }

    @Override
    public boolean checkDestinationValidity(String elevatorId, String rule, String floorIds) {
        return true;
    }
}
