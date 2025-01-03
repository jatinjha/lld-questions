package com.jatin.carrental.models;

public class Car extends Vehicle{
    @Override
    public int getDailyRentalCost() {
        return 100;
    }

    @Override
    public int getHourlyRentalCost() {
        return 20;
    }
}
