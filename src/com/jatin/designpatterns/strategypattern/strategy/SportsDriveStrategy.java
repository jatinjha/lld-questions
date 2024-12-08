package com.jatin.designpatterns.strategypattern.strategy;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("sports drive strategy");
    }
}