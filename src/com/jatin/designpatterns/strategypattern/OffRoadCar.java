package com.jatin.designpatterns.strategypattern;

import com.jatin.designpatterns.strategypattern.strategy.DriveStrategy;
import com.jatin.designpatterns.strategypattern.strategy.SportsDriveStrategy;

public class OffRoadCar extends Car{
    public OffRoadCar(){
        super(new SportsDriveStrategy());
    }
}
