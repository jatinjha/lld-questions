package com.jatin.parkinglot.model;

import com.jatin.parkinglot.enums.PARKING_SPOT_TYPE;

public class CardParkingSpot extends ParkingSpot{

    double perHourPrice;
    public CardParkingSpot(String parkingSpotId,double perHourPrice) {
        super(parkingSpotId, PARKING_SPOT_TYPE.CarParking);
        this.perHourPrice = perHourPrice;
    }

    public double getPerHourPrice(){
        return this.perHourPrice;
    }
}
