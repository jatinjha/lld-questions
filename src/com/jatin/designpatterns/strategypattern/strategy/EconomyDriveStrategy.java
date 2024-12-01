package com.jatin.designpatterns.strategypattern.strategy;

public class EconomyDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("economy drive strategy");
    }
}
