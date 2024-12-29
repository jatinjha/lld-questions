package com.jatin.parkinglot.model;

import com.jatin.parkinglot.enums.PARKING_SPOT_TYPE;

import java.util.UUID;

public class CardParkingSpot extends ParkingSpot{

    double perHourPrice;
    public CardParkingSpot() {
        super(PARKING_SPOT_TYPE.CarParking,20d);
    }

    public double getPerHourPrice(){
        return this.perHourPrice;
    }
}
