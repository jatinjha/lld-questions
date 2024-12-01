package com.jatin.designpatterns.strategypattern;

import com.jatin.designpatterns.strategypattern.strategy.DriveStrategy;
import com.jatin.designpatterns.strategypattern.strategy.SportsDriveStrategy;

public class SportsCar extends Car{
    public SportsCar(){
        super(new SportsDriveStrategy());
    }
}
