package com.jatin.designpatterns.strategypattern;

import com.jatin.designpatterns.strategypattern.strategy.DriveStrategy;

public class Car {
    public DriveStrategy driveStrategy;

    public Car(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }
}
