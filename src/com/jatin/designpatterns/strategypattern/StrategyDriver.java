package com.jatin.designpatterns.strategypattern;

import com.jatin.designpatterns.strategypattern.strategy.EconomyDriveStrategy;
import com.jatin.designpatterns.strategypattern.strategy.SportsDriveStrategy;

public class StrategyDriver {

    public static void main(String[] args) {
        Car sportsCar = new SportsCar();
        Car offRoadingCar = new OffRoadCar();
        Car cityCar = new CityCar();

        sportsCar.drive();
        offRoadingCar.drive();
        cityCar.drive();
    }
}
