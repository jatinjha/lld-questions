package com.jatin.parkinglot.model;

import com.jatin.parkinglot.enums.PARKING_SPOT_TYPE;

import java.util.UUID;

public class ParkingSpot {
    String parkingSpotId;
    Boolean isSpotAvailable;
    Vehicle vehicle;
    PARKING_SPOT_TYPE parkingSpotType;
    double parkingPrice;

    public ParkingSpot(PARKING_SPOT_TYPE parkingSpotType,double parkingPrice) {
        this.parkingSpotId = UUID.randomUUID().toString();
        this.parkingSpotType = parkingSpotType;
        this.parkingPrice = parkingPrice;
    }

    public Boolean getSpotAvailable() {
        return isSpotAvailable;
    }

    public void setSpotAvailable(Boolean spotAvailable) {
        isSpotAvailable = spotAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void parkVehicle(Vehicle vehicle){
        setVehicle(vehicle);
        setSpotAvailable(false);
    }

    public void unParkVehicle(){
        setVehicle(null);
        setSpotAvailable(true);
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }


    public PARKING_SPOT_TYPE getParkingSpotType() {
        return parkingSpotType;
    }

    public double getParkingPrice() {
        return this.parkingPrice;
    }
}
