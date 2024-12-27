package com.jatin.parkinglot.model;

import com.jatin.parkinglot.enums.PARKING_SPOT_TYPE;

public class BikeParkingSpot extends ParkingSpot{
    double perHourPrice;

    public BikeParkingSpot(String parkingSpotId) {
        super(parkingSpotId, PARKING_SPOT_TYPE.Bike);
    }

    public void setPerHourPrice(double perHourPrice){
        this.perHourPrice = perHourPrice;
    }
    public double getPerHourPrice() {
        return perHourPrice;
    }
}
