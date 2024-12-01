package com.jatin.designpatterns.strategypattern;

import com.jatin.designpatterns.strategypattern.Car;
import com.jatin.designpatterns.strategypattern.strategy.DriveStrategy;
import com.jatin.designpatterns.strategypattern.strategy.EconomyDriveStrategy;

public class CityCar extends Car {
    public CityCar(){
        super(new EconomyDriveStrategy());
    }
}
